package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Log {

    private String logId;
    private String managerName;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date logTime;
    private String logResource;
    private String logAction;
    private String logMessage;
    private String logResult;

    public Log() {
    }

    public Log(String logId, String managerName, Date logTime, String logResource, String logAction, String logMessage, String logResult) {
        this.logId = logId;
        this.managerName = managerName;
        this.logTime = logTime;
        this.logResource = logResource;
        this.logAction = logAction;
        this.logMessage = logMessage;
        this.logResult = logResult;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getLogResource() {
        return logResource;
    }

    public void setLogResource(String logResource) {
        this.logResource = logResource;
    }

    public String getLogAction() {
        return logAction;
    }

    public void setLogAction(String logAction) {
        this.logAction = logAction;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public String getLogResult() {
        return logResult;
    }

    public void setLogResult(String logResult) {
        this.logResult = logResult;
    }


    @Override
    public String toString() {
        return "Log{" +
                "logId='" + logId + '\'' +
                ", managerName='" + managerName + '\'' +
                ", logTime=" + logTime +
                ", logResource='" + logResource + '\'' +
                ", logAction='" + logAction + '\'' +
                ", logMessage='" + logMessage + '\'' +
                ", logResult='" + logResult + '\'' +
                '}';
    }
}
