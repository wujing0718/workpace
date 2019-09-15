package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.DaShiFenLei;
import com.huohougongfu.app.Gson.ShopFenLei;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.lxj.xpopup.core.DrawerPopupView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShaiXuanDaShiView extends DrawerPopupView implements View.OnClickListener {
    private final Handler mHandler;
    private List<String> masterCategory;
    List<String> datas_fenlei = new ArrayList<>();
    List<String> datas_fahuodi = new ArrayList<>();
    private Map<String,String> map = new HashMap<>();
    private TagFlowLayout  id_flowlayout_fenlei;
    private String name;
    private String fahuodi;
    private TagAdapter<String> adapter2;
    private TagAdapter<String> adapter1;
    private TagFlowLayout id_flowlayout_fahuodi;

    public ShaiXuanDaShiView(@NonNull Context context, Handler mHandler) {
        super(context);
        this.mHandler = mHandler;
    }
    @Override
    protected int getImplLayoutId() {
        return R.layout.shaixuan_dashi_popup;
    }
    @Override
    protected void onCreate() {
        super.onCreate();
        initData();
        id_flowlayout_fenlei = findViewById(R.id.id_flowlayout_fenlei);
        findViewById(R.id.bt_chongzhi).setOnClickListener(this);
        findViewById(R.id.bt_queding).setOnClickListener(this);
        id_flowlayout_fahuodi = findViewById(R.id.id_flowlayout_fahuodi);
        datas_fahuodi.add("北京");
        datas_fahuodi.add("上海");
        datas_fahuodi.add("深圳");
        datas_fahuodi.add("广州");
        datas_fahuodi.add("潮汕");
        datas_fahuodi.add("惠州");
        datas_fahuodi.add("南京");
        adapter2 = new TagAdapter<String>(datas_fahuodi) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                TextView view = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.item_fahuodi, parent,false);
                view.setText(o);
                return view;
            }
        };
        id_flowlayout_fahuodi.setAdapter(adapter2);
        id_flowlayout_fahuodi.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> selectPosSet) {
                String replace = selectPosSet.toString().replace("[", "");
                String s = replace.replaceAll("]", "");
                if (!s.equals("")){
                    Integer pos = Integer.valueOf(s);
                    fahuodi = datas_fahuodi.get(pos);
                }else{
                    fahuodi = null;
                }
            }
        });
        
    }

    private void initData() {
        OkGo.<String>get(Contacts.URl2 + "query/getCategoryFilter")
                .params("typeName", "masterCategory")
                .execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String body = response.body();
                DaShiFenLei shopFenLei = new Gson().fromJson(body, DaShiFenLei.class);
                if (shopFenLei.getStatus() == 1) {
                    List<String> masterCategory = shopFenLei.getResult().getMasterCategory();
                    if (masterCategory.size() > 0) {
                        for (int i = 0; i < masterCategory.size(); i++) {
                            datas_fenlei.add(masterCategory.get(i));
                        }
                        adapter1 = new TagAdapter<String>(datas_fenlei) {
                            @Override
                            public View getView(FlowLayout parent, int position, String o) {
                                TextView view = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.item_tag, parent, false);
                                view.setText(o);
                                return view;
                            }
                        };
                        id_flowlayout_fenlei.setAdapter(adapter1);
                        id_flowlayout_fenlei.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
                            @Override
                            public void onSelected(Set<Integer> selectPosSet) {
                                String replace = selectPosSet.toString().replace("[", "");
                                String s = replace.replaceAll("]", "");
                                if (!s.equals("")){
                                    Integer pos = Integer.valueOf(s);
                                    name = datas_fenlei.get(pos);
                                }else{
                                    name = null;
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_chongzhi:
                name = null;
                fahuodi = null;
                id_flowlayout_fahuodi.setAdapter(adapter2);
                id_flowlayout_fenlei.setAdapter(adapter1);
                break;
            case R.id.bt_queding:
                map.clear();
                    if (name !=null){
                        map.put("masterCatory",name);
                    }
                    if (fahuodi !=null){
                        map.put("address",fahuodi);
                    }
                    if (map.size()<1){
                        dismiss();
                    }
                        Message msg = Message.obtain();
                        msg.what = 0;
                        msg.obj = map;
                        mHandler.sendMessage(msg);
                        dismiss();

                break;
        }
    }
}