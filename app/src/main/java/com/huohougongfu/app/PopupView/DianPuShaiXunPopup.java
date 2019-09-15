package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.huohougongfu.app.R;
import com.lxj.xpopup.core.DrawerPopupView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DianPuShaiXunPopup extends DrawerPopupView implements View.OnClickListener{
    public String fenlei;
    public String haoping;
    public String fahuodi;
    private Context context;
    private Handler mHandler;
    private TagFlowLayout id_flowlayout_fenlei,id_flowlayout_haoping,id_flowlayout_fahuodi;
    private TagAdapter<String> adapter1;
    private TagAdapter<String> adapter2;
    private TagAdapter<String> adapter3;
    private Map<String,String> map = new HashMap<>();


    public DianPuShaiXunPopup(@NonNull Context context, Handler mHandler) {
        super(context);
        this.context = context;
        this.mHandler = mHandler;
    }


    @Override
    protected int getImplLayoutId() {
        return R.layout.shaixuan_dianpu_popup;
    }
    @Override
    protected void onCreate() {
        super.onCreate();
        findViewById(R.id.bt_queding).setOnClickListener(this);
        findViewById(R.id.bt_chongzhi).setOnClickListener(this);
         id_flowlayout_fenlei = findViewById(R.id.id_flowlayout_fenlei);
        id_flowlayout_haoping = findViewById(R.id.id_flowlayout_haoping);
        id_flowlayout_fahuodi = findViewById(R.id.id_flowlayout_fahuodi);
        List<String> datas_fenlei = new ArrayList<>();
        List<String> datas_fahuodi = new ArrayList<>();
        List<String> datas_haoping = new ArrayList<>();

        datas_fenlei.add("特约品牌");
        datas_fenlei.add("入驻店铺");

        datas_fahuodi.add("北京");
        datas_fahuodi.add("上海");
        datas_fahuodi.add("深圳");
        datas_fahuodi.add("广州");
        datas_fahuodi.add("潮汕");
        datas_fahuodi.add("惠州");
        datas_fahuodi.add("南京");

        datas_haoping.add("98%以上");
        datas_haoping.add("98%-95%");
        datas_haoping.add("95%-90%");
        datas_haoping.add("其他");
        adapter1 = new TagAdapter<String>(datas_fenlei) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                TextView view = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.item_tag, parent,false);
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
                    if (pos == 0){
                        fenlei ="1";
                    }else if (pos == 1){
                        fenlei ="0";
                    }
                }else{
                    fenlei = "";
                }
            }
        });
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
        adapter3 = new TagAdapter<String>(datas_haoping) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                TextView view = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.item_fahuodi, parent,false);
                view.setText(o);
                return view;
            }
        };
        id_flowlayout_haoping.setAdapter(adapter3);
        id_flowlayout_haoping.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> selectPosSet) {
                String replace = selectPosSet.toString().replace("[", "");
                String s = replace.replaceAll("]", "");
                if (!s.equals("")){
                    Integer pos = Integer.valueOf(s);
                    if (pos == 0){
                        haoping ="1";
                    }else if (pos == 1){
                        haoping ="2";
                    }else if (pos == 2){
                        haoping ="3";
                    }else if (pos == 3){
                        haoping ="4";
                    }
                }else{
                    haoping = "";
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_chongzhi:
                fenlei = "";
                fahuodi = null;
                haoping = "";
                id_flowlayout_fahuodi.setAdapter(adapter2);
                id_flowlayout_fenlei.setAdapter(adapter1);
                id_flowlayout_haoping.setAdapter(adapter3);
                break;
            case R.id.bt_queding:
                map.clear();
                if("1".equals(String.valueOf(fenlei))){
                    map.put("storeType",String.valueOf(1));
                }else if ("0".equals(String.valueOf(fenlei))){
                    map.put("storeType",String.valueOf(0));
                }
                if ("1".equals(String.valueOf(haoping))){
                    map.put("goodAppraiseRateParams",String.valueOf(1));
                }else if ("2".equals(String.valueOf(haoping))){
                    map.put("goodAppraiseRateParams",String.valueOf(2));
                }else if ("3".equals(String.valueOf(haoping))){
                    map.put("goodAppraiseRateParams",String.valueOf(3));
                }else if ("4".equals(String.valueOf(haoping))){
                    map.put("goodAppraiseRateParams",String.valueOf(4));
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