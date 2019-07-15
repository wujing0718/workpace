package com.huohougongfu.app.Fragment;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.huohougongfu.app.Gson.RongYunUsetInfo;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.concurrent.CountDownLatch;

import io.rong.imkit.RongIM;
import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.UserInfo;

/**
 * A simple {@link Fragment} subclass.
 */
public class SiLiaoFragment extends Fragment {


    private RongYunUsetInfo rongYunUsetInfo;
    private UserInfo userInfo;

    public SiLiaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_si_liao, container, false);
        //会话列表
        ConversationListFragment conversationListFragment = new ConversationListFragment();
        Uri uri = Uri.parse("rong://" + getActivity().getApplicationInfo().packageName).buildUpon()
                .appendPath("conversationlist")
                .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false") //设置私聊会话，该会话聚合显示
//                .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "false")//设置系统会话，该会话非聚合显示
                .build();
        conversationListFragment.setUri(uri);
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.rong_container,conversationListFragment);
        transaction.commit();
        RongIM.setUserInfoProvider(new RongIM.UserInfoProvider() {

            @Override
            public UserInfo getUserInfo(String userId) {

                return findUserById(userId);//根据 userId 去你的用户系统里查询对应的用户信息返回给融云 SDK。
            }
        }, true);


        return inflate;
    }

    private UserInfo findUserById(String userId) {
        final CountDownLatch latch = new CountDownLatch(1);
        OkGo.<String>get(Contacts.URl1+"/member/rongInfo/"+userId)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        RongYunUsetInfo rongYunUsetInfo = gson.fromJson(body, RongYunUsetInfo.class);
                        if(rongYunUsetInfo.getStatus() == 1) {
                            if (rongYunUsetInfo.getResult().getNickName()!=null){
                                userInfo = new UserInfo(rongYunUsetInfo.getResult().getPhone(), rongYunUsetInfo.getResult().getNickName(), Uri.parse(rongYunUsetInfo.getResult().getPhoto()));
                            }else if (rongYunUsetInfo.getResult().getNickName()==null){
                                userInfo = new UserInfo(rongYunUsetInfo.getResult().getPhone(), rongYunUsetInfo.getResult().getPhone(), Uri.parse(rongYunUsetInfo.getResult().getPhoto()));
                            }
                            RongIM.getInstance().refreshUserInfoCache(userInfo);
                            latch.countDown();
                        }
                    }
                });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        SiLiaoFragment fragment = new SiLiaoFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
