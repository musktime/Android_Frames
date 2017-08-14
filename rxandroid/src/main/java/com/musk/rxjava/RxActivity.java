package com.musk.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.musk.rxjava.R;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class RxActivity extends AppCompatActivity {

    //观察者
    private Observer<String> observer;
    private Subscriber<String> subscriber;
    //被观察者
    private Observable<String> createObs;
    private Observable<String> justObs;
    private Observable<String> fromObs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);

        createObserver();
        createObservable();
        subScribe();
    }

    //创建观察者
    private void createObserver() {
        //创建观察者模式RxJava方式
        observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                L.i("=1=onSubscribe==");
            }

            @Override
            public void onNext(String s) {
                L.i("=1=onSubscribe==");
            }

            @Override
            public void onError(Throwable e) {
                L.i("=1=onSubscribe==");
            }

            @Override
            public void onComplete() {
                L.i("=1=onSubscribe==");
            }
        };

        //RxAndroid方式继承自RxJava，并做扩展
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {
                L.i("=2=onSubscribe==");
            }

            @Override
            public void onNext(String s) {
                L.i("=2=onNext==");
            }

            @Override
            public void onError(Throwable t) {
                L.i("=2=onError==");
            }

            @Override
            public void onComplete() {
                L.i("=2=onComplete==");
            }
        };
    }

    //创建被观察者
    private void createObservable() {
        //create方式
        createObs = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {

            }
        });
        //just方式
        justObs = Observable.just("aa", "bb", "cc", "dd", "ee", "ff");
        //from方式

        String[] ss = new String[]{"aa", "bb", "cc", "dd", "ee", "ff"};
        fromObs = Observable.fromArray(ss);

    }

    /**
     * 订阅
     * 当 Observable 被订阅的时候，OnSubscribe 的 call()
     * 方法会自动被调用，事件序列就会依照设定依次触发
     */
    private void subScribe() {
        createObs.subscribe(observer);
        justObs.subscribe(observer);
        fromObs.subscribe(observer);
    }
}
