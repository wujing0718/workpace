package com.huohougongfu.app.Shop.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.blankj.utilcode.util.ToastUtils;
import com.googlecode.mp4parser.authoring.Edit;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TeBieShuoMingActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_fankui;
    private String fankui;
    private String specialInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        specialInstructions = getIntent().getStringExtra("specialInstructions");
        setContentView(R.layout.activity_te_bie_shuo_ming);
        initUI();
    }

    private void initUI() {
        edt_fankui = findViewById(R.id.edt_fankui);
        edt_fankui.setText(specialInstructions);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_queding).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_queding:
                fankui = edt_fankui.getText().toString();
                if (!fankui.isEmpty()){
                    initTiJiao();
                }else{
                    ToastUtils.showShort("内容不能为空");
                }
                break;
        }
    }

    private void initTiJiao() {
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("specialInstructions",fankui);
        OkGo.<String>post(Contacts.URl1+"/store/specialInstructions")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                ToastUtils.showShort("发送成功");
                                finish();
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
