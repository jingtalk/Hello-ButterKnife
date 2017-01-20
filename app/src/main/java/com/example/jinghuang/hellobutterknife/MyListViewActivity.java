package com.example.jinghuang.hellobutterknife;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnItemLongClick;
import butterknife.OnItemSelected;

/**
 * Created by hakimhuang on 2017/1/20.
 */

public class MyListViewActivity extends Activity {

    @BindArray(R.array.arrayTest)
    String[] arraysName;
    @BindArray(R.array.arrayInfo)
    String[] arraysInfo;

    @BindView(R.id.listview)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);
        ButterKnife.bind(this);

        listView.setAdapter(new MyAdapter(this, getData()));
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;

        for (int i = 0; i < arraysName.length; i++) {
            map = new HashMap<String, Object>();
            map.put("title", arraysName[i]);
            map.put("info", arraysInfo[i]);
            map.put("img", R.mipmap.ic_launcher);
            list.add(map);
        }

        return list;
    }

    @OnItemClick(R.id.listview)
    public void itemClick(int position) {
        showItemClick(position, "click");
    }

    @OnItemLongClick(R.id.listview)
    public boolean itemLongClick(int position) {
        showItemClick(position, "longclick");
        return true;
    }

    // 触发场景
    @OnItemSelected(R.id.listview)
    public void itemSelected(int position) {
        showItemClick(position, "itemSelected");
    }

    class MyAdapter extends BaseAdapter {

        private List<Map<String, Object>> mData;
        private LayoutInflater mInflater;

        public MyAdapter(Context context, List<Map<String, Object>> data) {
            this.mInflater = LayoutInflater.from(context);
            this.mData = data;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.list_item, null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.img.setBackgroundResource((Integer) mData.get(position).get("img"));
            holder.title.setText((String) mData.get(position).get("title"));
            holder.info.setText((String) mData.get(position).get("info"));
            return convertView;
        }
    }

    public final class ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.info)
        TextView info;
        @BindView(R.id.view_btn)
        Button viewBtn;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.view_btn)
        public void showButton() {
            showItemInfoClick("Button");
        }

        @OnClick(R.id.img)
        public void showImg() {
            showItemInfoClick("Img");
        }
    }

    public void showItemInfoClick(String info) {
        new AlertDialog.Builder(this)
                .setTitle("我的Item内容")
                .setMessage("这是Item中的" + info + "被点击!")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();

    }


    public void showItemClick(int i, String info) {
        new AlertDialog.Builder(this)
                .setTitle("我的listview")
                .setMessage("这里Item i=" + i + "被触发! 类型：" + info)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();

    }
}
