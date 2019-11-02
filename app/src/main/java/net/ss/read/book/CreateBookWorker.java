package net.ss.read.book;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * @author ss
 * created 2019/10/30 17:24
 */
public class CreateBookWorker extends Worker {

    private BookGatherUtils bookGatherUtils;

    public CreateBookWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        bookGatherUtils = new BookGatherUtils(context);
    }

    @NonNull
    @Override
    public Result doWork() {
        bookGatherUtils.searchBook();
        return Result.success();
    }
}
