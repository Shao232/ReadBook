package net.ss.lib.common.https;

/**
 * 请求 api
 * @author ss
 * created 2019/10/31 11:45
 */
public interface RequestApi {

    /**
     * 网址
     */
    String BASE_URL = "https://dynic.anchengcn.com/";

    /**
     * 登录
     */
    String LOGIN = BASE_URL+"Login.aspx?";

    /**
     * 书架
     */
    String BOOK_SHELF = BASE_URL +"Bookshelf.aspx";

}
