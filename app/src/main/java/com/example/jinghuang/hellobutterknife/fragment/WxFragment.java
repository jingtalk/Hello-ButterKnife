package com.example.jinghuang.hellobutterknife.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jinghuang.hellobutterknife.R;

/**
 * Created by hakimhuang on 2017/1/19.
 */

public class WxFragment extends Fragment{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_wx, container, false);
    }
}
