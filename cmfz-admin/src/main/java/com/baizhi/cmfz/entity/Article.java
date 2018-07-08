package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {

    private String articleId;
    private String articleName;
    private String guruId;
    private String introduction;
    private Date date;

    public Article() {
    }

    public Article(String articleId, String articleName, String guruId, String introduction, Date date) {
        this.articleId = articleId;
        this.articleName = articleName;
        this.guruId = guruId;
        this.introduction = introduction;
        this.date = date;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleName='" + articleName + '\'' +
                ", guruId='" + guruId + '\'' +
                ", introduction='" + introduction + '\'' +
                ", date=" + date +
                '}';
    }
}
