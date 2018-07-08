package com.baizhi.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * @Descriiption   Guru对象的实体类
 * @Author      陈龙祥
 * @Time       2018-07-06 15:09:00
 */
public class Guru implements Serializable {
    @Excel(name="上师ID",height = 20,width = 25,isImportField = "true_st")
    private String guruId;
    @Excel(name="上师法名",height = 20,width = 25,isImportField = "true_st")
    private String guruName;
    @Excel(name = "上师图片",height = 20,width = 25,isImportField = "true_st")
    private String guruPhoto;
    @Excel(name = "上师简介",height = 20,width = 25,isImportField = "true_st")
    private String guruSummary;

    public Guru() {
    }

    public Guru(String guruId, String guruName, String guruPhoto, String guruSummary) {
        this.guruId = guruId;
        this.guruName = guruName;
        this.guruPhoto = guruPhoto;
        this.guruSummary = guruSummary;
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    public String getGuruName() {
        return guruName;
    }

    public void setGuruName(String guruName) {
        this.guruName = guruName;
    }

    public String getGuruPhoto() {
        return guruPhoto;
    }

    public void setGuruPhoto(String guruPhoto) {
        this.guruPhoto = guruPhoto;
    }

    public String getGuruSummary() {
        return guruSummary;
    }

    public void setGuruSummary(String guruSummary) {
        this.guruSummary = guruSummary;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "guruId='" + guruId + '\'' +
                ", guruName='" + guruName + '\'' +
                ", guruPhoto='" + guruPhoto + '\'' +
                ", guruSummary='" + guruSummary + '\'' +
                '}';
    }
}
