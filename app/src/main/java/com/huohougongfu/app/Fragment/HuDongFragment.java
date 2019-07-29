package com.huohougongfu.app.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huohougongfu.app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HuDongFragment extends Fragment {


    public HuDongFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hu_dong, container, false);
    }
    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        HuDongFragment fragment = new HuDongFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
