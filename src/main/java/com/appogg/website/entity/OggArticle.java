package com.appogg.website.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ogg_article")
public class OggArticle {
    @Id
    private Integer id;

    @Column(name = "create_date_time")
    private Date createDateTime;

    @Column(name = "modify_date_time")
    private Date modifyDateTime;

    /**
     * 文章标题图标
     */
    @Column(name = "article_title_icon")
    private String articleTitleIcon;

    /**
     * 文字标题名称
     */
    @Column(name = "article_title_name")
    private String articleTitleName;

    /**
     * 文章权限
     */
    @Column(name = "article_auth_id")
    private Integer articleAuthId;

    /**
     * 文章分类分组
     */
    @Column(name = "article_classify_group")
    private String articleClassifyGroup;

    /**
     * 文章概述
     */
    @Column(name = "article_summary")
    private String articleSummary;

    /**
     * 文章发布者
     */
    @Column(name = "create_user_id")
    private Integer createUserId;

    /**
     * 文章最近一次修改者
     */
    @Column(name = "modiry_user_id")
    private Integer modiryUserId;

    /**
     * 删除状态：”0“未删除，”1“已删除
     */
    @Column(name = "is_delete")
    private Byte isDelete;

    /**
     * 文章阅读量
     */
    @Column(name = "read_num")
    private Integer readNum;

    /**
     * 文章评论量
     */
    @Column(name = "comment_num")
    private Integer commentNum;

    /**
     * 是否置顶
     */
    @Column(name = "is_sticky")
    private Byte isSticky;

    /**
     * 是否为精选文章
     */
    @Column(name = "is_fine")
    private Byte isFine;

    /**
     * 文章有用数量
     */
    @Column(name = "helpful_num")
    private Integer helpfulNum;

    /**
     * 文章无用数量
     */
    @Column(name = "unhelpful_num")
    private Integer unhelpfulNum;

    /**
     * 文章内容
     */
    @Column(name = "article_content")
    private String articleContent;

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
     * @return create_date_time
     */
    public Date getCreateDateTime() {
        return createDateTime;
    }

    /**
     * @param createDateTime
     */
    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    /**
     * @return modify_date_time
     */
    public Date getModifyDateTime() {
        return modifyDateTime;
    }

    /**
     * @param modifyDateTime
     */
    public void setModifyDateTime(Date modifyDateTime) {
        this.modifyDateTime = modifyDateTime;
    }

    /**
     * 获取文章标题图标
     *
     * @return article_title_icon - 文章标题图标
     */
    public String getArticleTitleIcon() {
        return articleTitleIcon;
    }

    /**
     * 设置文章标题图标
     *
     * @param articleTitleIcon 文章标题图标
     */
    public void setArticleTitleIcon(String articleTitleIcon) {
        this.articleTitleIcon = articleTitleIcon;
    }

    /**
     * 获取文字标题名称
     *
     * @return article_title_name - 文字标题名称
     */
    public String getArticleTitleName() {
        return articleTitleName;
    }

    /**
     * 设置文字标题名称
     *
     * @param articleTitleName 文字标题名称
     */
    public void setArticleTitleName(String articleTitleName) {
        this.articleTitleName = articleTitleName;
    }

    /**
     * 获取文章权限
     *
     * @return article_auth_id - 文章权限
     */
    public Integer getArticleAuthId() {
        return articleAuthId;
    }

    /**
     * 设置文章权限
     *
     * @param articleAuthId 文章权限
     */
    public void setArticleAuthId(Integer articleAuthId) {
        this.articleAuthId = articleAuthId;
    }

    /**
     * 获取文章分类分组
     *
     * @return article_classify_group - 文章分类分组
     */
    public String getArticleClassifyGroup() {
        return articleClassifyGroup;
    }

    /**
     * 设置文章分类分组
     *
     * @param articleClassifyGroup 文章分类分组
     */
    public void setArticleClassifyGroup(String articleClassifyGroup) {
        this.articleClassifyGroup = articleClassifyGroup;
    }

    /**
     * 获取文章概述
     *
     * @return article_summary - 文章概述
     */
    public String getArticleSummary() {
        return articleSummary;
    }

    /**
     * 设置文章概述
     *
     * @param articleSummary 文章概述
     */
    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }

    /**
     * 获取文章发布者
     *
     * @return create_user_id - 文章发布者
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * 设置文章发布者
     *
     * @param createUserId 文章发布者
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 获取文章最近一次修改者
     *
     * @return modiry_user_id - 文章最近一次修改者
     */
    public Integer getModiryUserId() {
        return modiryUserId;
    }

    /**
     * 设置文章最近一次修改者
     *
     * @param modiryUserId 文章最近一次修改者
     */
    public void setModiryUserId(Integer modiryUserId) {
        this.modiryUserId = modiryUserId;
    }

    /**
     * 获取删除状态：”0“未删除，”1“已删除
     *
     * @return is_delete - 删除状态：”0“未删除，”1“已删除
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * 设置删除状态：”0“未删除，”1“已删除
     *
     * @param isDelete 删除状态：”0“未删除，”1“已删除
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取文章阅读量
     *
     * @return read_num - 文章阅读量
     */
    public Integer getReadNum() {
        return readNum;
    }

    /**
     * 设置文章阅读量
     *
     * @param readNum 文章阅读量
     */
    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    /**
     * 获取文章评论量
     *
     * @return comment_num - 文章评论量
     */
    public Integer getCommentNum() {
        return commentNum;
    }

    /**
     * 设置文章评论量
     *
     * @param commentNum 文章评论量
     */
    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    /**
     * 获取是否置顶
     *
     * @return is_sticky - 是否置顶
     */
    public Byte getIsSticky() {
        return isSticky;
    }

    /**
     * 设置是否置顶
     *
     * @param isSticky 是否置顶
     */
    public void setIsSticky(Byte isSticky) {
        this.isSticky = isSticky;
    }

    /**
     * 获取是否为精选文章
     *
     * @return is_fine - 是否为精选文章
     */
    public Byte getIsFine() {
        return isFine;
    }

    /**
     * 设置是否为精选文章
     *
     * @param isFine 是否为精选文章
     */
    public void setIsFine(Byte isFine) {
        this.isFine = isFine;
    }

    /**
     * 获取文章有用数量
     *
     * @return helpful_num - 文章有用数量
     */
    public Integer getHelpfulNum() {
        return helpfulNum;
    }

    /**
     * 设置文章有用数量
     *
     * @param helpfulNum 文章有用数量
     */
    public void setHelpfulNum(Integer helpfulNum) {
        this.helpfulNum = helpfulNum;
    }

    /**
     * 获取文章无用数量
     *
     * @return unhelpful_num - 文章无用数量
     */
    public Integer getUnhelpfulNum() {
        return unhelpfulNum;
    }

    /**
     * 设置文章无用数量
     *
     * @param unhelpfulNum 文章无用数量
     */
    public void setUnhelpfulNum(Integer unhelpfulNum) {
        this.unhelpfulNum = unhelpfulNum;
    }

    /**
     * 获取文章内容
     *
     * @return article_content - 文章内容
     */
    public String getArticleContent() {
        return articleContent;
    }

    /**
     * 设置文章内容
     *
     * @param articleContent 文章内容
     */
    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }
}