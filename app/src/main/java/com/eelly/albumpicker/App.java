package com.eelly.albumpicker;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;


/**
 * author：luck
 * project：PictureSelector
 * package：com.luck.pictureselector
 * email：893855882@qq.com
 * data：2017/4/29
 */

public class App extends Application {

    private final String TAG = "APP";

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(mCallBack);
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        LeakCanary.install(this);
    }

    private ActivityLifecycleCallbacks mCallBack = new ActivityLifecycleCallbacks(){
        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Log.i(TAG,activity.getClass().getSimpleName() + "onActivityCreated");
        }

        @Override
        public void onActivityStarted(Activity activity) {
            Log.i(TAG,activity.getClass().getSimpleName() + "onActivityStarted");
        }

        @Override
        public void onActivityResumed(Activity activity) {
            Log.i(TAG,activity.getClass().getSimpleName() + "onActivityResumed");
        }

        @Override
        public void onActivityPaused(Activity activity) {
            Log.i(TAG,activity.getClass().getSimpleName() + "onActivityPaused");
        }

        @Override
        public void onActivityStopped(Activity activity) {
            Log.i(TAG,activity.getClass().getSimpleName() + "onActivityStopped");
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Log.i(TAG,activity.getClass().getSimpleName() + "onActivitySaveInstanceState");
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            Log.i(TAG,activity.getClass().getSimpleName() + "onActivityDestroyed");
        }
    };
}
