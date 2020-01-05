package net.ss.lib.common.utils;

import android.content.Intent;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * @author shaoshuai
 * @version 1.0
 * @date 2020/1/5 20:27
 */
public class IntentUtils {

    private static volatile IntentUtils sIntentUtils;

    private IntentUtils(){
    }

    public static IntentUtils getInstance(){
        if (sIntentUtils == null) {
            synchronized (IntentUtils.class) {
                if (sIntentUtils == null) {
                    sIntentUtils = new IntentUtils();
                }
            }
        }
        return sIntentUtils;
    }

    public void startActivity(RxAppCompatActivity context, Class clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }

    public void startActivity(RxAppCompatActivity context, Class clazz, int requestCode) {
        Intent intent = new Intent(context, clazz);
        context.startActivityForResult(intent, requestCode);
    }

}
