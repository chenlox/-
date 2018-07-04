package com.baizhi.cmfz.entity;


import java.io.Serializable;

/**
 * @Descriiption    manager对象的实体类
 * @Author      陈龙祥
 * @Time       2018-07-04 14:54:00
 */
public class Manager implements Serializable {

    private String managerId;
    private String managerName;
    private String managerPassword;
    private String solt;
    private String status;

    public Manager() {
    }

    public Manager(String managerId, String managerName, String managerPassword, String solt, String status) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.managerPassword = managerPassword;
        this.solt = solt;
        this.status = status;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getSolt() {
        return solt;
    }

    public void setSolt(String solt) {
        this.solt = solt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerId='" + managerId + '\'' +
                ", managerName='" + managerName + '\'' +
                ", managerPassword='" + managerPassword + '\'' +
                ", solt='" + solt + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
