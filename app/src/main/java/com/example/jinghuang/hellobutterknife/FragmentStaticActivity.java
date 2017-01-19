package com.example.jinghuang.hellobutterknife;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by hakimhuang on 2017/1/19.
 */

public class FragmentStaticActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fragment_static_main);
    }
}
