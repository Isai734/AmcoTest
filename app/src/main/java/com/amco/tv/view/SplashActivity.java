package com.amco.tv.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.amco.tv.R;

import rx.Observable;
import rx.Subscriber;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();
    private Observable taskOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        initGoMain();
    }

    public void initGoMain() {
        taskOperator = Observable.create(new TaskObservable());
        taskOperator.subscribe(new TaskSubscriber());
    }

    public class TaskObservable implements Observable.OnSubscribe<Void> {
        @Override
        public void call(Subscriber<? super Void> subscriber) {
            subscriber.onNext(longRunningOperation());
            subscriber.onCompleted();
        }

        public Void longRunningOperation() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // error
            }
            return null;
        }
    }

    /**
     * Listener de RxJava que espera resuesta de hilo Observable
     */
    public class TaskSubscriber extends Subscriber<Void> {
        @Override
        public void onCompleted() {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }

        @Override
        public void onError(Throwable e) {
            Log.d(TAG, "onError TaskSubscriber: " + e.toString());
        }

        @Override
        public void onNext(Void s) {
        }
    }
}
