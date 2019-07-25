package com.huohougongfu.app.Shop.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Adapter.MenuAdapter;
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
    private String[] title = new String[]{"特约品牌","大师专场","入驻店铺","茶叶","茶器","茶食茶服","茶道","家具","其他"};
    private String[] content = new String[]{"茶叶","茶器","茶食茶服","茶道","家具","其他","茶叶","茶器","茶食茶服","茶道","家具","其他","特约品牌","大师专场","入驻店铺","茶叶","茶器","茶食茶服","茶道","家具","其他"};

    private ArrayList<Integer> showTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lei_mu);
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initView();
    }
    private void initView() {
        showTitle = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            showTitle.add(i);
        }
        lv_menu =findViewById(R.id.lv_menu);
        lv_home =findViewById(R.id.lv_home);
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
        private String[] content;
        final int TYPE_1 = 0;
        final int TYPE_2 = 1;
        final int TYPE_3 = 2;
        final int TYPE_4 = 3;

        public  HomeAdapter(Context context, String[] title) {
            this.context = context;
            this.content = title;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return content.length;
        }

        @Override
        public Object getItem(int position) {
            return content[position];
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
//            //设置资源
//            switch (type) {
//                case TYPE_1:
//                    holder1.textView.setText(Integer.toString(position));
//                    holder1.checkBox.setChecked(true);
//                    break;
//                case TYPE_2:
//                    holder2.textView.setText(Integer.toString(position));
//
//                    break;
//                case TYPE_3:
//                    holder3.textView.setText(Integer.toString(position));
//                    holder3.imageView.setBackgroundResource(R.mipmap.ic_launcher);
//                    break;
//            }
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
