package com.musk.bufferknife.tips;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.musk.bufferknife.R;

import java.lang.reflect.Method;

/**
 * Created by musk on 2017/8/14.
 */

public class TestMyAnnotation extends Activity {
    private String mName;
    private int mId;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_my_annotation);
        getMyAnnotataion(TestMyAnnotation.class);
    }

    public void clickAnno(View view) {
        testMyAnnotataion();
    }

    @MyAnnotation(name = "musk", id = 1)
    private void testMyAnnotataion() {
        Toast.makeText(this, mName + ":" + mId, Toast.LENGTH_SHORT).show();
    }

    private void getMyAnnotataion(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            if (myAnnotation != null) {
                mName = myAnnotation.name();
                mId = myAnnotation.id();
            }
        }
    }
}
