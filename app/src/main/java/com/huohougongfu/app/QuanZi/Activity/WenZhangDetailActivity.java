package com.huohougongfu.app.QuanZi.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.FaBuArticleActivity;
import com.huohougongfu.app.Gson.QuanZiDetail;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WenZhangDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private int mId;
    private int dId;
    private QuanZiDetail detail;
    private ImageView img_quanzi_touxiang;
    private TextView tv_quanzi_name,tv_quanzi_chenghu;
    private LinearLayout view_wenzhang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wen_zhang_detail);
        dId = getIntent().getIntExtra("dId", 0);
        mId = MyApp.instance.getInt("id");
        initUI();
        initData();
    }

    private void initUI() {
        img_quanzi_touxiang = findViewById(R.id.img_quanzi_touxiang);
        view_wenzhang = findViewById(R.id.view_wenzhang);
        tv_quanzi_name = findViewById(R.id.tv_quanzi_name);
        tv_quanzi_chenghu = findViewById(R.id.tv_quanzi_chenghu);
        findViewById(R.id.bt_finish).setOnClickListener(this);
    }

    private void initData() {
        Map<String ,String> map = new HashMap<>();
        map.put("dId",String.valueOf(dId));
        map.put("mId",String.valueOf(mId));
        OkGo.<String>post(Contacts.URl1+"/circle/data/info")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        String body = response.body();
                        Gson gson = new Gson();
                        detail = gson.fromJson(body, QuanZiDetail.class);
                        if (detail.getStatus() == 1){
                            initView(detail.getResult());
//                            if (detail.getResult().getIsPraise() == 1){
//                                img_shoucang.setImageResource(R.mipmap.img_xihuan2);
//                            }else{
//                                img_shoucang.setImageResource(R.mipmap.img_xihuan);
//                            }
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(WenZhangDetailActivity.this,"载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initView(QuanZiDetail.ResultBean result) {
        String content = result.getContent();
        String picture = result.getPicture();
        String[] split1 = picture.split(",");
        String[] mcontent = content.split(",,");
        int temp = 0;
            for (int i = 0;i<mcontent.length;i++){
                if ("@&$".equals(mcontent[i])){
                    ImageView imageView = new ImageView(WenZhangDetailActivity.this);
                    Glide.with(WenZhangDetailActivity.this).load(split1[temp]).into(imageView);
                    temp+=1;
                    view_wenzhang.addView(imageView);
                }else{
                    TextView textView = new TextView(WenZhangDetailActivity.this);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams.setMargins(20,20,20,20);
                    textView.setText(mcontent[i]);
                    textView.setLayoutParams(layoutParams);
                    textView.setText(mcontent[i]);
                    view_wenzhang.addView(textView);
                }
                for (int y = 0;y<split1.length;y++){
                }
            }

        tv_quanzi_name.setText(result.getMember().getNickName());
        Glide.with(WenZhangDetailActivity.this).load(result.getMember().getPhoto()).into(img_quanzi_touxiang);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                finish();
                break;
        }
    }
}
