package com.musk.eventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.musk.frames.eventbus.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import event.MyEvent;

public class EventbusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);
        //注册
        EventBus.getDefault().register(this);
    }

    public void onClick(View v) {
        startActivity(new Intent(this, ebActivity.class));
    }

    //使用注解方式标记事件响应方法
    @Subscribe
    public void onEventMainThread(MyEvent event) {
        Toast.makeText(this, event.message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除注册
        EventBus.getDefault().unregister(this);
    }
}
