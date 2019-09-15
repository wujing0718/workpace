package com.huohougongfu.app.WoDe.Fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ShopDingDan;
import com.huohougongfu.app.Gson.ZhuanKeVIP;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.XiaDanActivity;
import com.huohougongfu.app.Shop.Fragment.SouSuoShopFragment;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.GlideImageLoader;
import com.huohougongfu.app.Utils.utils;
import com.huohougongfu.app.WoDe.Activity.AddressActivity;
import com.kongzue.dialog.v2.SelectDialog;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhuanKeFragment extends Fragment implements View.OnClickListener{


    private View inflate;
    private ZhuanKeVIP.ResultBean.EarnPordutBean earnpordutbean;
    private Banner banner;
    private List<String> mbanner = new ArrayList<>();
    private TextView tv_introduce;

    public ZhuanKeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        inflate = inflater.inflate(R.layout.fragment_zhuan_ke, container, false);
        earnpordutbean = (ZhuanKeVIP.ResultBean.EarnPordutBean )getArguments().getSerializable("ARGS");
        inflate.findViewById(R.id.bt_lijikaitong).setOnClickListener(this);
        initUI();
        return inflate;
    }

    private void initUI() {
        String pic = earnpordutbean.getPic();
        String[] split = pic.split(",");
        for (int i = 0; i < split.length; i++) {
            mbanner.add(split[i]);
        }
        banner = inflate.findViewById(R.id.banner);
        tv_introduce = inflate.findViewById(R.id.tv_introduce);
        //加载网络图片
        banner.setImages(mbanner)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImageLoader(new GlideImageLoader())
                .start();
        tv_introduce.setText(earnpordutbean.getIntroduce());
    }

    public static Fragment newInstance(ZhuanKeVIP.ResultBean.EarnPordutBean content) {
        Bundle args = new Bundle();
        args.putSerializable("ARGS", content);
        ZhuanKeFragment fragment = new ZhuanKeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_lijikaitong:
                if (!utils.isDoubleClick()){
                    initGouMai();
                }
                break;
        }
    }

    private void initGouMai() {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("createBy",String.valueOf(MyApp.instance.getInt("id")));
            jsonObject.put("productId",String.valueOf(earnpordutbean.getId()));
            jsonObject.put("standardId",String.valueOf(earnpordutbean.getStandardId()));
            jsonObject.put("productNum",String.valueOf(1));
            jsonObject.put("ofEarnProduct",String.valueOf(1));
            jsonArray.put(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        OkGo.<String>post(Contacts.URl1+"confirmOrder1")
                .params("json",jsonArray.toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        String body = response.body();
                        try {
                            JSONObject jsonObject1 = new JSONObject(body);
                            String result = jsonObject1.getString("result");
                            JSONObject result2 = new JSONObject(result);
                            if ("你还未设置地址".equals(result2.getString("defaultAddress"))){
                                SelectDialog.show(getActivity(), "提示", "是否前往设置收货地址",
                                        "确定", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent intent = new Intent();
                                                intent.setClass(getActivity(), AddressActivity.class);
                                                getActivity().startActivity(intent);
                                            }
                                        },
                                        "取消", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                            }
                                        });
                            }else{
                                Gson gson = new Gson();
                                ShopDingDan shopDingDan = gson.fromJson(body, ShopDingDan.class);
                                if (shopDingDan.getStatus() == 1){
                                    Intent intent = new Intent();
                                    intent.putExtra("订单详情",(Serializable) shopDingDan.getResult());
                                    intent.setClass(getActivity(),XiaDanActivity.class);
                                    getActivity().startActivity(intent);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(),"请稍后。。。");
                        super.onStart(request);
                    }
                });
    }
}
