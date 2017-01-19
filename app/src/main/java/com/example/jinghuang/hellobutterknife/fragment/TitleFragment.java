package com.example.jinghuang.hellobutterknife.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.jinghuang.hellobutterknife.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hakimhuang on 2017/1/19.
 */

public class TitleFragment extends Fragment{


    @BindView(R.id.id_title_left_btn)
    ImageButton mLeftMenu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_title, container, false);
//        mLeftMenu = (ImageButton) view.findViewById(R.id.id_title_left_btn);
//        mLeftMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "i am a imagebutton in TitleFragment!", Toast.LENGTH_LONG).show();
//            }
//        });

        // Fragment中的绑定操作
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.id_title_left_btn)
    public void show() {
        Toast.makeText(getActivity(), "i am a imagebutton in TitleFragment!", Toast.LENGTH_LONG).show();
    }
}
