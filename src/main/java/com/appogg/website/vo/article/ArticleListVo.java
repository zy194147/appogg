package com.appogg.website.vo.article;

import javax.persistence.Column;
import java.util.Date;

public class ArticleListVo extends ArticleVo {
    private Date createDateTime;
    private String createUserName;
    private String articleSummary;
    private Byte isFine;
    private Byte isSticky;

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

    public Byte getIsSticky() {
        return isSticky;
    }

    public void setIsSticky(Byte isSticky) {
        this.isSticky = isSticky;
    }

    @Override
    public Byte getIsFine() {
        return isFine;
    }

    @Override
    public void setIsFine(Byte isFine) {
        this.isFine = isFine;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    @Override
    public String getArticleSummary() {
        return articleSummary;
    }

    @Override
    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }
}

