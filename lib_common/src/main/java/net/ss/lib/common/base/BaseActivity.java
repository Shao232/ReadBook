package net.ss.lib.common.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import net.ss.lib.common.utils.IntentUtils;
import net.ss.lib.common.utils.MkStoreDataManager;
import net.ss.lib.common.utils.ScreenUtils;

/**
 * @author ss
 * created 2019/11/2 13:38
 */
public abstract class BaseActivity<V extends ViewDataBinding> extends RxAppCompatActivity {

    protected RxAppCompatActivity mContext;
    protected MkStoreDataManager mkStoreDataManager;
    private IntentUtils mIntentUtils;

    protected V mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mkStoreDataManager = MkStoreDataManager.getInstance(getApplicationContext());
        mIntentUtils = IntentUtils.getInstance();
        ScreenUtils.getInstance().getScreenWidthAndHeight(getApplicationContext());
        int contentView = getLayout();
        if (contentView != 0) {
            mBinding = DataBindingUtil.setContentView(this, contentView);
        }
        initCreate();
    }

    protected void startActivity(Class clazz) {
        mIntentUtils.startActivity(mContext, clazz);
    }

    protected void startActivity(Class clazz,int requestCode) {
        mIntentUtils.startActivity(mContext,clazz,requestCode);
    }

    /**
     * 子类 activity 布局资源
     *
     * @return layout 资源
     */
    protected abstract int getLayout();

    /**
     * 子类不需要重载onCreate,只需重写此方法初始化Create
     */
    protected abstract void initCreate();

}
