package net.ss.lib.common.utils;

import android.content.Context;

import com.tencent.mmkv.MMKV;
import com.tencent.mmkv.MMKVHandler;
import com.tencent.mmkv.MMKVLogLevel;
import com.tencent.mmkv.MMKVRecoverStrategic;

import net.ss.lib.common.Slog;

/**
 * 功能:采用MMKV组件来实现缓存数据到磁盘
 * 用来替换SharedPreferences
 *
 * @author ss
 * created 2020/1/3 10:07
 */
public class MkStoreDataManager implements MMKVHandler {

    private static MkStoreDataManager sMkStoreDataManager;
    private MMKV mmkv;

    private MkStoreDataManager(Context context) {
        MMKV.initialize(context);
        mmkv = MMKV.defaultMMKV();
    }

    public static MkStoreDataManager getInstance(Context context) {
        if (sMkStoreDataManager == null) {
            synchronized (MkStoreDataManager.class) {
                if (sMkStoreDataManager == null) {
                    sMkStoreDataManager = new MkStoreDataManager(context);
                }
            }
        }
        return sMkStoreDataManager;
    }

    public void putString(String key, String value) {
        mmkv.encode(key, value);
    }

    public String getString(String key) {
        return mmkv.decodeString(key);
    }

    public String getString(String key, String defaultValue) {
        return mmkv.decodeString(key, defaultValue);
    }

    @Override
    public MMKVRecoverStrategic onMMKVCRCCheckFail(String s) {
        return null;
    }

    @Override
    public MMKVRecoverStrategic onMMKVFileLengthError(String s) {
        return null;
    }

    @Override
    public boolean wantLogRedirecting() {
        return true;
    }

    @Override
    public void mmkvLog(MMKVLogLevel mmkvLogLevel, String file, int line,
                        String func, String message) {
        String log = "<" + file + ":" + line + "::" + func + "> " + message;
        switch (mmkvLogLevel) {
            case LevelDebug:
                Slog.deBug("mmkv LevelDebug === " + log);
                break;
            case LevelInfo:
                Slog.i("mmkv LevelInfo === " + log);
                break;
            case LevelError:
                Slog.e("mmkv LevelError === " + log);
                break;
            default:
                break;
        }
    }
}
