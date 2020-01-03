package net.ss.read.book;

import androidx.annotation.NonNull;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import net.ss.lib.common.PermissionManager;
import net.ss.lib.common.base.BaseActivity;

import java.lang.ref.WeakReference;

/**
 * @author shao
 */
public class MainActivity extends BaseActivity {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private PermissionManager permissionManager;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initCreate() {
        permissionManager = PermissionManager.getInstance(new WeakReference<>(this));
        permissionManager.verifyStoragePermissions(this, REQUEST_EXTERNAL_STORAGE);

//        Map<String,String> params = new HashMap<>(3);
//        params.put("password","wasd150136");
//        params.put("username","15021781502");
//        params.put("usecookie","43200");
//        params.put("action","login");

//        RetrofitHelp.getInstance()
//                .getRetrofit()
//                .create(ApiUrl.class)
//                .loginApi(params)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<AbstractResponseBean<LoginInfoBean>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Slog.i("登录 Disposable >>"+ d.isDisposed());
//                    }
//
//                    @Override
//                    public void onNext(AbstractResponseBean<LoginInfoBean> o) {
//                        Slog.i("登录 onNext response>>"+ o.toString());
//                        Slog.i("登录 onNext data>>"+ o.data.toString());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Slog.i("登录 onError >>"+ e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Slog.i("登录 success ");
//                    }
//                });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
        initMethod();
    }

    private void initMethod() {
        OneTimeWorkRequest oneTimeWorkRequest =
                new OneTimeWorkRequest.Builder(CreateBookWorker.class).build();
        WorkManager.getInstance(this).enqueue(oneTimeWorkRequest);
    }
}
