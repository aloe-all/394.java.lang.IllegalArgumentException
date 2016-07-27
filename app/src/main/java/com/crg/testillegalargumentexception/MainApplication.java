package com.crg.testillegalargumentexception;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by crg on 16-7-27.
 */
public class MainApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "900042319", true);
    }
}
