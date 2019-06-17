package com.huohougongfu.app.Fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    private View inflate;

    public SimpleCardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_simple_card, container, false);
        initUI();
        return inflate;
    }

    private void initUI() {
        inflate.findViewById(R.id.bt_xiadan).setOnClickListener(this);
    }

    public static Fragment newInstance(String str){
        SimpleCardFragment fragment = new SimpleCardFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY,str);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_xiadan:
                if (!utils.isDoubleClick()){
                    new XPopup.Builder(getContext())
                            .asCustom(new Paocha(getContext()))
                            .show();
                }
                break;
        }
    }
}
