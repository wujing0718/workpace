package com.huohougongfu.app.Shop.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
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

        private Context context;
        private List<String> list = new ArrayList<>();
        private List<String> mlist = new ArrayList<>();
        private String[] content;
        public  HomeAdapter(Context context, String[] title) {
            this.context = context;
            this.content = title;
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
        public View getView(int position, View convertView, ViewGroup parent) {
            HomeAdapter.ViewHold viewHold = null;
            if (convertView == null) {
                convertView = View.inflate(context, R.layout.item_home, null);
                viewHold = new HomeAdapter.ViewHold();
                viewHold.tv_title = convertView.findViewById(R.id.tv_title);
                convertView.setTag(viewHold);
            } else {
                viewHold = (HomeAdapter.ViewHold) convertView.getTag();
            }
            viewHold.tv_title.setText(content[position]);
            //
            return convertView;
        }

        private class ViewHold {
            private TextView tv_title;
        }
        public List<String> getData() {
            return list;
        }
        public void setData(List<String> data) {
            this.list = data;
        }
    }
}
