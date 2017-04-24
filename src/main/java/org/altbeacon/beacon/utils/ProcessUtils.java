package org.altbeacon.beacon.utils;

import android.app.ActivityManager;
import android.content.Context;

/**
 * Created by dyoung on 3/10/17.
 */

public class ProcessUtils {
    Context mContext;

    public ProcessUtils(Context context) {
        mContext = context;
    }

    public String getProcessName() {
        ActivityManager manager = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo processInfo : manager.getRunningAppProcesses()) {
            if (processInfo.pid == getPid()) {
                return  processInfo.processName;
            }
        }
        return null;
    }

    public String getPackageName() {
        return mContext.getApplicationContext().getPackageName();
    }

    public int getPid() {
        return android.os.Process.myPid();
    }

    public boolean isMainProcess() {
        return (getPackageName().equals(getProcessName()));
    }
}