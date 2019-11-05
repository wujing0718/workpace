package com.huohougongfu.app.Adapter;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ChaTaiGson;
import com.huohougongfu.app.Gson.ChaTaiYouHuiQuan;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.mcxtzhang.lib.AnimShopButton;
import com.mcxtzhang.lib.IOnAddDelListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChaTaiAdapter extends BaseAdapter {

    private ChaTaiYouHuiQuan.ResultBean.CouponsBean xuanzeyouhuiquan;
    private  int item_shouye_chataione;
    private  View bt_checkbox,bt_chami_dikou;
    private  Button btn_go_to_pay;
    private  List<ChaTaiGson.ResultBean> list = new ArrayList<>();
    private Context context;
    private boolean isSelectAll = false;
    private ImageView ivSelectAll,img_chami_check;
    private double total_price;
    private TextView tv_total_price;
    private ChaTaiYouHuiQuan.ResultBean myouhuiquan;
    private boolean isDikou = true;
    private JSONArray array;
    private String orderprice;
    private TextView bt_delete;
    private TextView tv_num;

    public ChaTaiAdapter(int item_shouye_chataione, View bt_checkbox, Button btn_go_to_pay,
                         List<ChaTaiGson.ResultBean> list, Context context, ImageView img_check,
                         TextView tv_total_price, View bt_chami_dikou, ImageView img_chami_check,
                         ChaTaiYouHuiQuan.ResultBean myouhuiquan, TextView bt_delete,TextView tv_num) {
        this.item_shouye_chataione = item_shouye_chataione;
        this.bt_checkbox = bt_checkbox;
        this.btn_go_to_pay = btn_go_to_pay;
        this.context = context;
        this.ivSelectAll = img_check;
        this.tv_total_price =tv_total_price;
        this.bt_chami_dikou =bt_chami_dikou;
        this.img_chami_check =img_chami_check;
        this.myouhuiquan =myouhuiquan;
        this.bt_delete = bt_delete;
        this.tv_num = tv_num;

    }

    /**
     * 自定义设置数据方法；
     * 通过notifyDataSetChanged()刷新数据，可保持当前位置
     *
     * @param list 需要刷新的数据
     */
    public void setData(List<ChaTaiGson.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (list != null && list.size() > 0) {
            return list.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null){
            convertView = View.inflate(context, R.layout.item_shouye_chataione, null);
            groupViewHolder = new ChaTaiAdapter.GroupViewHolder(convertView);
            convertView.setTag(groupViewHolder);
        }else{
            groupViewHolder = (ChaTaiAdapter.GroupViewHolder) convertView.getTag();
        }
        if (isSelectAll) {
            ivSelectAll.setBackgroundResource(R.mipmap.select);
        } else {
            ivSelectAll.setBackgroundResource(R.mipmap.unselect);
        }
        groupViewHolder.tv_chatai_title.setText(list.get(position).getTea().getTeaName());
        groupViewHolder.tv_chatai_price.setText("¥"+list.get(position).getTea().getPrice());
        if (list.get(position).getHasDust()==1){
            groupViewHolder.tv_chatai_hasDust.setText("有叶底");
        }else{
            groupViewHolder.tv_chatai_hasDust.setText("无叶底");
        }
        groupViewHolder.tv_chatai_concentration.setText(list.get(position).getConcentration());
        RequestOptions placeholder = new RequestOptions().placeholder(R.mipmap.img_zhanweitu);
        Glide.with(context).load(list.get(position).getTea().getPicture()).apply(placeholder).into(groupViewHolder.img_chatai_photo);
        groupViewHolder.amountview.setMaxCount(15);
        groupViewHolder.amountview.setCount(list.get(position).getNum());
//        groupViewHolder.amountview.setMaxCount(list.get(position).getStock());
        groupViewHolder.amountview.setOnAddDelListener(new IOnAddDelListener() {
            @Override
            public void onAddSuccess(int i) {
                if (i<=15){
                    tv_num.setText("共"+i+"件");
                    list.get(position).setNum(i);
                    notifyDataSetChanged();
                    initAddGouWuChe(i,list.get(position).getId());
                }else{
                    ToastUtils.showShort("超过最大购买数量");
                }
            }

            @Override
            public void onAddFailed(int i, FailType failType) {

            }

            @Override
            public void onDelSuccess(int i) {
                if (i == 0){
//                    list.get(position).setIsSelect(false);
                    groupViewHolder.amountview.setCount(0);
                    notifyDataSetChanged();
                }else{
                    tv_num.setText("共"+i+"件");
                    list.get(position).setNum(i);
                    initAddGouWuChe(i,list.get(position).getId());
//                    list.get(position).setIsSelect(true);
                    notifyDataSetChanged();
                }
            }

            @Override
            public void onDelFaild(int i, FailType failType) {

            }
        });

        boolean isSelect1 = list.get(position).getIsSelect();
        ChaTaiGson.ResultBean resultBean1 = list.get(position);
        //商品是否被选中
        if (isSelect1) {
            tv_num.setText("共"+list.get(position).getNum()+"件");
            groupViewHolder.img_check.setImageResource(R.mipmap.select);
        } else {
            tv_num.setText("共"+0+"件");
            groupViewHolder.img_check.setImageResource(R.mipmap.unselect);
        }
        //当所有的选择框都是选中的时候，全选也要选中
        w:
        for (int i = 0; i < list.size(); i++) {
            boolean isSelect = list.get(i).getIsSelect();
            if (isSelect) {
                isSelectAll = true;
            } else {
                isSelectAll = false;
                break w;//根据标记，跳出嵌套循环
            }
        }
        //全选的点击事件
        bt_checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelectAll = !isSelectAll;
                if (isSelectAll) {
                    bt_delete.setVisibility(View.VISIBLE);
                    for (int i = 0; i < list.size(); i++) {
                        ChaTaiGson.ResultBean goodsBean = list.get(i);
                        goodsBean.setIsSelect(true);
                    }
                } else {
                    bt_delete.setVisibility(View.GONE);
                    for (int i = 0; i < list.size(); i++) {
                        ChaTaiGson.ResultBean resultBean = list.get(i);
                        resultBean.setIsSelect(false);
                    }
                }
                notifyDataSetChanged();
            }
        });

        //删除的监听
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOndeletelistener != null) {
                    mOndeletelistener.OnDelete(list);
                }
            }
        });

        //结算回调
        btn_go_to_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 实际开发中，通过回调请求后台接口实现删除操作
                 */
                if (mChangeCountListener != null) {
                    if (!isDikou){
                        mChangeCountListener.onChangeCount(total_price,array,myouhuiquan.getTeaRice(),isDikou,tv_total_price.getText().toString());
                    }else{
                        mChangeCountListener.onChangeCount(total_price,array,0,isDikou,tv_total_price.getText().toString());
                    }
                }
            }
        });

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        boolean is = true;
        if (!isDikou){
            //合计的计算
            total_price = 0.00;
            tv_total_price.setText("¥0.00");
            array = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                ChaTaiGson.ResultBean resultBean = list.get(i);
                boolean isSelect = resultBean.getIsSelect();
                if (isSelect) {
                    try {
                        JSONObject object =new JSONObject();
                        object.put("id",resultBean.getId());
                        object.put("concentration",resultBean.getConcentration());
                        object.put("teaId",resultBean.getTeaId());
                        object.put("hasDust",resultBean.getHasDust());
                        object.put("num",resultBean.getNum());
                        array.put(object);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    int num = resultBean.getNum();
                    if (xuanzeyouhuiquan!=null) {
                        if (xuanzeyouhuiquan.getCouponType() == 1) {
                            if (xuanzeyouhuiquan.getUsableProductId() == resultBean.getTeaId()) {
                                if (is) {
                                    num = num - 1;
                                    is = false;
                                }
                            }
                            String price = String.valueOf(resultBean.getTea().getPrice());
                            double v = Double.parseDouble(String.valueOf(num));
                            double v1 = Double.parseDouble(price);
                            total_price = total_price + v * v1;
                            orderprice = decimalFormat.format(total_price);
                            tv_total_price.setText("¥" + orderprice);
                            if (xuanzeyouhuiquan.getCouponType()==3){
                                total_price = total_price * xuanzeyouhuiquan.getDiscount();
                                String orderprice = decimalFormat.format(total_price);
                                tv_total_price.setText("¥" + orderprice);
                            }
                        }else{
                            String price = String.valueOf(resultBean.getTea().getPrice());
                            double dikou  = myouhuiquan.getTeaRice()*myouhuiquan.getProportion();
                            double v = Double.parseDouble(String.valueOf(num));
                            double v1 = Double.parseDouble(price);
                            total_price = total_price + v * v1;
                            if (dikou>=total_price){
                                orderprice = decimalFormat.format(0.00);
                                tv_total_price.setText("¥" + orderprice);
                            }else{
                                orderprice = decimalFormat.format(total_price-dikou);
                                tv_total_price.setText("¥" + orderprice);
                            }
                        }
                    }
                }
            }
        }else{
            //合计的计算
            total_price = 0.00;
            tv_total_price.setText("¥0.00");
            array = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                ChaTaiGson.ResultBean resultBean = list.get(i);
                boolean isSelect = resultBean.getIsSelect();
                if (isSelect) {
                    try {
                        JSONObject object =new JSONObject();
                        object.put("id",resultBean.getId());
                        object.put("concentration",resultBean.getConcentration());
                        object.put("teaId",resultBean.getTeaId());
                        object.put("hasDust",resultBean.getHasDust());
                        object.put("num",resultBean.getNum());
                        array.put(object);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    int num = resultBean.getNum();
                    if (xuanzeyouhuiquan!=null){
                        if (xuanzeyouhuiquan.getCouponType()==1){
                            if (xuanzeyouhuiquan.getUsableProductId() == resultBean.getTeaId()){
                                if (is){
                                    num = num - 1;
                                    is = false;
                                }
                            }
                        }
                        String price = String.valueOf(resultBean.getTea().getPrice());
                        double v = Double.parseDouble(String.valueOf(num));
                        double v1 = Double.parseDouble(price);
                        total_price = total_price + v * v1;
                        orderprice = decimalFormat.format(total_price);
                        tv_total_price.setText("¥" + orderprice);
                        if (xuanzeyouhuiquan.getCouponType()==3){
                            total_price = total_price * xuanzeyouhuiquan.getDiscount();
                            String orderprice = decimalFormat.format(total_price);
                            tv_total_price.setText("¥" + orderprice);
                        }
                    }else{
                        String price = String.valueOf(resultBean.getTea().getPrice());
                        double v = Double.parseDouble(String.valueOf(num));
                        double v1 = Double.parseDouble(price);
                        total_price = total_price + v * v1;
                        orderprice = decimalFormat.format(total_price);
                        tv_total_price.setText("¥" + orderprice);

                    }
                }
            }
        }
        notifyDataSetChanged();
        bt_chami_dikou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( mOndikoulistener!= null){
                    mOndikoulistener.OnDelete(isDikou);
                }
                new Handler(context.getMainLooper()).post(new Runnable() {

                    @Override
                    public void run() {
                        // 在这里执行你要想的操作 比如直接在这里更新ui或者调用回调在 在回调中更新ui
                        if (isDikou){
                            double chamiprice = myouhuiquan.getTeaRice()*myouhuiquan.getProportion();
                            if (chamiprice<=total_price){
                                double totalprice = total_price-chamiprice;
                                orderprice = decimalFormat.format(totalprice);
                                tv_total_price.setText("¥" + orderprice);
                            }else{
                                tv_total_price.setText("¥" + 0.00);
                            }
                            img_chami_check.setImageResource(R.mipmap.select);
                            isDikou = false;
                        }else{
                            orderprice = decimalFormat.format(total_price);
                            tv_total_price.setText("¥" + orderprice);
                            img_chami_check.setImageResource(R.mipmap.unselect);
                            isDikou = true;
                        }
                    }
                });
//                notifyDataSetChanged();
            }
        });


        //商品选择框的点击事件
        groupViewHolder.bt_chatai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultBean1.setIsSelect(!isSelect1);
                if (!isSelect1 == false) {
                    resultBean1.setIsSelect(false);
                }
                boolean is = false;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getIsSelect()){
                        is= true;
                        notifyDataSetChanged();
                    }
                }
                if (is){
                    bt_delete.setVisibility(View.VISIBLE);
                    if (xuanzeyouhuiquan!=null) {
                        if (xuanzeyouhuiquan.getCouponType() == 1) {
                            if (!isSelect1){
                                resultBean1.setIsSelect(!isSelect1);
                                if (xuanzeyouhuiquan.getUsableProductId() == list.get(position).getTeaId()) {

                                }else{
                                    ToastUtils.showShort("免费券品种不一样不可使用");
                                }
                            }
                        }
                    }
                }else{
                    bt_delete.setVisibility(View.GONE);
                }
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

    private void initAddGouWuChe(int num, int id) {
        Map<String,String> map = new HashMap<>();
        map.put("teaTableId",String.valueOf(id));
        map.put("num",String.valueOf(num));
        OkGo.<String>post(Contacts.URl1+"/machine/changeNum")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void setYouHuoQuan(ChaTaiYouHuiQuan.ResultBean.CouponsBean youHuoQuan) {
        this.xuanzeyouhuiquan = youHuoQuan;
        notifyDataSetChanged();
    }

    static class GroupViewHolder extends RecyclerView.ViewHolder {
        ImageView img_check,img_chatai_photo;
        View bt_chatai;
        TextView tv_chatai_title,tv_chatai_hasDust,tv_chatai_price,tv_chatai_concentration;
        AnimShopButton amountview;
        public GroupViewHolder(View convertView) {
            super(convertView);
            img_check = convertView.findViewById(R.id.img_check);
            img_chatai_photo = convertView.findViewById(R.id.img_chatai_photo);
            bt_chatai = convertView.findViewById(R.id.bt_chatai);
            tv_chatai_title = convertView.findViewById(R.id.tv_chatai_title);
            tv_chatai_price = convertView.findViewById(R.id.tv_chatai_price);
            tv_chatai_hasDust = convertView.findViewById(R.id.tv_chatai_hasDust);
            tv_chatai_concentration = convertView.findViewById(R.id.tv_chatai_concentration);
            amountview = convertView.findViewById(R.id.amountview);
        }
    }

    private ChaTaiAdapter.OnChangeCountListener mChangeCountListener;

    public interface OnChangeCountListener {
        void onChangeCount(double total_price, JSONArray array, int teaRice,boolean isDikou,String orderprice);
    }

    public void setOnChangeCountListener(ChaTaiAdapter.OnChangeCountListener listener) {
        mChangeCountListener = listener;
    }

    private ChaTaiAdapter.OnDeleteListener mOndeletelistener;

    public interface OnDeleteListener {

        void OnDelete(List<ChaTaiGson.ResultBean> list);
    }

    public void setOnDeleteListener(ChaTaiAdapter.OnDeleteListener listener) {
        mOndeletelistener = listener;
    }

    private ChaTaiAdapter.OnDiKouListener mOndikoulistener;

    public interface OnDiKouListener {

        void OnDelete(boolean isdikou);
    }

    public void setOnDiKouListener(ChaTaiAdapter.OnDiKouListener listener) {
        mOndikoulistener = listener;
    }
}