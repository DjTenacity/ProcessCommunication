package com.android.chatdemo;

import android.app.ActivityManager;
import android.app.Application;
import android.util.Log;

/**
 * 描   述:
 * 创 建 人: gaodianjie
 * 创建日期: 2018/7/10 16:49
 */
public class CCAppliaction extends Application {
    private static final String TAG = "chatdemo";
    @Override
    public void onCreate() {
        super.onCreate();
        int pid = android.os.Process.myPid();
        Log.i(TAG, "MyApplication is oncreate====="+"pid="+pid);
        String processNameString = "";
        ActivityManager mActivityManager = (ActivityManager)this.getSystemService(getApplicationContext().ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                processNameString = appProcess.processName;
            }
        }
        if("com.android.chatdemo".equals(processNameString)){
            Log.i(TAG, "processName="+processNameString+"-----work");
        }else{
            Log.i(TAG, "processName="+processNameString+"-----work");
        }
    }
}