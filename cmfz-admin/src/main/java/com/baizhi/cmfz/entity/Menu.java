package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.List;


/**
 * @Descriiption    menu对象的实体类
 * @Author      陈龙祥
 * @Time       2018-07-05 10:54:00
 */
public class Menu implements Serializable {

    private String menuId;
    private String menuName;
    private String menuCode;
    private String menuIcon;
    private String menuUrl;
    private Integer menuLevel;
    private String menuParentId;
    private List<Menu> secondMenu;

    public Menu() {
    }

    public Menu(String menuId, String menuName, String menuCode, String menuIcon, String menuUrl, Integer menuLevel, String menuParentId, List<Menu> secondMenu) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuCode = menuCode;
        this.menuIcon = menuIcon;
        this.menuUrl = menuUrl;
        this.menuLevel = menuLevel;
        this.menuParentId = menuParentId;
        this.secondMenu = secondMenu;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(String menuParentId) {
        this.menuParentId = menuParentId;
    }

    public List<Menu> getSecondMenu() {
        return secondMenu;
    }

    public void setSecondMenu(List<Menu> secondMenu) {
        this.secondMenu = secondMenu;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId='" + menuId + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuCode='" + menuCode + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuLevel=" + menuLevel +
                ", menuParentId='" + menuParentId + '\'' +
                ", secondMenu=" + secondMenu +
                '}';
    }
}
