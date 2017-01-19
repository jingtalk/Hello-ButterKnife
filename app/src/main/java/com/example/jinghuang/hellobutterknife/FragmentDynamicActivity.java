package com.example.jinghuang.hellobutterknife;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.jinghuang.hellobutterknife.fragment.ContentFragment;
import com.example.jinghuang.hellobutterknife.fragment.FriendFragment;
import com.example.jinghuang.hellobutterknife.fragment.WxFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hakimhuang on 2017/1/19.
 */

public class FragmentDynamicActivity extends Activity {

    private WxFragment mWx;
    private FriendFragment mFriend;
    private ContentFragment mContent;

    @OnClick({R.id.btnFri, R.id.btnWx})
    public void process(View view) {

        // 开启事务
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        switch (view.getId()) {
            case R.id.btnFri:
                if (mFriend == null) {
                    mFriend = new FriendFragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.id_content, mFriend);
                break;
            case R.id.btnWx:
                if (mWx == null) {
                    mWx = new WxFragment();
                }
                transaction.replace(R.id.id_content, mWx);
                break;
            default:
                break;
        }

        // 事务提交
        transaction.commit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fragment_dynamic_main);
        ButterKnife.bind(this);

        mContent = new ContentFragment();
        getFragmentManager().beginTransaction().replace(R.id.id_content, mContent).commit();
    }

}
