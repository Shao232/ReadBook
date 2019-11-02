package net.ss.lib.common;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import java.lang.ref.WeakReference;

/**
 * @author ss
 * created 2019/10/31 13:44
 */
public class PermissionManager {

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.INTERNET};

    private int mRequestCode;
    private Activity mContext;

    private static volatile PermissionManager sManager;

    public static PermissionManager getInstance(WeakReference<Activity> weakReference) {
        if (sManager == null) {
            synchronized (PermissionManager.class) {
                if (sManager == null) {
                    sManager = new PermissionManager(weakReference);
                }
            }
        }
        return sManager;
    }

    private PermissionManager(WeakReference<Activity> weakReference) {
        mContext = weakReference.get();
    }

    public void verifyStoragePermissions(Activity context, int requestCode) {
        mRequestCode = requestCode;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            boolean hasPermission = false;
            for (String permission : PERMISSIONS_STORAGE) {
                hasPermission = ActivityCompat.checkSelfPermission(context, permission)
                        == PackageManager.PERMISSION_GRANTED;
                if (!hasPermission) {
                    break;
                }
            }
            if (!hasPermission) {
                ActivityCompat.requestPermissions(context, PERMISSIONS_STORAGE, requestCode);
            }
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == mRequestCode) {
            Slog.i("onRequestPermissionsResult");
            for (String permission : permissions) {
                //如果返回true表示用户点了禁止获取权限，但没有勾选不再提示。
                //返回false表示用户点了禁止获取权限，并勾选不再提示。
                //我们可以通过该方法判断是否要继续申请权限
                ActivityCompat.shouldShowRequestPermissionRationale(mContext, permission);
            }
        }
    }

}
