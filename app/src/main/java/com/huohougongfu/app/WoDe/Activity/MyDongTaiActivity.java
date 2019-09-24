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
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.MyDongTai;
import com.huohougongfu.app.Gson.WoDeCollect;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Activity.QuanZiDetailActivity;
import com.huohougongfu.app.QuanZi.Activity.VedioDetailActivity;
import com.huohougongfu.app.QuanZi.Activity.WenZhangDetailActivity;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.WoDe.Adapter.MyDongTaiAdapter;
import com.kongzue.dialog.v2.SelectDialog;
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
import java.util.List;
import java.util.Map;

public class MyDongTaiActivity extends AppCompatActivity implements View.OnClickListener{

    private String token;
    private int mId;
    private RecyclerView rec_wode_dongtai;
    private SmartRefreshLayout smartrefreshlayout;
    private int page = 2;
    private MyDongTaiAdapter myDongTaiAdapter;
    private TextView tv_guanli,tv_select_all;
    private TextView mBtnDelete;
    private View select_all;
    private View ll_mycollection_bottom_dialog;
    private ImageView img_select_all;
    private View view_collect;
    private static final int MYLIVE_MODE_CHECK = 0;
    private static final int MYLIVE_MODE_EDIT = 1;
    private int mEditMode = MYLIVE_MODE_CHECK;
    private boolean isSelectAll = false;
    private boolean editorStatus = false;
    private int index = 0;
    private View view_dongtai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dong_tai);
        token = MyApp.instance.getString("token");
        mId = MyApp.instance.getInt("id");
        initUI();
        initData();
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initUI() {
        view_dongtai = findViewById(R.id.view_dongtai);
        ll_mycollection_bottom_dialog = findViewById(R.id.ll_mycollection_bottom_dialog);
        rec_wode_dongtai = findViewById(R.id.rec_wode_dongtai);
        smartrefreshlayout = findViewById(R.id.smartrefreshlayout);
        findViewById(R.id.bt_guanli).setOnClickListener(this);
        tv_guanli = findViewById(R.id.tv_guanli);
        mBtnDelete = findViewById(R.id.btn_delete);
        mBtnDelete.setOnClickListener(this);
        select_all = findViewById(R.id.select_all);
        tv_select_all = findViewById(R.id.tv_select_all);
        img_select_all = findViewById(R.id.img_select_all);
        select_all.setOnClickListener(this);
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("pageNo",String.valueOf(1));
        map.put("pageSize",String.valueOf(10));
        OkGo.<String>post(Contacts.URl1+"/my/dynamic")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        smartrefreshlayout.finishRefresh(true);//传入false表示刷新失败
                        WaitDialog.dismiss();
                        String body = response.body();
                        Gson gson = new Gson();
                        MyDongTai dongtai = gson.fromJson(body, MyDongTai.class);
                        if (dongtai.getStatus() == 1){
                            if (dongtai.getResult().getList().size()>0){
                                view_dongtai.setVisibility(View.VISIBLE);
                                initRec(dongtai.getResult().getList());
                            }else{
                                view_dongtai.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(MyDongTaiActivity.this,"载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initRec(List<MyDongTai.ResultBean.ListBean> list) {
        if (list.size()>0){
            smartrefreshlayout.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
            rec_wode_dongtai.setLayoutManager(layoutmanager);
            myDongTaiAdapter = new MyDongTaiAdapter(R.layout.item_wode_dongtai,list,MyDongTaiActivity.this);
            rec_wode_dongtai.setAdapter(myDongTaiAdapter);
            myDongTaiAdapter.notifyAdapter(list,false);
            myDongTaiAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int pos) {
                    if (editorStatus) {
                        MyDongTai.ResultBean.ListBean myLive = list.get(pos);
                        boolean isSelect = myLive.getIsSelect();
                        if (!isSelect) {
                            index++;
                            myLive.setIsSelect(true);
                            if (index == list.size()) {
                                isSelectAll = true;
                                tv_select_all.setText("取消全选");
                                img_select_all.setImageResource(R.mipmap.select);
                            }
                        } else {
                            myLive.setIsSelect(false);
                            index--;
                            isSelectAll = false;
                            tv_select_all.setText("全选");
                            img_select_all.setImageResource(R.mipmap.unselect);

                        }
                        setBtnBackground(index);
                        myDongTaiAdapter.notifyDataSetChanged();
                    } else {
                        if (list.get(pos).getType() == 2) {
                            Intent intent = new Intent();
                            intent.putExtra("dId", list.get(pos).getId());
                            startActivity(intent.setClass(MyDongTaiActivity.this, WenZhangDetailActivity.class));
                        } else if (list.get(pos).getType() == 1) {
                            Intent intent = new Intent();
                            intent.putExtra("dId", list.get(pos).getId());
                            startActivity(intent.setClass(MyDongTaiActivity.this, QuanZiDetailActivity.class));
                        } else if (list.get(pos).getType() == 3) {
                            Intent intent = new Intent();
                            intent.putExtra("动态视频", list.get(pos));
                            intent.putExtra("position", pos);
                            intent.putExtra("dId", list.get(pos).getId());
                            startActivity(intent.setClass(MyDongTaiActivity.this, VedioDetailActivity.class));
                        }
                    }
                }
            });
            //刷新
            smartrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    initData();
                }
            });
            //加载更多
            smartrefreshlayout.setOnLoadmoreListener(new OnLoadmoreListener() {
                @Override
                public void onLoadmore(RefreshLayout refreshlayout) {
                    initAdd();
                }
            });
        }else{
            smartrefreshlayout.setVisibility(View.GONE);
        }
    }

    private void initAdd() {
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("pageNo",String.valueOf(page++));
        map.put("pageSize",String.valueOf(10));
        OkGo.<String>post(Contacts.URl1+"/my/dynamic")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        MyDongTai dongtai = gson.fromJson(body, MyDongTai.class);
                        if (dongtai.getStatus() == 1){
                            if (dongtai.getResult().getList().size()>0){
                                myDongTaiAdapter.add(dongtai.getResult().getList());
                                smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                            }else {
                                smartrefreshlayout. finishLoadMore();
                            }
                            }
                    }
                });
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
        SelectDialog.show(MyDongTaiActivity.this, "提示", "是否删除选中动态",
                "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = myDongTaiAdapter.getMyLiveList().size(), j =0 ; i > j; i--) {
                            MyDongTai.ResultBean.ListBean myLive = myDongTaiAdapter.getMyLiveList().get(i-1);
                            if (myLive.getIsSelect()) {
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
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("dataIds",String.valueOf(id));
        OkGo.<String>post(Contacts.URl1+"/circle/del")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            if (jsonObject.getInt("status") == 1){
                                ll_mycollection_bottom_dialog.setVisibility(View.GONE);
                                initData();
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
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
        if (myDongTaiAdapter == null) return;
        if (!isSelectAll) {
            for (int i = 0, j = myDongTaiAdapter.getMyLiveList().size(); i < j; i++) {
                myDongTaiAdapter.getMyLiveList().get(i).setIsSelect(true);
            }
            index = myDongTaiAdapter.getMyLiveList().size();
            mBtnDelete.setEnabled(true);
            tv_select_all.setText("取消全选");
            img_select_all.setImageResource(R.mipmap.select);
            isSelectAll = true;
        } else {
            for (int i = 0, j = myDongTaiAdapter.getMyLiveList().size(); i < j; i++) {
                myDongTaiAdapter.getMyLiveList().get(i).setIsSelect(false);
            }

            index = 0;
            mBtnDelete.setEnabled(false);
            tv_select_all.setText("全选");
            img_select_all.setImageResource(R.mipmap.unselect);
            isSelectAll = false;
        }
        myDongTaiAdapter.notifyDataSetChanged();
        setBtnBackground(index);
    }

    private void updataEditMode() {
        mEditMode = mEditMode == MYLIVE_MODE_CHECK ? MYLIVE_MODE_EDIT : MYLIVE_MODE_CHECK;
        if (myDongTaiAdapter!=null){
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
            myDongTaiAdapter.setEditMode(mEditMode);
        }
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


}
