package com.huohougongfu.app.Shop.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.DiaPuZhuYeActivity;
import com.huohougongfu.app.Activity.GouWuCheActivity;
import com.huohougongfu.app.Activity.XiaoXiActivity;
import com.huohougongfu.app.Gson.QuanBuLeiMu;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Adapter.DaShiLikeAdapter;
import com.huohougongfu.app.Shop.Adapter.LeiMuDaShiZhuanChangAdapter;
import com.huohougongfu.app.Shop.Adapter.LeiMuLeiBieAdapter;
import com.huohougongfu.app.Shop.Adapter.LeiMuRuZhuDianPuAdapter;
import com.huohougongfu.app.Shop.Adapter.LeiMuTeYuePinPaiAdapter;
import com.huohougongfu.app.Shop.Adapter.MenuAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

public class LeiMuActivity extends AppCompatActivity {

    private ListView lv_menu;
    private ListView lv_home;
    private int currentItem;
    private MenuAdapter menuAdapter;
    private HomeAdapter homeAdapter;
    private int scrollPosition = -1;
    private List<String> title = new ArrayList<>();
    private List<List<QuanBuLeiMu.ResultBean.ListBean>> content = new ArrayList<>();

    private ArrayList<Integer> showTitle;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lei_mu);
        intent = new Intent();
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.bt_gouwuche).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!utils.isDoubleClick()){
                    intent.setClass(LeiMuActivity.this,GouWuCheActivity.class);
                    startActivity(intent);
                }
            }
        });
        findViewById(R.id.bt_xiaoxi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!utils.isDoubleClick()){
                    intent.setClass(LeiMuActivity.this,XiaoXiActivity.class);
                    startActivity(intent);
                }
            }
        });
        initData();
    }

    private void initData() {
        OkGo.<String>get(Contacts.URl1+"query/allCatory/queryAll")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        QuanBuLeiMu leimu = gson.fromJson(body, QuanBuLeiMu.class);
                        if (leimu.getStatus() == 1){
                            initView(leimu.getResult());
                        }
                    }
                });
    }

    private void initView(List<QuanBuLeiMu.ResultBean> result) {
        showTitle = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            showTitle.add(i);
            title.add(result.get(i).getName());
            content.add(result.get(i).getList());
        }
        lv_menu =findViewById(R.id.lv_menu);
        lv_home =findViewById(R.id.lv_home);
        //设置listview的滚动条隐藏
        lv_menu.setVerticalScrollBarEnabled(false);
        lv_home.setVerticalScrollBarEnabled(false);
        menuAdapter = new MenuAdapter(this,title);
        lv_menu.setAdapter(menuAdapter);
        homeAdapter = new HomeAdapter(LeiMuActivity.this,content);
        lv_home.setAdapter(homeAdapter);

        lv_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                menuAdapter.setSelectItem(position);
                menuAdapter.notifyDataSetInvalidated();
                homeAdapter = new HomeAdapter(LeiMuActivity.this, content);
                lv_home.setAdapter(homeAdapter);
                lv_home.setSelection(showTitle.get(position));
            }
        });

        lv_home.setOnScrollListener(new AbsListView.OnScrollListener() {
            private int scrollState;

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                // TODO Auto-generated method stub
                //System.out.println("onScrollStateChanged" + "   scrollState" + scrollState);
                this.scrollState = scrollState;
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                // TODO Auto-generated method stub
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    return;
                }
                int current =showTitle.indexOf(firstVisibleItem );
                if(currentItem != current && current >=0){
                    currentItem = current;
                    menuAdapter.setSelectItem(currentItem);
                    menuAdapter.notifyDataSetInvalidated();
                }
            }
        });

}
    class HomeAdapter extends BaseAdapter {

        private final LayoutInflater inflater;
        private Context context;
        private List<String> list = new ArrayList<>();
        private List<String> mlist = new ArrayList<>();
        private List<List<QuanBuLeiMu.ResultBean.ListBean>> content;
        final int TYPE_1 = 0;
        final int TYPE_2 = 1;
        final int TYPE_3 = 2;
        final int TYPE_4 = 3;

        public  HomeAdapter(Context context, List<List<QuanBuLeiMu.ResultBean.ListBean>> content) {
            this.context = context;
            this.content = content;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return content.size();
        }

        @Override
        public Object getItem(int position) {
            return content.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getItemViewType(int position) {
            if (position == 0)
                return TYPE_1;
            else if (position ==1)
                return TYPE_2;
            else if (position ==2)
                return TYPE_3;
            else
                return TYPE_4;
        }
        //返回三个不同的布局
        @Override
        public int getViewTypeCount() {
            // TODO Auto-generated method stub
            return 4;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHold1 viewHold1 = null;
            ViewHold2 viewHold2 = null;
            ViewHold3 viewHold3 = null;
            ViewHold4 viewHold4 = null;
            int type = getItemViewType(position);
            if (convertView == null) {
                //按当前所需的样式，确定new的布局
                switch (type) {
                    case TYPE_1:
                        convertView = inflater.inflate(R.layout.item_leimu_teyuepinpai, parent, false);
                        viewHold1 = new ViewHold1();
                        viewHold1.rec_leimu_teyuepinpai =convertView.findViewById(R.id.rec_leimu_teyuepinpai);
                        convertView.setTag(viewHold1);
                        break;
                    case TYPE_2:
                        convertView = inflater.inflate(R.layout.item_leimu_dashizhuanchang, parent, false);
                        viewHold2 = new ViewHold2();
                        viewHold2.rec_leimu_dashizhuanchang =convertView.findViewById(R.id.rec_leimu_dashizhuanchang);
                        convertView.setTag(viewHold2);
                        break;
                    case TYPE_3:
                        convertView = inflater.inflate(R.layout.item_leimi_ruzhudianpu, parent, false);
                        viewHold3 = new ViewHold3();
                        viewHold3.rec_leimu_ruzhudianpu =convertView.findViewById(R.id.rec_leimu_ruzhudianpu);
                        convertView.setTag(viewHold3);
                        break;
                    case TYPE_4:
                        convertView = inflater.inflate(R.layout.item_leimu_leibie, parent, false);
                        viewHold4 = new ViewHold4();
                        viewHold4.rec_leimu_leibie =convertView.findViewById(R.id.rec_leimu_leibie);
                        convertView.setTag(viewHold4);
                        break;
                }
            } else {
                //有convertView，按样式，取得不用的布局
                switch (type) {
                    case TYPE_1:
                        viewHold1 = (ViewHold1) convertView.getTag();
                        break;
                    case TYPE_2:
                        viewHold2 = (ViewHold2) convertView.getTag();
                        break;
                    case TYPE_3:
                        viewHold3 = (ViewHold3) convertView.getTag();
                        break;
                    case TYPE_4:
                        viewHold4 = (ViewHold4) convertView.getTag();
                        break;
                }
            }
            List<QuanBuLeiMu.ResultBean.ListBean> listBeans = content.get(position);
            //设置资源
            switch (type) {
                case TYPE_1:
                    LinearLayoutManager layoutmanager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false){
                        @Override
                        public boolean canScrollVertically() {
                            return false;
                        }
                    };
                    viewHold1.rec_leimu_teyuepinpai.setLayoutManager(layoutmanager);
                    LeiMuTeYuePinPaiAdapter leimutetuepinpai = new LeiMuTeYuePinPaiAdapter(R.layout.item_leimu_teyuepinpai_zi,listBeans);
                    viewHold1.rec_leimu_teyuepinpai.setAdapter(leimutetuepinpai);
                    leimutetuepinpai.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            intent.putExtra("id",String.valueOf(listBeans.get(position).getUserId()));
                            intent.setClass(LeiMuActivity.this,DiaPuZhuYeActivity.class);
                            startActivity(intent);
                        }
                    });
                    break;
                case TYPE_2:
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(context,2){
                        @Override
                        public boolean canScrollVertically() {
                            return false;
                        }
                    };
                    viewHold2.rec_leimu_dashizhuanchang.setLayoutManager(gridLayoutManager);
                    LeiMuDaShiZhuanChangAdapter leimudashizhuanchang = new LeiMuDaShiZhuanChangAdapter(R.layout.item_leimu_dashizhuanchang_zi,listBeans);
                    viewHold2.rec_leimu_dashizhuanchang.setAdapter(leimudashizhuanchang);
                    leimudashizhuanchang.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            int dashiid = listBeans.get(position).getId();
                            intent.putExtra("id",String.valueOf(dashiid));
                            intent.setClass(LeiMuActivity.this,DaShiJianJieActivity.class);
                            startActivity(intent);
                        }
                    });
                    break;
                case TYPE_3:
                    GridLayoutManager gridLayoutManager3 = new GridLayoutManager(context,3){
                        @Override
                        public boolean canScrollVertically() {
                            return false;
                        }
                    };
                    viewHold3.rec_leimu_ruzhudianpu.setLayoutManager(gridLayoutManager3);
                    LeiMuRuZhuDianPuAdapter leimuruzhudianpu = new LeiMuRuZhuDianPuAdapter(R.layout.item_leimu_ruzhudianpu_zi,listBeans);
                    viewHold3.rec_leimu_ruzhudianpu.setAdapter(leimuruzhudianpu);
                    leimuruzhudianpu.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            intent.putExtra("id",String.valueOf(listBeans.get(position).getUserId()));
                            intent.setClass(LeiMuActivity.this,DiaPuZhuYeActivity.class);
                            startActivity(intent);
                        }
                    });
                    break;
                case TYPE_4:
                    GridLayoutManager gridLayoutManager4 = new GridLayoutManager(context,3){
                        @Override
                        public boolean canScrollVertically() {
                            return false;
                        }
                    };
                    viewHold4.rec_leimu_leibie.setLayoutManager(gridLayoutManager4);
                    LeiMuLeiBieAdapter leimuruzhudianpu2 = new LeiMuLeiBieAdapter(R.layout.item_leimu_ruzhudianpu_zi,listBeans);
                    viewHold4.rec_leimu_leibie.setAdapter(leimuruzhudianpu2);
                    leimuruzhudianpu2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            intent.putExtra("name",listBeans.get(position).getName());
                            intent.setClass(LeiMuActivity.this,LeiMuDetailActivity.class);
                            startActivity(intent);
                        }
                    });
                    break;
            }
            //
            return convertView;
        }

        private class ViewHold1 {
            private RecyclerView rec_leimu_teyuepinpai;
        }
        private class ViewHold2 {
            private RecyclerView rec_leimu_dashizhuanchang;
        }
        private class ViewHold3 {
            private RecyclerView rec_leimu_ruzhudianpu;

        }
        private class ViewHold4 {
            private RecyclerView rec_leimu_leibie;
        }


        public List<String> getData() {
            return list;
        }
        public void setData(List<String> data) {
            this.list = data;
        }
    }
}
