package com.huohougongfu.app.QuanZi.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.LoginActivity;
import com.huohougongfu.app.Gson.QuanZiFaXian;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Activity.QuanZiDetailActivity;
import com.huohougongfu.app.QuanZi.Activity.VedioDetailActivity;
import com.huohougongfu.app.QuanZi.Activity.WenZhangActivity;
import com.huohougongfu.app.QuanZi.Activity.WenZhangDetailActivity;
import com.huohougongfu.app.QuanZi.Adapter.FaXianAdapter;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.IListener;
import com.huohougongfu.app.Utils.ListenerManager;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.lzy.okgo.utils.HttpUtils.runOnUiThread;

/**
 * A simple {@link Fragment} subclass.
 */
public class TongChengFragment extends Fragment implements IListener {


    private View inflate;
    private RecyclerView rec_faxian;
    private String channel;
    private SmartRefreshLayout smartrefreshlayout;
    private int mId;
    private String token;
    private int page = 2;
    private FaXianAdapter faXianAdapter;
    private Intent intent;
    private String citycode;

    public TongChengFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ListenerManager.getInstance().registerListtener(this);
        inflate = inflater.inflate(R.layout.fragment_tong_cheng, container, false);
        mId = MyApp.instance.getInt("id");
        token = MyApp.instance.getString("token");
        intent = new Intent();
        channel = getArguments().getString("ARGS");
        initUI();
        initData("");
        return inflate;
    }

    private void initData(String condition) {
        Map<String, String> map = new HashMap<>();
        //搜索
        if (!condition.isEmpty()){
            map.put("condition",condition);
        }
        if (citycode!=null){
            map.put("cityCode",citycode);
        }else{
            map.put("cityCode",channel);
        }
        map.put("pageNo","1");
        map.put("mId",String.valueOf(mId));
        map.put("pageSize","10");
        map.put("token",token);
        OkGo.<String>post(Contacts.URl1+"/circle/data")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        smartrefreshlayout.finishRefresh();
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        QuanZiFaXian faxian = gson.fromJson(response.body(), QuanZiFaXian.class);
                        if (faxian.getStatus() == 1) {
                            if (faxian.getResult().getDatas().getList().size()>0){
                                smartrefreshlayout.setVisibility(View.VISIBLE);
                                initRec(faxian);
                            }else{
                                smartrefreshlayout.setVisibility(View.GONE);
                            }
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
//                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initRec(QuanZiFaXian faxian) {
        // 创建StaggeredGridLayoutManager实例
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //防止item 交换位置
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        // 绑定布局管理器
        rec_faxian.setLayoutManager(layoutManager);
        faXianAdapter = new FaXianAdapter(R.layout.item_quanzi_faxian,faxian.getResult().getDatas().getList());
        rec_faxian.setAdapter(faXianAdapter);
        faXianAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (!token.isEmpty()){
                    if (faxian.getResult().getDatas().getList().get(position).getType() == 2){
                        intent.putExtra("dId",faxian.getResult().getDatas().getList().get(position).getId());
                        intent.putExtra("userid",faxian.getResult().getDatas().getList().get(position).getMember().getUserId());
                        startActivity(intent.setClass(getActivity(),WenZhangDetailActivity.class));
                    }else if(faxian.getResult().getDatas().getList().get(position).getType() == 1){
                        intent.putExtra("userid",faxian.getResult().getDatas().getList().get(position).getMember().getUserId());
                        intent.putExtra("dId",faxian.getResult().getDatas().getList().get(position).getId());
                        startActivity(intent.setClass(getActivity(),QuanZiDetailActivity.class));
                    }else if (faxian.getResult().getDatas().getList().get(position).getType() == 3){
                        intent.putExtra("userid",faxian.getResult().getDatas().getList().get(position).getMember().getUserId());
                        intent.putExtra("小视频",faxian.getResult().getDatas().getList().get(position));
                        intent.putExtra("position",position);
                        intent.putExtra("dId",faxian.getResult().getDatas().getList().get(position).getId());
                        startActivity(intent.setClass(getActivity(),VedioDetailActivity.class));
                    }
                }else{
                    ToastUtils.showShort(R.string.denglu);
                    intent.setClass(getActivity(),LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        faXianAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ImageView img_faixan_shoucang = view.findViewById(R.id.img_faixan_shoucang);
                TextView tv_dianzan_num = view.findViewById(R.id.tv_xihuan_num);
                if (!token.isEmpty()){
                    if (faxian.getResult().getDatas().getList().get(position).getIsPraise() == 0){
                        initDianZan("1",faxian.getResult().getDatas().getList().get(position),img_faixan_shoucang,tv_dianzan_num);
                    }else{
                        if (!utils.isDoubleClick()){
                            initQuXiaoDianZan("0",faxian.getResult().getDatas().getList().get(position),img_faixan_shoucang,tv_dianzan_num);
                        }
                    }
                }else{
                    ToastUtils.showShort(R.string.denglu);
                    intent.setClass(getActivity(),LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        //刷新
        smartrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                initData("");
                page = 2;
            }
        });
        //加载更多
        smartrefreshlayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                initAdd();
            }
        });
    }

    private void initAdd() {
        Map<String, String> map = new HashMap<>();
        map.put("pageNo",String.valueOf(page++));
        map.put("cityCode",MyApp.instance.getString("citycode"));
        map.put("mId",String.valueOf(mId));
        map.put("pageSize","10");
        map.put("token",token);
        OkGo.<String>post(Contacts.URl1+"/circle/data")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        smartrefreshlayout.finishRefresh();
                        WaitDialog.dismiss();
                        String body = response.body();
                        Gson gson = new Gson();
                        QuanZiFaXian faxian = gson.fromJson(body, QuanZiFaXian.class);
                        if (faxian.getResult().getDatas().getList().size()>0){
                            faXianAdapter.add(faxian.getResult().getDatas().getList());
                            smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                        }else {
                            smartrefreshlayout. finishLoadMore();
                        }
                    }
                });
    }

    //取消点赞
    private void initQuXiaoDianZan(String type, QuanZiFaXian.ResultBean.DatasBean.ListBean listBean, ImageView img_faixan_shoucang, TextView tv_dianzan_num) {
        Map<String,String> map = new HashMap<>();
        map.put("type",type);
        map.put("dataId",String.valueOf(listBean.getId()));
        map.put("mId",String.valueOf(mId));
        map.put("token",token);

        OkGo.<String>post(Contacts.URl1+"/circle/praise")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                String num = tv_dianzan_num.getText().toString();
                                Integer integer = Integer.valueOf(num);
                                tv_dianzan_num.setText(String.valueOf(integer-1));
                                listBean.setIsPraise(0);
                                img_faixan_shoucang.setImageResource(R.mipmap.img_xihuan);
                                ToastUtils.showShort("取消点赞");
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    //点赞
    private void initDianZan(String type, QuanZiFaXian.ResultBean.DatasBean.ListBean listBean, ImageView img_faixan_shoucang, TextView tv_dianzan_num) {
        String num = tv_dianzan_num.getText().toString();
        Map<String,String> map = new HashMap<>();
        map.put("type",type);
        map.put("dataId",String.valueOf(listBean.getId()));
        map.put("mId",String.valueOf(mId));
        map.put("token",token);
        OkGo.<String>post(Contacts.URl1+"/circle/praise")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                ToastUtils.showShort("点赞成功");
                                Integer integer = Integer.valueOf(num);
                                tv_dianzan_num.setText(String.valueOf(integer+1));
                                listBean.setIsPraise(1);
                                img_faixan_shoucang.setImageResource(R.mipmap.img_xihuan2);
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void initUI() {
        smartrefreshlayout = inflate.findViewById(R.id.smartrefreshlayout);
        rec_faxian = inflate.findViewById(R.id.rec_faxian);
    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        TongChengFragment fragment = new TongChengFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void notifyAllActivity(int audience_cnt, String status) {
        if(audience_cnt == 3){
            initData(status);
        }else if (audience_cnt == 1001){
            citycode = status;
            initData("");
        }
    }
}
