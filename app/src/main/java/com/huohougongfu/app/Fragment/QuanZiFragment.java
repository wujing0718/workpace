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
public class QuanZiFragment extends Fragment {


    public QuanZiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quan_zi, container, false);
    }
    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        QuanZiFragment fragment = new QuanZiFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
