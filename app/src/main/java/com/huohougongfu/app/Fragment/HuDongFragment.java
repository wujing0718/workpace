package com.huohougongfu.app.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huohougongfu.app.Activity.HuDongDianZanActivity;
import com.huohougongfu.app.Activity.HuDongPingLunActivity;
import com.huohougongfu.app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HuDongFragment extends Fragment implements View.OnClickListener {


    private View inflate;
    private Intent intent;

    public HuDongFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_hu_dong, container, false);
        intent = new Intent();
        initUI();
        return inflate;
    }

    private void initUI() {
        inflate.findViewById(R.id.bt_pinglun).setOnClickListener(this);
        inflate.findViewById(R.id.bt_dianzan).setOnClickListener(this);
    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        HuDongFragment fragment = new HuDongFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_dianzan:
                intent.setClass(getActivity(),HuDongDianZanActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_pinglun:
                intent.setClass(getActivity(),HuDongPingLunActivity.class);
                startActivity(intent);
                break;
        }
    }
}
