package com.bssystem.commons.entity;

/**
 * @description: uuid和验证码的entity，用于存放redis。
 * @author: jeff
 * @create: 2019/4/1 0:12
 */
public class CheckAuthCodeEntity {
    private String wechatOpenid;
    private String authCode;

    public CheckAuthCodeEntity(String wechatOpenid, String authCode) {
        this.wechatOpenid = wechatOpenid;
        this.authCode = authCode;
    }

    public CheckAuthCodeEntity() {
    }

    public String getWechatOpenid() {
        return wechatOpenid;
    }

    public void setWechatOpenid(String wechatOpenid) {
        this.wechatOpenid = wechatOpenid;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
}
