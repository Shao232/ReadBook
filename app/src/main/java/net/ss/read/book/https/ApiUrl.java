package net.ss.read.book.https;

import net.ss.lib.common.https.AbstractResponseBean;
import net.ss.lib.common.https.RequestApi;
import net.ss.read.book.beans.LoginInfoBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * @author ss
 * created 2019/11/2 14:10
 */
public interface ApiUrl {

    /**
     * 登录
     * @param  params  username,usecookie,action
     * @return loginInfo
     */
    @GET(RequestApi.LOGIN)
    Observable<AbstractResponseBean<LoginInfoBean>> loginApi(@QueryMap Map<String, String> params);

}
