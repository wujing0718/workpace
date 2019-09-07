package com.huohougongfu.app.WoDe.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.JsonArray;
import com.huohougongfu.app.Gson.ChanPinCanShu;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.WoDe.Activity.DianPuTongJiActivity;
import com.huohougongfu.app.WoDe.Activity.ShopCanShuActivity;
import com.huohougongfu.app.WoDe.Activity.ShopDetailActivity;
import com.kongzue.dialog.v2.SelectDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class CanShuAdapter extends RecyclerView.Adapter<CanShuAdapter.ViewHolder>{
    private final Context context;
    private ChanPinCanShu keys;
    private ArrayList<Object> list;
    private  ArrayList<Integer>typelist;
    private String nowTime2;
    private View v ;

    public CanShuAdapter(ChanPinCanShu keys, ArrayList<Object> list, ArrayList<Integer> typelist, ShopCanShuActivity context, View v) {
        this.keys = keys;
        this.list = list;
        this.context =context;
        this.typelist = typelist;
        this. v =  v;
    }

    @NonNull
    @Override
    public CanShuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CanShuAdapter.ViewHolder holder = new CanShuAdapter.ViewHolder(LayoutInflater.from(MyApp.context).inflate(R.layout.item_tianjia_shop_canshu, viewGroup, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CanShuAdapter.ViewHolder viewHodel, int i) {
        viewHodel.tv_canshu_name.setText(keys.getResult().getKeys().get(i));
        if (typelist.get(i) ==1){//boolean类型
            hideInput();
            viewHodel.edt_canshu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SelectDialog.show(context, "提示", "请做出你的选择", "是", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            viewHodel.edt_canshu.setText("是");
                        }
                    }, "否", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            viewHodel.edt_canshu.setText("否");
                        }
                    });

                    if (viewHodel.edt_canshu.getTag() != null && viewHodel.edt_canshu.getTag() instanceof TextWatcher) {
                        viewHodel.edt_canshu.removeTextChangedListener((TextWatcher) viewHodel.edt_canshu.getTag());
                    }
                    TextWatcher textWatcher = new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                            if (s.length() > 0) {
                                if (typelist.get(i)==1){

                                }
                                list.set(i,s.toString());
                            } else {
                                list.set(i,"");
                            }
                        }
                    };

                    viewHodel.edt_canshu.addTextChangedListener(textWatcher);
                    viewHodel.edt_canshu.setTag(textWatcher);
                }
            });
            viewHodel.edt_canshu.setFocusableInTouchMode(false);
        }else if (typelist.get(i) == 2){//时间格式
            viewHodel.edt_canshu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    hideInput();
                    //时间选择器
                    TimePickerView pvTime = new TimePickerBuilder(context, new OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            SimpleDateFormat formatter_day = new SimpleDateFormat("yyyy-MM-dd");
                            nowTime2 = formatter_day.format(date);
                            viewHodel.edt_canshu.setText(nowTime2);
                        }
                    }).build();
                    pvTime.show();
                    if (viewHodel.edt_canshu.getTag() != null && viewHodel.edt_canshu.getTag() instanceof TextWatcher) {
                        viewHodel.edt_canshu.removeTextChangedListener((TextWatcher) viewHodel.edt_canshu.getTag());
                    }
                    TextWatcher textWatcher = new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                            if (s.length() > 0) {
                                if (typelist.get(i)==1){

                                }
                                list.set(i,s.toString());
                            } else {
                                list.set(i,"");
                            }
                        }
                    };

                    viewHodel.edt_canshu.addTextChangedListener(textWatcher);
                    viewHodel.edt_canshu.setTag(textWatcher);
                }
            });
            viewHodel.edt_canshu.setFocusableInTouchMode(false);
        }else if (typelist.get(i) == 3){//输入框
            viewHodel.edt_canshu.setOnClickListener(null);
            viewHodel.edt_canshu.setEnabled(true);
            viewHodel.edt_canshu.setFocusableInTouchMode(true);
            if (viewHodel.edt_canshu.getTag() != null && viewHodel.edt_canshu.getTag() instanceof TextWatcher) {
                viewHodel.edt_canshu.removeTextChangedListener((TextWatcher) viewHodel.edt_canshu.getTag());
            }
            viewHodel.edt_canshu.setText(list.get(i).toString());

            TextWatcher textWatcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (s.length() > 0) {
                        if (typelist.get(i)==1){

                        }
                        list.set(i,s.toString());
                    } else {
                        list.set(i,"");
                    }
                }
            };

            viewHodel.edt_canshu.addTextChangedListener(textWatcher);
            viewHodel.edt_canshu.setTag(textWatcher);
        }

//        viewHodel.edt_canshu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (typelist.get(i) ==1){//boolean类型
//                    viewHodel.edt_canshu.setInputType(InputType.TYPE_NULL);
//                }else if (typelist.get(i) == 2){//时间格式
//
//                }else if (typelist.get(i) == 3){//输入框
//                    viewHodel.edt_canshu.setInputType(InputType.TYPE_CLASS_TEXT);
//                }
//            }
//        });

//        bt_queding.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                JSONArray jsonArray = new JSONArray();
//                if (list.size() == keys.size()){
//                    for (int j = 0; j < list.size(); j++) {
//                        JSONObject jsonObject = new JSONObject();
//                        try {
//                            jsonObject.put("key",keys.get(j));
//                            jsonObject.put("value",list.get(j));
//                            jsonArray.put(jsonObject);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }else{
//                    ToastUtils.showShort("请输入参数");
//                }
//            }
//        });
    }

    public interface OnCountListener {
        void onChangeCount(JSONArray jsonArray);
    }

    public void setOnCountListener(OnCountListener listener) {
        mCountListener = listener;
    }

    private OnCountListener mCountListener;

    @Override
    public int getItemCount() {
        return keys.getResult().getKeys().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_canshu_name;
        EditText edt_canshu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             tv_canshu_name = itemView.findViewById(R.id.tv_canshu_name);
            edt_canshu = itemView.findViewById(R.id.edt_canshu);

        }
    }

    /**
     * 隐藏键盘
     */
    protected void hideInput() {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
        if (null != v) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }
}
