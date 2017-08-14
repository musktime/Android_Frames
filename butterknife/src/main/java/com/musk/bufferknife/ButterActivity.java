package com.musk.bufferknife;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindBitmap;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by musk on 2017/8/14.
 */

public class ButterActivity extends AppCompatActivity {

    private Unbinder unBiner;

    //view注入
    @BindView(R2.id.btn_butter)
    Button btnGo;

    //resource注入
    @BindString(R2.string.app_name)
    String butter;
    @BindDrawable(R2.drawable.abc_edit_text_material)
    Drawable drawable;

    //单事件注入
    @OnClick(R2.id.btn_butter)
    public void onButterClick(View v) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_butter);
        unBiner = ButterKnife.bind(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unBiner != null)
            unBiner.unbind();
    }
}
