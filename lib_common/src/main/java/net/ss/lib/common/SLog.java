package net.ss.lib.common;

import android.util.Log;

/**
 * @author ss
 * created 2019/10/30 15:14
 */
public class SLog {

    private static final String STAG = SLog.class.getSimpleName();

    public static void i(String msg) {
        Log.i(STAG,msg);
    }

    public static void i(String tag,String msg){
        Log.i(tag, msg);
    }

}
