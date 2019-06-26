package com.huohougongfu.app.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.utils;
import com.huohougongfu.app.WoDe.Activity.SettingActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment implements View.OnClickListener {


    private View inflate;
    private ImageView img_my_touxiang;
    private TextView tv_my_name,tv_my_vipnum,tv_my_id,tv_my_guanzhunum,tv_my_fensinum,tv_my_jianjie;
    private Intent intent;

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_my, container, false);
        View statusBar = inflate.findViewById(R.id.statusBarView);
        ViewGroup.LayoutParams layoutParams = statusBar.getLayoutParams();
        layoutParams.height = utils.getStatusBarHeight();
        intent = new Intent();
        initUI();
        return inflate;
    }

    private void initUI() {
        inflate.findViewById(R.id.bt_setting).setOnClickListener(this);
        inflate.findViewById(R.id.bt_duihua).setOnClickListener(this);
        inflate.findViewById(R.id.bt_my_gouwuche).setOnClickListener(this);
        inflate.findViewById(R.id.bt_my_shoucang).setOnClickListener(this);
        inflate.findViewById(R.id.bt_my_kabao).setOnClickListener(this);
        inflate.findViewById(R.id.bt_my_dianpu).setOnClickListener(this);
        inflate.findViewById(R.id.bt_my_dongtai).setOnClickListener(this);
        inflate.findViewById(R.id.bt_dingdan_quanbu).setOnClickListener(this);
        inflate.findViewById(R.id.bt_huiyuan_quanbu).setOnClickListener(this);

        inflate.findViewById(R.id.bt_dingdan_daifukuan).setOnClickListener(this);
        inflate.findViewById(R.id.bt_dingdan_daifahuo).setOnClickListener(this);
        inflate.findViewById(R.id.bt_dingdan_daishouhuo).setOnClickListener(this);
        inflate.findViewById(R.id.bt_dingdan_pingjia).setOnClickListener(this);
        inflate.findViewById(R.id.bt_dingdan_shouhou).setOnClickListener(this);

        inflate.findViewById(R.id.bt_huiyuan_fenxiao).setOnClickListener(this);
        inflate.findViewById(R.id.bt_huiyuan_huodong).setOnClickListener(this);
        inflate.findViewById(R.id.bt_huiyuan_tuiguang).setOnClickListener(this);
        inflate.findViewById(R.id.bt_huiyuan_kaidian).setOnClickListener(this);

        inflate.findViewById(R.id.bt_my_fenxiang).setOnClickListener(this);

        img_my_touxiang = inflate.findViewById(R.id.img_my_touxiang);
        tv_my_name = inflate.findViewById(R.id.tv_my_name);
        tv_my_vipnum = inflate.findViewById(R.id.tv_my_vipnum);
        tv_my_id = inflate.findViewById(R.id.tv_my_id);
        tv_my_guanzhunum = inflate.findViewById(R.id.tv_my_guanzhunum);
        tv_my_fensinum = inflate.findViewById(R.id.tv_my_fensinum);
        tv_my_jianjie = inflate.findViewById(R.id.tv_my_jianjie);


    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_setting:
                if (!utils.isDoubleClick()){
                    intent.setClass(getActivity(),SettingActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }
}
