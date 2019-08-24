package com.huohougongfu.app.Shop.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.huohougongfu.app.Adapter.ShangPinTuiJianAdapter;
import com.huohougongfu.app.Gson.MyCollect;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.Gson.TeYuePingPai;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.WoDe.Adapter.MyColleAdapter;

import java.util.List;

public class PinPaiItemAdapter extends RecyclerView.Adapter<PinPaiItemAdapter.ViewHolder> {

    private List<TeYuePingPai.ResultBean.ResultListBean.ListBean.MallProductListBean>  data;
    private Context context;
    private PinPaiItemAdapter.OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(PinPaiItemAdapter.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
    public interface OnItemClickListener {
        void onItemClickListener(int pos);
    }

    public PinPaiItemAdapter(Context context, List<TeYuePingPai.ResultBean.ResultListBean.ListBean.MallProductListBean> productList) {
        this.data = productList;
        this.context = context;
    }
    @NonNull
    @Override
    public PinPaiItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_shangpin_tuijian, viewGroup, false);
        PinPaiItemAdapter.ViewHolder viewHolder = new PinPaiItemAdapter.ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PinPaiItemAdapter.ViewHolder viewHolder, final  int position) {

        viewHolder.tv_shangpin_price.setText(String.valueOf(data.get(position).getPrice()));
        viewHolder.tv_shangpin_title.setText(String.valueOf(data.get(position).getName()));
        Glide.with(context).load(data.get(position).getCoverUrl()).into(viewHolder.img_shangpin_photo);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener!=null){
                    mOnItemClickListener.onItemClickListener(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (data.size()>3){
            return 3;
        }else{
            return data.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_shangpin_photo;
        TextView tv_shangpin_title,tv_shangpin_price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_shangpin_photo = itemView.findViewById(R.id.img_shangpin_photo);
            tv_shangpin_title = itemView.findViewById(R.id.tv_shangpin_title);
            tv_shangpin_price = itemView.findViewById(R.id.tv_shangpin_price);
        }
    }
}