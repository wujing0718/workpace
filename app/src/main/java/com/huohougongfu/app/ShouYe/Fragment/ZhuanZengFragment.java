package com.huohougongfu.app.ShouYe.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huohougongfu.app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhuanZengFragment extends Fragment {


    private View inflate;

    public ZhuanZengFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_zhuan_zeng, container, false);

        return inflate;
    }
    public static Fragment newInstance(String str){
        ZhuanZengFragment fragment = new ZhuanZengFragment();
        Bundle bundle = new Bundle();
        bundle.putString("",str);
        fragment.setArguments(bundle);
        return fragment;
    }
}
