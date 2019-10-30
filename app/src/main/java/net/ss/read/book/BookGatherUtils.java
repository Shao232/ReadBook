package net.ss.read.book;

import android.content.Context;

import net.ss.lib.common.SLog;

import java.io.File;

/**
 * @author ss
 * created 2019/10/30 15:00
 */
public class BookGatherUtils {

    private Context mContext;

    public BookGatherUtils(Context context) {
        mContext = context;
    }

    public void searchBook() {
        if (mContext.getExternalCacheDir() != null
                && mContext.getExternalCacheDir().isDirectory()) {
            setTraversalFile(mContext.getExternalCacheDir());
        }

        File fileDirectory = new File("/storage/emulated/0/Android/data/" +
                "com.biquge.ebook.app/files/books");
        SLog.i(" file >>>" + fileDirectory.getAbsolutePath());


    }

    /**
     * traversal file
     *
     * @param file directory
     */
    public void setTraversalFile(File file) {
        if (file.exists() && file.isDirectory()) {
            SLog.i(" directory >>> " + file.getAbsolutePath());
            File[] fileArray = file.listFiles();
            if (fileArray != null) {
                for (File childFile : fileArray) {
                    if (!childFile.isDirectory()) {
                        SLog.i(" file >>>" + childFile.getAbsolutePath());
                    } else {
                        setTraversalFile(childFile);
                    }
                }
            }
        }
    }

}
