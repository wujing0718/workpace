package com.huohougongfu.app.WoDe.Activity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.MyCollect;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Adapter.ZhaoRenAdapter;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.huohougongfu.app.WoDe.Adapter.MyColleAdapter;
import com.kongzue.dialog.v2.SelectDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCollectActivity extends AppCompatActivity implements OnClickListener,MyColleAdapter.OnItemClickListener {

    private TextView tv_guanli,tv_select_all;
    private int mId;
    private SmartRefreshLayout smartrefreshlayout;
    private RecyclerView rec_mycollect;
    private MyColleAdapter mycollectadapter;
    private String token;
    private static final int MYLIVE_MODE_CHECK = 0;
    private static final int MYLIVE_MODE_EDIT = 1;
    private int mEditMode = MYLIVE_MODE_CHECK;
    private boolean isSelectAll = false;
    private boolean editorStatus = false;
    private int index = 0;
    private View select_all;
    private TextView mBtnDelete;
    private View ll_mycollection_bottom_dialog;
    private ImageView img_select_all;
    private View view_collect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collect);
        mId = MyApp.instance.getInt("id");
        token = MyApp.instance.getString("token");
        initUI();
        initData();
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("pageNo",String.valueOf(1));
        map.put("pageSize",String.valueOf(10));
        OkGo.<String>post(Contacts.URl1+"/my/collection")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        MyCollect myCollect = gson.fromJson(body, MyCollect.class);
                        if (myCollect.getStatus() == 1){
                            if (myCollect.getResult().getList().size()==0){
                                setBtnBackground(0);
                                ll_mycollection_bottom_dialog.setVisibility(View.GONE);
                                view_collect.setVisibility(View.GONE);
                            }else{
                                view_collect.setVisibility(View.VISIBLE);
                                initRec(myCollect.getResult().getList());

                            }
                        }
                    }
                });
    }

    private void initRec(List<MyCollect.ResultBean.ListBean> list) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        //设置RecyclerView 布局
        rec_mycollect.setLayoutManager(layoutmanager);
        mycollectadapter = new MyColleAdapter(this);
        mycollectadapter.notifyAdapter(list,false);
        rec_mycollect.setAdapter(mycollectadapter);
        mycollectadapter.setOnItemClickListener(this);
    }

    private void initUI() {
        view_collect = findViewById(R.id.view_collect);
        ll_mycollection_bottom_dialog = findViewById(R.id.ll_mycollection_bottom_dialog);
        findViewById(R.id.bt_guanli).setOnClickListener(this);
        tv_guanli = findViewById(R.id.tv_guanli);
         smartrefreshlayout = findViewById(R.id.smartrefreshlayout);
        mBtnDelete = findViewById(R.id.btn_delete);
        mBtnDelete.setOnClickListener(this);
        rec_mycollect = findViewById(R.id.rec_mycollect);
        select_all = findViewById(R.id.select_all);
        tv_select_all = findViewById(R.id.tv_select_all);
        img_select_all = findViewById(R.id.img_select_all);
        select_all.setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_guanli:
                updataEditMode();
                break;
            case R.id.select_all:
                selectAllMain();
                break;
            case R.id.btn_delete:
                deleteVideo();
                break;
            case R.id.bt_finish:
                finish();
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
        SelectDialog.show(MyCollectActivity.this, "提示", "是否删除选中商品",
                "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = mycollectadapter.getMyLiveList().size(), j =0 ; i > j; i--) {
                            MyCollect.ResultBean.ListBean myLive = mycollectadapter.getMyLiveList().get(i-1);
                            if (myLive.isSelect()) {
                                int id = myLive.getId();
                                initDel(id);
                            }
                        }
                    }
                },
                "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
    }

    private void initDel(int id) {
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("pId",String.valueOf(id));
        OkGo.<String>post(Contacts.URl1+"/my/del/collection")
                .params(map)
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
        if (mycollectadapter == null) return;
        if (!isSelectAll) {
            for (int i = 0, j = mycollectadapter.getMyLiveList().size(); i < j; i++) {
                mycollectadapter.getMyLiveList().get(i).setSelect(true);
            }
            index = mycollectadapter.getMyLiveList().size();
            mBtnDelete.setEnabled(true);
            tv_select_all.setText("取消全选");
            img_select_all.setImageResource(R.mipmap.select);
            isSelectAll = true;
        } else {
            for (int i = 0, j = mycollectadapter.getMyLiveList().size(); i < j; i++) {
                mycollectadapter.getMyLiveList().get(i).setSelect(false);
            }

            index = 0;
            mBtnDelete.setEnabled(false);
            tv_select_all.setText("全选");
            img_select_all.setImageResource(R.mipmap.unselect);
            isSelectAll = false;
        }
        mycollectadapter.notifyDataSetChanged();
        setBtnBackground(index);
    }

    private void updataEditMode() {
        mEditMode = mEditMode == MYLIVE_MODE_CHECK ? MYLIVE_MODE_EDIT : MYLIVE_MODE_CHECK;
        if (mEditMode == MYLIVE_MODE_EDIT) {
            tv_guanli.setText("完成");
            ll_mycollection_bottom_dialog.setVisibility(View.VISIBLE);
            editorStatus = true;
        } else {
            tv_guanli.setText("管理");
            ll_mycollection_bottom_dialog.setVisibility(View.GONE);
            editorStatus = false;
            clearAll();
        }
        mycollectadapter.setEditMode(mEditMode);
    }

    private void clearAll() {
        isSelectAll = false;
        tv_select_all.setText("全选");
        img_select_all.setImageResource(R.mipmap.unselect);
        setBtnBackground(0);
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
    public void onItemClickListener(int pos, List<MyCollect.ResultBean.ListBean> myLiveList) {
        if (editorStatus) {
            MyCollect.ResultBean.ListBean myLive = myLiveList.get(pos);
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
            mycollectadapter.notifyDataSetChanged();
        }
    }
}
