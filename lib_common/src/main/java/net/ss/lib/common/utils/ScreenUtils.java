package net.ss.lib.common.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import net.ss.lib.common.Slog;

/**
 * @author ss
 * created 2020/1/3 11:20
 */
public class ScreenUtils {

    private static volatile ScreenUtils screenUtils;

    private ScreenUtils() {
    }

    public static ScreenUtils getInstance() {
        if (screenUtils == null) {
            synchronized (ScreenUtils.class) {
                if (screenUtils == null) {
                    screenUtils = new ScreenUtils();
                }
            }
        }
        return screenUtils;
    }

    public void getScreenWidthAndHeight(Context context) {
        WindowManager w = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (w != null) {
            Display d = w.getDefaultDisplay();
            DisplayMetrics metrics = new DisplayMetrics();
            d.getMetrics(metrics);
            Slog.i("screen width,height === "
                    + metrics.widthPixels + "," + metrics.heightPixels);
        }
    }

}
