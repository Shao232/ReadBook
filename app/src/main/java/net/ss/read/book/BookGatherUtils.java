package net.ss.read.book;

import android.content.Context;
import android.util.Log;
import net.ss.lib.common.Slog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

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
        Slog.i("path >>> " + mContext.getExternalCacheDir());
        File fileDirectory = new File("/storage/emulated/0/Android/data/" +
                "com.gudianbiquge.ebook.app/files/books");
        //com.biquge.ebook.app
        File[] fileArray = fileDirectory.listFiles();
        if (fileArray != null) {
            for (File file : fileArray) {
                if (file.isDirectory()) {
                    Slog.i(" directory >>>" + file.getAbsolutePath());
                    File childFile = new File(file.getAbsolutePath() + "/1/");
                    File[] childDirectoryArray = childFile.listFiles();
                    if (childDirectoryArray != null) {
                        int i = 0;
                        for (File bookFile : childDirectoryArray) {
                            Slog.i(" file >>>" + bookFile.getAbsolutePath());
                            String content = getFileContent(bookFile);
                            writeTxtToFile(content, "/storage/emulated/0/books/",
                                    "data_" + i + ".txt");
                            i++;
                        }
                    }
                }
            }
        }
    }

    /**
     * 将字符串写入到文本文件中
     */
    private void writeTxtToFile(String strcontent, String filePath, String fileName) {
        //生成文件夹之后，再生成文件，不然会出错
        makeFilePath(filePath, fileName);
        String strFilePath = filePath + fileName;
        // 每次写入时，都换行写
        String strContent = strcontent + "\r\n";
        try {
            File file = new File(strFilePath);
            if (!file.exists()) {
                Log.d("TestFile", "Create the file:" + strFilePath);
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rwd");
            raf.seek(file.length());
            raf.write(strContent.getBytes());
            raf.close();
        } catch (Exception e) {
            Log.e("TestFile", "Error on write File:" + e);
        }
    }


    /**
     * 生成文件
     *
     * @param filePath path
     * @param fileName name
     * @return file
     */
    private File makeFilePath(String filePath, String fileName) {
        File file = null;
        makeRootDirectory(filePath);
        try {
            file = new File(filePath + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * 生成文件夹
     *
     * @param filePath
     */
    private static void makeRootDirectory(String filePath) {
        File file;
        try {
            file = new File(filePath);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            Log.e("error:", e + "");
        }
    }

    /**
     * 读取指定目录下的所有TXT文件的文件内容
     *
     * @param file file
     */
    private String getFileContent(File file) {
        StringBuilder content = new StringBuilder();
        //检查此路径名的文件是否是一个目录(文件夹)
        if (!file.isDirectory()) {
            String txt = "txt";
            //文件格式为""文件
            if (file.getName().endsWith(txt)) {
                try {
                    InputStream inputStream = new FileInputStream(file);
                    InputStreamReader inputStreamReader
                            = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String line;
                    //分行读取
                    while ((line = bufferedReader.readLine()) != null) {
                        content.append(line).append("\n");
                    }
                    inputStream.close();//关闭输入流
                } catch (java.io.FileNotFoundException e) {
                    Log.d("TestFile", "The File doesn't not exist.");
                } catch (IOException e) {
                    Log.d("TestFile", Objects.requireNonNull(e.getMessage()));
                }
            }
        }
        return content.toString();
    }

    /**
     * traversal file
     *
     * @param file directory
     */
    public void setTraversalFile(File file) {
        if (file.exists() && file.isDirectory()) {
            Slog.i(" directory >>> " + file.getAbsolutePath());
            File[] fileArray = file.listFiles();
            if (fileArray != null) {
                for (File childFile : fileArray) {
                    if (!childFile.isDirectory()) {
                        Slog.i(" file >>>" + childFile.getAbsolutePath());
                    } else {
                        setTraversalFile(childFile);
                    }
                }
            }
        }
    }

}
