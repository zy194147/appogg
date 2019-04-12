package com.appogg.website.vo.user;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class UserVO {
    private Integer id;
    private String userName;
    private Integer memberLevelId;

    private String userEmail;


    private String memberLevelName;

    private String userCity;

    private Byte userSex;

    private String userIntroduce;

    private String userHeadIcon;

    private String userPageIcon;

    private Date createDateTime;

    private Integer articleNum;

    private Integer articleReadNum;

    private String userAuthName;
    private String userAuthIcon;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public Integer getMemberLevelId() {
        return memberLevelId;
    }

    public void setMemberLevelId(Integer memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    public String getMemberLevelName() {
        return memberLevelName;
    }

    public void setMemberLevelName(String memberLevelName) {
        this.memberLevelName = memberLevelName;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public Byte getUserSex() {
        return userSex;
    }

    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    public String getUserIntroduce() {
        return userIntroduce;
    }

    public void setUserIntroduce(String userIntroduce) {
        this.userIntroduce = userIntroduce;
    }

    public String getUserHeadIcon() {
        return userHeadIcon;
    }

    public void setUserHeadIcon(String userHeadIcon) {
        this.userHeadIcon = userHeadIcon;
    }

    public String getUserPageIcon() {
        return userPageIcon;
    }

    public void setUserPageIcon(String userPageIcon) {
        this.userPageIcon = userPageIcon;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Integer getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(Integer articleNum) {
        this.articleNum = articleNum;
    }

    public Integer getArticleReadNum() {
        return articleReadNum;
    }

    public void setArticleReadNum(Integer articleReadNum) {
        this.articleReadNum = articleReadNum;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", memberLevelId='" + memberLevelId + '\'' +
                ", memberLevelName='" + memberLevelName + '\'' +
                ", userCity='" + userCity + '\'' +
                ", userSex=" + userSex +
                ", userIntroduce='" + userIntroduce + '\'' +
                ", userHeadIcon='" + userHeadIcon + '\'' +
                ", userPageIcon='" + userPageIcon + '\'' +
                ", createDateTime=" + createDateTime +
                ", articleNum=" + articleNum +
                ", articleReadNum=" + articleReadNum +
                '}';
    }
}
