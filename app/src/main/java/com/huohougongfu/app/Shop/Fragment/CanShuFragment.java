package com.huohougongfu.app.Shop.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huohougongfu.app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CanShuFragment extends Fragment {


    private View inflate;

    public CanShuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_can_shu, container, false);
        return inflate;
    }
    public static Fragment newInstance(String str){
        CanShuFragment fragment = new CanShuFragment();
        Bundle bundle = new Bundle();
        bundle.putString("",str);
        fragment.setArguments(bundle);
        return fragment;
    }
}
