package com.example.jinghuang.hellobutterknife;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hakimhuang on 2017/1/19.
 */

public class ZeleznyPluginTestActivity extends Activity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tvWorld)
    TextView tvWorld;
    @BindView(R.id.tvChina)
    TextView tvChina;
    @BindView(R.id.tvShenZhen)
    TextView tvShenZhen;
    @BindView(R.id.ivDrawable)
    ImageView ivDrawable;
    @BindView(R.id.ivBitmap)
    ImageView ivBitmap;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.btnCancel)
    Button btnCancel;
    @BindView(R.id.content_main)
    RelativeLayout contentMain;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnLogin, R.id.btnCancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                break;
            case R.id.btnCancel:
                break;
        }
    }
}
