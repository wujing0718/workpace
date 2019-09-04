package com.huohougongfu.app.WoDe.Activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.QueRenFaHuo;
import com.huohougongfu.app.PopupView.KuaiDiGongSi;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lxj.xpopup.XPopup;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TianXieWuLiuActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edt_kuaidi_danhao,edt_kuaidi_name;
    private Map<String, String> kuaidi;
    Handler mHandlerkuaidi = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    kuaidi = (Map<String,String>)msg.obj;
                    edt_kuaidi_name.setText(kuaidi.get("expressCompany"));
                    edt_kuaidi_name.setTextColor(getResources().getColor(R.color.colorBlack));
                    break;
                default:
                    break;
            }
        }
    };
    private String orderNo;
    private String danhao;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tian_xie_wu_liu);
        orderNo = getIntent().getStringExtra("orderNo");
        initUI();
    }

    private void initUI() {
        edt_kuaidi_danhao = findViewById(R.id.edt_kuaidi_danhao);
        edt_kuaidi_name = findViewById(R.id.edt_kuaidi_name);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_fahuo).setOnClickListener(this);
        findViewById(R.id.bt_xuanze_kuaidi).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_finish:
               finish();
                break;
            case R.id.bt_fahuo:
                danhao = edt_kuaidi_danhao.getText().toString();
                name = edt_kuaidi_name.getText().toString();
                if (!utils.isDoubleClick()){
                    if (!"".equals(danhao)){
                        if (!"".equals(name)){
                            //确认发货
                            initFaHuo();
                        }else{
                            ToastUtils.showShort("请输入或选择快递名字");
                        }
                    }else{
                        ToastUtils.showShort("请输入快递单号");
                    }
                }
                break;
            case R.id.bt_xuanze_kuaidi:
                if (!utils.isDoubleClick()){
                    hideInput();
                    new XPopup.Builder(TianXieWuLiuActivity.this)
                            .offsetY(300)
                            .asCustom(new KuaiDiGongSi(TianXieWuLiuActivity.this,mHandlerkuaidi))
                            .show();
                }
                break;
        }
    }

    private void initFaHuo() {
        Map<String,String> map = new HashMap<>();
        map.put("orderNo",orderNo);
        map.put("logisticsName",name);
        map.put("logisticsNo",danhao);
        OkGo.<String>post(Contacts.URl1+"order/confirmSendGoods")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                finish();
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        QueRenFaHuo queRenFaHuo = gson.fromJson(body, QueRenFaHuo.class);
//                        if (queRenFaHuo.get)
                    }
                });
    }

    /**
     * 隐藏键盘
     */
    protected void hideInput() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        View v = getWindow().peekDecorView();
        if (null != v) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }
}
