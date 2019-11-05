package com.huohougongfu.app.RongYun;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.huohougongfu.app.R;

import io.rong.imkit.fragment.ConversationFragment;

public class ConversationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        TextView tv_name = findViewById(R.id.tv_name);
        tv_name.setText(getIntent().getData().getQueryParameter("title"));

        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.bt_dianpu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
//        FragmentManager fragmentManage = getSupportFragmentManager();
//        ConversationFragment fragement = (ConversationFragment) fragmentManage.findFragmentById(R.id.conversation);
//        Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()
//                .appendPath("conversation").appendPath(mConversationType.getName().toLowerCase())
//                .appendQueryParameter("targetId", mtargetId).build();
//
//        fragement.setUri(uri);
    }
}
