package com.huohougongfu.app.Shop.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ShopCanShu;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class CanShuFragment extends Fragment {


    private View inflate;
    private String token,tel,id;
    private int shopid;
    private TextView tv_producedDate,tv_expirationDate,tv_storageWay,tv_productionLicenseCode,tv_productStandardCode,tv_factoryName,tv_factoryAddress
            ,tv_burdenSheet,tv_foodAdditives,tv_netContent,tv_brand,tv_category,tv_producedAddress,tv_packageType;

    public CanShuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_can_shu, container, false);
        token = MyApp.instance.getString("token");
        tel = MyApp.instance.getString("phone");
        id = String.valueOf(MyApp.instance.getInt("id"));
        shopid = getArguments().getInt("id");
        initUI();
        initData();
        return inflate;
    }

    private void initUI() {
        tv_producedDate = inflate.findViewById(R.id.tv_producedDate);
        tv_expirationDate = inflate.findViewById(R.id.tv_expirationDate);
        tv_storageWay = inflate.findViewById(R.id.tv_storageWay);
        tv_productionLicenseCode = inflate.findViewById(R.id.tv_productionLicenseCode);
        tv_productStandardCode = inflate.findViewById(R.id.tv_productStandardCode);
        tv_factoryAddress = inflate.findViewById(R.id.tv_factoryAddress);
        tv_burdenSheet = inflate.findViewById(R.id.tv_burdenSheet);
        tv_netContent = inflate.findViewById(R.id.tv_netContent);
        tv_brand = inflate.findViewById(R.id.tv_brand);
        tv_category = inflate.findViewById(R.id.tv_category);
        tv_producedAddress = inflate.findViewById(R.id.tv_producedAddress);
        tv_packageType = inflate.findViewById(R.id.tv_packageType);

    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("tel",tel);
        map.put("id",String.valueOf(shopid));
        map.put("token",token);
        OkGo.<String>get(Contacts.URl1+"selectProductAttribute")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        ShopCanShu canshu = gson.fromJson(response.body(), ShopCanShu.class);
                        if (canshu.getStatus() == 1) {
                            tv_producedDate.setText(canshu.getResult().getProducedDate());
                            tv_expirationDate.setText(canshu.getResult().getExpirationDate());
                            tv_storageWay.setText(canshu.getResult().getStorageWay());
                            tv_productionLicenseCode.setText(canshu.getResult().getProductionLicenseCode());
                            tv_productStandardCode.setText(canshu.getResult().getProductStandardCode());
                            tv_factoryAddress.setText(canshu.getResult().getFactoryAddress());
                            tv_burdenSheet.setText(canshu.getResult().getBurdenSheet());
                            tv_netContent.setText(canshu.getResult().getNetContent());
                            tv_brand.setText(canshu.getResult().getBrand());
                            tv_category.setText(canshu.getResult().getCategory());
                            tv_producedAddress.setText(canshu.getResult().getProducedAddress());
                            tv_packageType.setText(canshu.getResult().getPackageType());
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    public static Fragment newInstance(int str){
        CanShuFragment fragment = new CanShuFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id",str);
        fragment.setArguments(bundle);
        return fragment;
    }
}
