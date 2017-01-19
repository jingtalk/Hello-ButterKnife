package com.example.jinghuang.hellobutterknife;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindArray;
import butterknife.BindBitmap;
import butterknife.BindBool;
import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindDrawable;
import butterknife.BindInt;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private final String TAG = MainActivity.this.getClass().getSimpleName();

    // View绑定
    @BindView(R.id.tvWorld)
    TextView tvWorld;
    @BindView(R.id.tvChina)
    TextView tvChina;
    @BindView(R.id.tvShenZhen)
    TextView tvShenZhen;

    // 资源绑定
    @BindArray(R.array.arrayTest)
    String[] arrays;

    @BindColor(R.color.colorTest)
    int colorValue;

    @BindString(R.string.stringTest)
    String stringValue;

    @BindBitmap(R.mipmap.avator_one)
    Bitmap avatorOne;

    @BindDrawable(R.mipmap.avator_two)
    Drawable avatorTwo;

    @BindBool(R.bool.boolTest)
    boolean bool;

    @BindDimen(R.dimen.dimenTest)
    int dimen;  // int (for pixel size) or float (for exact value) field

    @BindInt(R.integer.intTest)
    int intValue;

    // 可绑定 float 类型的 dimen 资源 - 待验证
//    @BindFloat(R.dimen.floatTest)
//    float floatValue;

    @BindViews({R.id.tvWorld, R.id.tvChina, R.id.tvShenZhen})
    List<TextView> tvList;

    @BindView(R.id.ivBitmap)
    ImageView ivBitmap;

    @BindView(R.id.ivDrawable)
    ImageView ivDrawable;

    // onClick onLongClick会完成下面两步的绑定操作，所以不需要也是可以的
//    @BindView(R.id.btnLogin)
//    Button btnLogin;
//
//    @BindView(R.id.btnCancel)
//    Button binCancel;

    @OnClick({R.id.ivBitmap, R.id.ivDrawable})
    public void sayHiToast(View v) {
        switch (v.getId()) {
            case R.id.ivBitmap:
                Toast.makeText(getApplicationContext(), "ivBitmap click", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ivDrawable:
                Toast.makeText(getApplicationContext(), "ivDrawable click", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @OnClick(R.id.btnLogin)
    public void doLogin() {
        Toast.makeText(getApplicationContext(), "doLogin click", Toast.LENGTH_SHORT).show();
    }

    @OnLongClick(R.id.btnLogin)
    public boolean doLogin(Button button) {
        button.setText("Login update");
        return true;
    }

    @OnClick(R.id.btnCancel)
    public void doCancel(Button button) {
        Toast.makeText(getApplicationContext(), "doCancel click", Toast.LENGTH_SHORT).show();
        button.setText("Error");
    }


    @BindView(R.id.toolbar)
    Toolbar toolbar;

//    @BindView(R.id.fab)
//    FloatingActionButton fab;

    @OnClick(R.id.fab)
    public void make(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Log.d(TAG, "onCreate called, bool=" + bool + ", dimen=" + dimen + ", intValue="
                + intValue + ", stringValue=" + stringValue + ", arrays=" + arrays.toString());

        tvShenZhen.setText(stringValue);
        tvShenZhen.setTextColor(colorValue);

        tvList.get(0).setText(arrays[0]);

        ivBitmap.setBackground(avatorTwo);
        ivDrawable.setBackground(new BitmapDrawable(avatorOne));

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent i = null;
        if (id == R.id.nav_fragmentStatic) {
            // Handle the camera action
            i = new Intent(this, FragmentStaticActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_fragmentDynamic) {
            i = new Intent(this, FragmentDynamicActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_list) {
            i = new Intent(this, MyListActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
