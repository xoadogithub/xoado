package com.xoado.wx.bean;

public class TblComponentverifyticket {
    private String wx3AppId;

    private String componentverifyticket;

    private String preAuthCode;

    private String componentAccessToken;

    public String getWx3AppId() {
        return wx3AppId;
    }

    public void setWx3AppId(String wx3AppId) {
        this.wx3AppId = wx3AppId == null ? null : wx3AppId.trim();
    }

    public String getComponentverifyticket() {
        return componentverifyticket;
    }

    public void setComponentverifyticket(String componentverifyticket) {
        this.componentverifyticket = componentverifyticket == null ? null : componentverifyticket.trim();
    }

    public String getPreAuthCode() {
        return preAuthCode;
    }

    public void setPreAuthCode(String preAuthCode) {
        this.preAuthCode = preAuthCode == null ? null : preAuthCode.trim();
    }

    public String getComponentAccessToken() {
        return componentAccessToken;
    }

    public void setComponentAccessToken(String componentAccessToken) {
        this.componentAccessToken = componentAccessToken == null ? null : componentAccessToken.trim();
    }
}