package com.huohougongfu.app.WoDe.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Fragment.SouSuoShopFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhuanKeFragment extends Fragment {


    private View inflate;

    public ZhuanKeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        inflate = inflater.inflate(R.layout.fragment_zhuan_ke, container, false);
        return inflate;
    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        ZhuanKeFragment fragment = new ZhuanKeFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
