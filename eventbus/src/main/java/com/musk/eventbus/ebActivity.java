package com.musk.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.musk.frames.eventbus.R;

import org.greenrobot.eventbus.EventBus;

import event.MyEvent;

/**
 * Created by musk on 2017/8/14.
 */

public class ebActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eb);
    }

    public void onClickBack(View v) {
        EventBus.getDefault().post(new MyEvent("这是ebActivity发出的消息！"));
    }
}
