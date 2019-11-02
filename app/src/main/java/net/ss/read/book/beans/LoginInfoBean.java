package net.ss.read.book.beans;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

/**
 * @author ss
 * created 2019/10/31 13:24
 */
public class LoginInfoBean {

    private UserInfoBean UserInfo;
    private String Message;
    private String Status;

    public UserInfoBean getUserInfo() {
        return UserInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        UserInfo = userInfo;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @NonNull
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
