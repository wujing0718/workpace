package com.huohougongfu.app.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huohougongfu.app.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class XiTongFragment extends Fragment {


    private View inflate;
    private RecyclerView rec_xitong;
    private SmartRefreshLayout smartrefreshlayout;

    public XiTongFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_xi_tong, container, false);
        initData();
        initRec();
        return inflate;
    }

    private void initData() {

    }

    private void initRec() {
        smartrefreshlayout = inflate.findViewById(R.id.smartrefreshlayout);
        rec_xitong = inflate.findViewById(R.id.rec_xitong);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rec_xitong.setLayoutManager(layoutManager);

    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        XiTongFragment fragment = new XiTongFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
