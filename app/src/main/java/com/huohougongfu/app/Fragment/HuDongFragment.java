package com.huohougongfu.app.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.huohougongfu.app.Activity.HuDongDianZanActivity;
import com.huohougongfu.app.Activity.HuDongPingLunActivity;
import com.huohougongfu.app.Gson.WeiDuXiaoXI;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.IListener;
import com.huohougongfu.app.Utils.ListenerManager;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import q.rorbin.badgeview.QBadgeView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HuDongFragment extends Fragment implements View.OnClickListener ,IListener {


    private View inflate;
    private Intent intent;
    private QBadgeView pinglunBadgeView,dianzanBadgeView;
    private ImageView img_pinglun,img_dianzan;

    public HuDongFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_hu_dong, container, false);
        intent = new Intent();
        ListenerManager.getInstance().registerListtener(this);
        pinglunBadgeView = new QBadgeView(getActivity());
        dianzanBadgeView = new QBadgeView(getActivity());
        initUI();
        return inflate;
    }

    private void initUI() {
        img_pinglun = inflate.findViewById(R.id.img_pinglun);
        img_dianzan = inflate.findViewById(R.id.img_dianzan);
        inflate.findViewById(R.id.bt_pinglun).setOnClickListener(this);
        inflate.findViewById(R.id.bt_dianzan).setOnClickListener(this);
    }

    @Override
    public void onResume() {
        initNoticeIsView();
        super.onResume();
    }

    private void initNoticeIsView() {
        OkGo.<String>post(Contacts.URl1+"/circle/noticeIsView")
                .params("mId", MyApp.instance.getInt("id"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        WeiDuXiaoXI weiduxiaoxi = new Gson().fromJson(body, WeiDuXiaoXI.class);
                        if (weiduxiaoxi.getStatus() == 1){
                            if (weiduxiaoxi.getResult().isComments()){
                                pinglunBadgeView.bindTarget(img_pinglun).setBadgeText("");
                            }else{
                                pinglunBadgeView.hide(false);
                            }
                            if (weiduxiaoxi.getResult().isPraise()){
                                dianzanBadgeView.bindTarget(img_dianzan).setBadgeText("");
                            }else{
                                dianzanBadgeView.hide(false);
                            }
                        }
                    }
                });
    }


    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        HuDongFragment fragment = new HuDongFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_dianzan:
                ListenerManager.getInstance().sendBroadCast(21,"查看");
                intent.setClass(getActivity(),HuDongDianZanActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_pinglun:
                ListenerManager.getInstance().sendBroadCast(21,"查看");
                intent.setClass(getActivity(),HuDongPingLunActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void notifyAllActivity(int audience_cnt, String status) {

    }
}
