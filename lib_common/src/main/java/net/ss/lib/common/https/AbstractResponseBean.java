package net.ss.lib.common.https;

import com.google.gson.Gson;

/**
 * 返回数据 bean.
 *
 * @author ss
 * created 2019/10/31 11:30
 */
public class AbstractResponseBean<T> {

    public int status;
    public String info;
    public T data;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
