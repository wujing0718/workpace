package com.huohougongfu.app.WoDe.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.huohougongfu.app.Gson.ZhuanKeVIP;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Fragment.SouSuoShopFragment;
import com.huohougongfu.app.Utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhuanKeFragment extends Fragment {


    private View inflate;
    private ZhuanKeVIP.ResultBean.EarnPordutBean earnpordutbean;
    private Banner banner;
    private List<String> mbanner = new ArrayList<>();
    private TextView tv_introduce;

    public ZhuanKeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        inflate = inflater.inflate(R.layout.fragment_zhuan_ke, container, false);
        earnpordutbean = (ZhuanKeVIP.ResultBean.EarnPordutBean )getArguments().getSerializable("ARGS");
        initUI();
        return inflate;
    }

    private void initUI() {
        String pic = earnpordutbean.getPic();
        String[] split = pic.split(",");
        for (int i = 0; i < split.length; i++) {
            mbanner.add(split[i]);
        }
        banner = inflate.findViewById(R.id.banner);
        tv_introduce = inflate.findViewById(R.id.tv_introduce);
        //加载网络图片
        banner.setImages(mbanner)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImageLoader(new GlideImageLoader())
                .start();
        tv_introduce.setText(earnpordutbean.getIntroduce());
    }

    public static Fragment newInstance(ZhuanKeVIP.ResultBean.EarnPordutBean content) {
        Bundle args = new Bundle();
        args.putSerializable("ARGS", content);
        ZhuanKeFragment fragment = new ZhuanKeFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
