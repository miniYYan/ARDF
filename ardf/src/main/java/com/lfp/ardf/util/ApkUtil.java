package com.lfp.ardf.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

import com.lfp.ardf.debug.LogUtil;

import java.io.File;

/**
 * 获得Apk信息<br/>
 * Created by LiFuPing on 2016/1/18.
 */
public class ApkUtil {

    private static Context mContext;
    private static PackageInfo mPackInfo;


    private ApkUtil() {
    }

    public static final void init(Context c) {
        mContext = c.getApplicationContext();
    }

    public static final boolean isInit(){
        return mContext!=null;
    }

    static PackageInfo getPackageInfo() {
        if (mPackInfo == null) try {
            mPackInfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
        } catch (Exception e) {
            LogUtil.e(e);
        }
        return mPackInfo;
    }

    /**
     * 获得App名称
     */
    public static String getAppName() {
        PackageManager packageManager = null;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = mContext.getApplicationContext().getPackageManager();
            applicationInfo = packageManager.getApplicationInfo(mContext.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        return applicationInfo == null ? "" : (String) packageManager.getApplicationLabel(applicationInfo);
    }

    /**
     * 获得版本信息
     *
     * @return
     */
    public static String getVersionName() {
        return getPackageInfo().versionName;
    }

    /**
     * 获得版本号
     *
     * @return
     */
    public static int getVersionCode() {
        return getPackageInfo().versionCode;
    }

    /**
     * 获得App ID
     *
     * @return
     */
    public static String getSharedUserId() {
        return getPackageInfo().sharedUserId;
    }

    /**
     * 获得App包信息
     *
     * @return
     */
    public static PackageInfo getAppPackageInfo() {
        return getPackageInfo();
    }

    /**
     * 获得App对于的data目录
     *
     * @return data目录地址
     */
    public static String getPackageDataPath() {
        return "/data/data/" + ApkUtil.getAppPackageInfo().packageName;
    }

    /**
     * 安装apk
     */
    public static void installApk(String filePath) {
        File apkfile = new File(filePath);
        if (!apkfile.exists()) {
            return;
        }
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setDataAndType(Uri.parse("file://" + apkfile.toString()), "application/vnd.android.package-archive");
        mContext.startActivity(i);
    }

}