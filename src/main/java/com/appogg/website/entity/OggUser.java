package com.appogg.website.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "ogg_user")
public class OggUser implements Serializable {
    @Id
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_password")
    private String userPassword;

    /**
     * 会员等级id
     */
    @Column(name = "member_level_id")
    private Integer memberLevelId;

    /**
     * 会员等级名称
     */
    @Column(name = "member_level_name")
    private String memberLevelName;

    /**
     * 所在城市
     */
    @Column(name = "user_city")
    private String userCity;

    /**
     * 用户性别
     */
    @Column(name = "user_sex")
    private Byte userSex;

    /**
     * 用户简介
     */
    @Column(name = "user_introduce")
    private String userIntroduce;

    /**
     * 账号销毁
     */
    @Column(name = "is_destroy")
    private Byte isDestroy;

    /**
     * 注册时间
     */
    @Column(name = "create_date_time")
    private Date createDateTime;

    /**
     * 文章总数
     */
    @Column(name = "article_num")
    private Integer articleNum;

    /**
     * 文章总总阅读量
     */
    @Column(name = "article_read_num")
    private Integer articleReadNum;

    @Column(name = "user_nickname")
    private String userNickname;

    /**
     * 头像
     */
    @Column(name = "user_head_icon")
    private String userHeadIcon;

    /**
     * 用户页面顶部背景图
     */
    @Column(name = "user_page_icon")
    private String userPageIcon;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return user_email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return user_password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * 获取会员等级id
     *
     * @return member_level_id - 会员等级id
     */
    public Integer getMemberLevelId() {
        return memberLevelId;
    }

    /**
     * 设置会员等级id
     *
     * @param memberLevelId 会员等级id
     */
    public void setMemberLevelId(Integer memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    /**
     * 获取会员等级名称
     *
     * @return member_level_name - 会员等级名称
     */
    public String getMemberLevelName() {
        return memberLevelName;
    }

    /**
     * 设置会员等级名称
     *
     * @param memberLevelName 会员等级名称
     */
    public void setMemberLevelName(String memberLevelName) {
        this.memberLevelName = memberLevelName;
    }

    /**
     * 获取所在城市
     *
     * @return user_city - 所在城市
     */
    public String getUserCity() {
        return userCity;
    }

    /**
     * 设置所在城市
     *
     * @param userCity 所在城市
     */
    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    /**
     * 获取用户性别
     *
     * @return user_sex - 用户性别
     */
    public Byte getUserSex() {
        return userSex;
    }

    /**
     * 设置用户性别
     *
     * @param userSex 用户性别
     */
    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    /**
     * 获取用户简介
     *
     * @return user_introduce - 用户简介
     */
    public String getUserIntroduce() {
        return userIntroduce;
    }

    /**
     * 设置用户简介
     *
     * @param userIntroduce 用户简介
     */
    public void setUserIntroduce(String userIntroduce) {
        this.userIntroduce = userIntroduce;
    }

    /**
     * 获取账号销毁
     *
     * @return is_destroy - 账号销毁
     */
    public Byte getIsDestroy() {
        return isDestroy;
    }

    /**
     * 设置账号销毁
     *
     * @param isDestroy 账号销毁
     */
    public void setIsDestroy(Byte isDestroy) {
        this.isDestroy = isDestroy;
    }

    /**
     * 获取注册时间
     *
     * @return create_date_time - 注册时间
     */
    public Date getCreateDateTime() {
        return createDateTime;
    }

    /**
     * 设置注册时间
     *
     * @param createDateTime 注册时间
     */
    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    /**
     * 获取文章总数
     *
     * @return article_num - 文章总数
     */
    public Integer getArticleNum() {
        return articleNum;
    }

    /**
     * 设置文章总数
     *
     * @param articleNum 文章总数
     */
    public void setArticleNum(Integer articleNum) {
        this.articleNum = articleNum;
    }

    /**
     * 获取文章总总阅读量
     *
     * @return article_read_num - 文章总总阅读量
     */
    public Integer getArticleReadNum() {
        return articleReadNum;
    }

    /**
     * 设置文章总总阅读量
     *
     * @param articleReadNum 文章总总阅读量
     */
    public void setArticleReadNum(Integer articleReadNum) {
        this.articleReadNum = articleReadNum;
    }

    /**
     * @return user_nickname
     */
    public String getUserNickname() {
        return userNickname;
    }

    /**
     * @param userNickname
     */
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    /**
     * 获取头像
     *
     * @return user_head_icon - 头像
     */
    public String getUserHeadIcon() {
        return userHeadIcon;
    }

    /**
     * 设置头像
     *
     * @param userHeadIcon 头像
     */
    public void setUserHeadIcon(String userHeadIcon) {
        this.userHeadIcon = userHeadIcon;
    }

    /**
     * 获取用户页面顶部背景图
     *
     * @return user_page_icon - 用户页面顶部背景图
     */
    public String getUserPageIcon() {
        return userPageIcon;
    }

    /**
     * 设置用户页面顶部背景图
     *
     * @param userPageIcon 用户页面顶部背景图
     */
    public void setUserPageIcon(String userPageIcon) {
        this.userPageIcon = userPageIcon;
    }
}