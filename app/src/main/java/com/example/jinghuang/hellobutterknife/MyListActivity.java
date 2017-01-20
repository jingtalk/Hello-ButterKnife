package com.example.jinghuang.hellobutterknife;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hakimhuang on 2017/1/19.
 */

public class MyListActivity extends ListActivity {

    String[] arraysName;
    String[] arraysInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arraysName = getResources().getStringArray(R.array.arrayTest);
        arraysInfo = getResources().getStringArray(R.array.arrayInfo);

        setListAdapter(new MyBaseAdapter(this, getData()));
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;

        for (int i = 0; i < arraysName.length; i++) {
            map = new HashMap<String, Object>();
            map.put("title", arraysName[i]);
            map.put("info", arraysInfo[i]);
            map.put("img", R.mipmap.avator_one);
            list.add(map);
        }

        return list;
    }


    public class MyBaseAdapter extends BaseAdapter {

        private List<Map<String, Object>> mData;
        private LayoutInflater mInflater;

        public MyBaseAdapter(Context context, List<Map<String, Object>> data) {
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
/*

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.list_item, null);
                holder.img = (ImageView) convertView.findViewById(R.id.img);
                holder.title = (TextView) convertView.findViewById(R.id.title);
                holder.info = (TextView) convertView.findViewById(R.id.info);
                holder.viewBtn = (Button) convertView.findViewById(R.id.view_btn);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.img.setBackgroundResource((Integer) mData.get(position).get("img"));
            holder.title.setText((String) mData.get(position).get("title"));
            holder.info.setText((String) mData.get(position).get("info"));
            holder.viewBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    showInfo();
                }
            });
            return convertView;
        }
*/

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolderBK holder = null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.list_item, null);
                holder = new ViewHolderBK(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolderBK) convertView.getTag();
            }
            holder.img.setBackgroundResource((Integer) mData.get(position).get("img"));
            holder.title.setText((String) mData.get(position).get("title"));
            holder.info.setText((String) mData.get(position).get("info"));
            return convertView;
        }
    }

    public final class ViewHolder {
        public ImageView img;
        public TextView title;
        public TextView info;
        public Button viewBtn;
    }

    public final class ViewHolderBK {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.info)
        TextView info;
        @BindView(R.id.view_btn)
        Button viewBtn;

        public ViewHolderBK(View view) {
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.view_btn)
        public void show() {
            showInfo();
        }
    }

    public void showInfo() {
        new AlertDialog.Builder(this)
                .setTitle("我的listview")
                .setMessage("这里只是一个介绍而已...")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();

    }
}
