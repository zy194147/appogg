package com.appogg.website.vo.soft;

import java.util.Date;

public class SoftListVO {
    private int id;
    private String softUserIcon;
    private String createUserName;
    private int createUserId;
    private String softUserLevelName;
    private Date createDateTime;
    private int commentNum;
    private String softTitleName;
    private String softTitleIcon;
    private String[] softClassifyGroup;
    private String softContent;
    private String softSystemPlatform;
    private int readNum;
    private String[] softDownloadAddr;

    private String userHeadIcon;

    private String userAuthName;
    private String userAuthIcon;

    public String getUserAuthName() {
        return userAuthName;
    }

    public void setUserAuthName(String userAuthName) {
        this.userAuthName = userAuthName;
    }

    public String getUserAuthIcon() {
        return userAuthIcon;
    }

    public void setUserAuthIcon(String userAuthIcon) {
        this.userAuthIcon = userAuthIcon;
    }

    public String getUserHeadIcon() {
        return userHeadIcon;
    }

    public void setUserHeadIcon(String userHeadIcon) {
        this.userHeadIcon = userHeadIcon;
    }

    public String[] getSoftDownloadAddr() {
        return softDownloadAddr;
    }

    public void setSoftDownloadAddr(String[] softDownloadAddr) {
        this.softDownloadAddr = softDownloadAddr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoftUserIcon() {
        return softUserIcon;
    }

    public void setSoftUserIcon(String softUserIcon) {
        this.softUserIcon = softUserIcon;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public int getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(int createUserId) {
        this.createUserId = createUserId;
    }

    public String getSoftUserLevelName() {
        return softUserLevelName;
    }

    public void setSoftUserLevelName(String softUserLevelName) {
        this.softUserLevelName = softUserLevelName;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public String getSoftTitleName() {
        return softTitleName;
    }

    public void setSoftTitleName(String softTitleName) {
        this.softTitleName = softTitleName;
    }

    public String getSoftTitleIcon() {
        return softTitleIcon;
    }

    public void setSoftTitleIcon(String softTitleIcon) {
        this.softTitleIcon = softTitleIcon;
    }

    public String[] getSoftClassifyGroup() {
        return softClassifyGroup;
    }

    public void setSoftClassifyGroup(String[] softClassifyGroup) {
        this.softClassifyGroup = softClassifyGroup;
    }

    public String getSoftContent() {
        return softContent;
    }

    public void setSoftContent(String softContent) {
        this.softContent = softContent;
    }

    public String getSoftSystemPlatform() {
        return softSystemPlatform;
    }

    public void setSoftSystemPlatform(String softSystemPlatform) {
        this.softSystemPlatform = softSystemPlatform;
    }

    public int getReadNum() {
        return readNum;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }
}
