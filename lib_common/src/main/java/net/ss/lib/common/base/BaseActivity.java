package net.ss.lib.common.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import net.ss.lib.common.utils.MkStoreDataManager;

/**
 * @author ss
 * created 2019/11/2 13:38
 */
public abstract class BaseActivity extends RxAppCompatActivity {

    protected MkStoreDataManager mkStoreDataManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mkStoreDataManager = MkStoreDataManager.getInstance(getApplicationContext());

    }
}
