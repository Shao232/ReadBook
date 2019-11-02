package net.ss.lib.common.https;

import net.ss.lib.common.Slog;

import java.io.IOException;
import java.util.Locale;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author ss
 * created 2019/11/2 14:25
 */
public class BaseInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Slog.i(" interceptor >>>> " + request.toString());
        long t1 = System.nanoTime();
        okhttp3.Response response = chain.proceed(chain.request());
        long t2 = System.nanoTime();
        Slog.e(String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6d, response.headers()));
        if(response.body() !=null ) {
            okhttp3.MediaType mediaType = response.body().contentType();
            String content = response.body().string();
            Slog.e("response body:" + content);
            return response.newBuilder()
                    .body(okhttp3.ResponseBody.create(mediaType, content))
//                .header("Authorization", Your.sToken)
                    .build();

        }
        return null;
    }
}
