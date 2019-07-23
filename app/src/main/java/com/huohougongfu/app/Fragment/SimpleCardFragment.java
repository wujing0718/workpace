package com.huohougongfu.app.Fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.Machine;
import com.huohougongfu.app.Gson.TeaDetail;
import com.huohougongfu.app.PopupView.Paocha;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.MessageDialog;
import com.lxj.xpopup.XPopup;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleCardFragment extends Fragment implements View.OnClickListener {

    private static final String KEY = "title";
    private static final String MachineId = "machineId";

    private View inflate;
//    private Machine.ResultBean resultBean;
    private TextView teaname,teaprice,teaefficacy,teaWeight,waterWeight,temperature;
    private ImageView img_jiqi_photo;
    private String resultBean;
    private TeaDetail teaDetail;
    private String machineId;

    public SimpleCardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_simple_card, container, false);
        resultBean = getArguments().getString(KEY);
        machineId = getArguments().getString(MachineId);
        initUI();
        initView();
        return inflate;
    }

    private void initView() {
        Gson gson = new Gson();
        teaDetail = gson.fromJson(resultBean, TeaDetail.class);
        teaname.setText(teaDetail.getTeaName());
        teaprice.setText("¥"+teaDetail.getPrice());
        Glide.with(getActivity()).load(teaDetail.getPicture()).into(img_jiqi_photo);
        teaefficacy.setText(teaDetail.getEfficacy());
        teaWeight.setText(teaDetail.getConcentration().getTeaWeight()+"g");
        waterWeight.setText(teaDetail.getConcentration().getTeaWeight()+"ml");
        temperature.setText(teaDetail.getConcentration().getTemperature()+"°C");
    }

    private void initUI() {
        inflate.findViewById(R.id.bt_paocha).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new XPopup.Builder(getContext())
                        .asCustom(new Paocha(getContext(),teaDetail,machineId))
                        .show();
            }
        });
        teaname = inflate.findViewById(R.id.tv_jiqi_tea);
        teaprice = inflate.findViewById(R.id.tv_jiqi_price);
        teaefficacy = inflate.findViewById(R.id.tv_tea_efficacy);
        teaWeight = inflate.findViewById(R.id.tv_jiqi_teaWeight);
        waterWeight = inflate.findViewById(R.id.tv_jiqi_waterWeight);
        temperature = inflate.findViewById(R.id.tv_jiqi_temperature);
        img_jiqi_photo = inflate.findViewById(R.id.img_jiqi_photo);

    }

    public static Fragment newInstance(String s, String machined){
        SimpleCardFragment fragment = new SimpleCardFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY,s);
        bundle.putString(MachineId,machined);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }
}
