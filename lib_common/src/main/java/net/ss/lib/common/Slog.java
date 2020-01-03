package net.ss.lib.common;

import android.util.Log;

/**
 * @author ss
 * created 2019/10/30 15:14
 */
public class Slog {

    private static final String STAG = Slog.class.getSimpleName();

    public static void deBug(String msg) {
        Log.d(STAG,msg);
    }

    public static void deBug(String tag,String msg){
        Log.d(tag, msg);
    }

    public static void i(String msg) {
        Log.i(STAG,msg);
    }

    public static void i(String tag,String msg){
        Log.i(tag, msg);
    }

    public static void e(String msg) {
        Log.e(STAG,msg);
    }

    public static void e(String tag,String msg){
        Log.e(tag, msg);
    }

}
