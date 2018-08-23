package com.xoado.authcenter.bean;

public class TblAppPackage extends TblAppPackageKey {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}