package com.huohougongfu.app.WoDe.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.MyCollect;
import com.huohougongfu.app.Gson.StoreEvents;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.WoDe.Adapter.DianPuHuoDongAdapter;
import com.huohougongfu.app.WoDe.Adapter.MyColleAdapter;
import com.kongzue.dialog.v2.SelectDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DianPuMainJianActivity extends AppCompatActivity implements View.OnClickListener ,DianPuHuoDongAdapter.OnItemClickListener{

    private View view_collect;
    private View ll_mycollection_bottom_dialog;
    private TextView tv_guanli,tv_select_all;
    private Button mBtnDelete;
    private RecyclerView rec_dianpu_huodong;
    private View select_all;
    private ImageView img_select_all;
    private DianPuHuoDongAdapter dianpuhuodongadapter;
    private static final int MYLIVE_MODE_CHECK = 0;
    private static final int MYLIVE_MODE_EDIT = 1;
    private int mEditMode = MYLIVE_MODE_CHECK;
    private boolean isSelectAll = false;
    private boolean editorStatus = false;
    private int index = 0;
    private TextView bt_dianpu_tianjia_huodong;
    private StoreEvents myCollect;
    private View view_zhanweitu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dian_pu_main_jian);
        initUI();
    }

    @Override
    protected void onStart() {
        initData();
        super.onStart();
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        OkGo.<String>get(Contacts.URl1+"/store/activeList/"+MyApp.instance.getInt("id"))
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        myCollect = gson.fromJson(body, StoreEvents.class);
                        if (myCollect.getStatus() == 1){
                            if (myCollect.getResult().size()<=0){
                                setBtnBackground(0);
                                tv_guanli.setText("管理");
                                bt_dianpu_tianjia_huodong.setVisibility(View.VISIBLE);
                                view_zhanweitu.setVisibility(View.VISIBLE);
                                ll_mycollection_bottom_dialog.setVisibility(View.GONE);
                                view_collect.setVisibility(View.GONE);
                            }else{
                                view_zhanweitu.setVisibility(View.GONE);
                                view_collect.setVisibility(View.VISIBLE);
                                initRec(myCollect.getResult());
                            }
                        }
                    }
                });
    }

    private void initRec(List<StoreEvents.ResultBean> list) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        //设置RecyclerView 布局
        rec_dianpu_huodong.setLayoutManager(layoutmanager);
        dianpuhuodongadapter = new DianPuHuoDongAdapter(this);
        dianpuhuodongadapter.notifyAdapter(list,false);
        rec_dianpu_huodong.setAdapter(dianpuhuodongadapter);
        dianpuhuodongadapter.setOnItemClickListener(this);
    }

    private void initUI() {
        view_zhanweitu = findViewById(R.id.view_zhanweitu);
        view_collect = findViewById(R.id.view_collect);
        ll_mycollection_bottom_dialog = findViewById(R.id.ll_mycollection_bottom_dialog);
        findViewById(R.id.bt_guanli).setOnClickListener(this);
        tv_guanli = findViewById(R.id.tv_guanli);
//        smartrefreshlayout = findViewById(R.id.smartrefreshlayout);
        mBtnDelete = findViewById(R.id.btn_delete);
        mBtnDelete.setOnClickListener(this);
        rec_dianpu_huodong = findViewById(R.id.rec_dianpu_huodong);
        select_all = findViewById(R.id.select_all);
        tv_select_all = findViewById(R.id.tv_select_all);
        img_select_all = findViewById(R.id.img_select_all);
        select_all.setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        bt_dianpu_tianjia_huodong = findViewById(R.id.bt_dianpu_tianjia_huodong);
        bt_dianpu_tianjia_huodong.setOnClickListener(this);
    }

    /**
     * 根据选择的数量是否为0来判断按钮的是否可点击.
     *
     * @param size
     */
    private void setBtnBackground(int size) {
        if (size != 0) {
            mBtnDelete.setBackgroundResource(R.drawable.black_di);
            mBtnDelete.setEnabled(true);
            mBtnDelete.setTextColor(ContextCompat.getColor(this, R.color.white));
        } else {
            mBtnDelete.setBackgroundResource(R.drawable.button_shape);
            mBtnDelete.setEnabled(false);
            mBtnDelete.setTextColor(getResources().getColor(R.color.white));
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_guanli:
                if (myCollect.getResult().size()>0){
                    updataEditMode();
                }
                break;
            case R.id.select_all:
                if (myCollect.getResult().size()>0){
                    selectAllMain();
                }
                break;
            case R.id.btn_delete:
                deleteVideo();
                break;
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_dianpu_tianjia_huodong:
                Intent intent = new Intent();
                startActivity(intent.setClass(DianPuMainJianActivity.this,AddDianPuHuoDongActivity.class));
                break;
        }
    }

    /**
     * 删除逻辑
     */
    private void deleteVideo() {
        if (index == 0){
            mBtnDelete.setEnabled(false);
            return;
        }
        SelectDialog.show(DianPuMainJianActivity.this, "提示", "是否删除选中商品",
                "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String id = "";
                        for (int i = dianpuhuodongadapter.getMyLiveList().size(), j =0 ; i > j; i--) {
                            StoreEvents.ResultBean myLive = dianpuhuodongadapter.getMyLiveList().get(i-1);
                            if (myLive.isSelect()) {
                                id = myLive.getId()+","+id;
                            }
                        }
                        initDel(id);
                    }
                },
                "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
    }

    private void initDel(String id) {
        String substring = id.substring(0, id.length() - 1);
        OkGo.<String>post(Contacts.URl1+"/store/delStoreActive")
                .params("ids",substring)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                initData();
                                ToastUtils.showShort("删除成功");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    /**
     * 全选和反选
     */
    private void selectAllMain() {
        if (dianpuhuodongadapter == null) return;
        if (!isSelectAll) {
            for (int i = 0, j = dianpuhuodongadapter.getMyLiveList().size(); i < j; i++) {
                dianpuhuodongadapter.getMyLiveList().get(i).setSelect(true);
            }
            index = dianpuhuodongadapter.getMyLiveList().size();
            mBtnDelete.setEnabled(true);
            tv_select_all.setText("取消全选");
            img_select_all.setImageResource(R.mipmap.select);
            isSelectAll = true;
        } else {
            for (int i = 0, j = dianpuhuodongadapter.getMyLiveList().size(); i < j; i++) {
                dianpuhuodongadapter.getMyLiveList().get(i).setSelect(false);
            }

            index = 0;
            mBtnDelete.setEnabled(false);
            tv_select_all.setText("全选");
            img_select_all.setImageResource(R.mipmap.unselect);
            isSelectAll = false;
        }
        dianpuhuodongadapter.notifyDataSetChanged();
        setBtnBackground(index);
    }

    private void updataEditMode() {
        mEditMode = mEditMode == MYLIVE_MODE_CHECK ? MYLIVE_MODE_EDIT : MYLIVE_MODE_CHECK;
        if (mEditMode == MYLIVE_MODE_EDIT) {
            tv_guanli.setText("完成");
            ll_mycollection_bottom_dialog.setVisibility(View.VISIBLE);
            editorStatus = true;
            bt_dianpu_tianjia_huodong.setVisibility(View.GONE);
        } else {
            tv_guanli.setText("管理");
            bt_dianpu_tianjia_huodong.setVisibility(View.VISIBLE);
            ll_mycollection_bottom_dialog.setVisibility(View.GONE);
            editorStatus = false;
            clearAll();
        }
        dianpuhuodongadapter.setEditMode(mEditMode);
    }

    private void clearAll() {
        isSelectAll = false;
        tv_select_all.setText("全选");
        img_select_all.setImageResource(R.mipmap.unselect);
        setBtnBackground(0);
    }

    @Override
    public void onItemClickListener(int pos, List<StoreEvents.ResultBean> myLiveList) {
        if (editorStatus) {
            StoreEvents.ResultBean myLive = myLiveList.get(pos);
            boolean isSelect = myLive.isSelect();
            if (!isSelect) {
                index++;
                myLive.setSelect(true);
                if (index == myLiveList.size()) {
                    isSelectAll = true;
                    tv_select_all.setText("取消全选");
                    img_select_all.setImageResource(R.mipmap.select);
                }

            } else {
                myLive.setSelect(false);
                index--;
                isSelectAll = false;
                tv_select_all.setText("全选");
                img_select_all.setImageResource(R.mipmap.unselect);

            }
            setBtnBackground(index);
            dianpuhuodongadapter.notifyDataSetChanged();
        }
    }
}
