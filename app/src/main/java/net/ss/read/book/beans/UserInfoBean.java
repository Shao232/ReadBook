package net.ss.read.book.beans;

import net.ss.lib.common.https.AbstractResponseBean;

/**
 * @author ss
 * created 2019/10/31 11:55
 */
public class UserInfoBean extends AbstractResponseBean {

    private String UserName;
    private String Email;
    private int VipLevel;
    private boolean IsNoAd;
    private boolean IsFirstLogin;
    private String ExtInfo;
    private int Balance;
    private int Coin;
    private int Integral;

    public void setUserName(String userName) {
        UserName = userName;
    }
    public String getUserName() {
        return UserName;
    }

    public void setEmail(String email) {
        Email = email;
    }
    public String getEmail() {
        return Email;
    }

    public void setVipLevel(int vipLevel) {
        VipLevel = vipLevel;
    }
    public int getVipLevel() {
        return VipLevel;
    }

    public void setIsNoAd(boolean isNoAd) {
        IsNoAd = isNoAd;
    }
    public boolean getIsNoAd() {
        return IsNoAd;
    }

    public void setIsFirstLogin(boolean isFirstLogin) {
        IsFirstLogin = isFirstLogin;
    }
    public boolean getIsFirstLogin() {
        return IsFirstLogin;
    }

    public void setExtInfo(String extInfo) {
        ExtInfo = extInfo;
    }
    public String getExtInfo() {
        return ExtInfo;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }
    public int getBalance() {
        return Balance;
    }

    public void setCoin(int coin) {
        Coin = coin;
    }
    public int getCoin() {
        return Coin;
    }

    public void setIntegral(int integral) {
        Integral = integral;
    }
    public int getIntegral() {
        return Integral;
    }

}
