package com.musk.frame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.musk.bufferknife.ButterActivity;
import com.musk.eventbus.EventbusActivity;
import com.musk.rxjava.RxActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View v) {
        int id = v.getId();
        if (id == R.id.btn_bus) {
            startActivity(new Intent(this, EventbusActivity.class));
        } else if (id == R.id.btn_butter) {
            startActivity(new Intent(this, ButterActivity.class));
        } else if (id == R.id.btn_rx) {
            startActivity(new Intent(this, RxActivity.class));
        } else {

        }
    }
}
