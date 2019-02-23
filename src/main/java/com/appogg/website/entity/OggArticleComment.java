package com.appogg.website.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ogg_article_comment")
public class OggArticleComment {
    @Id
    private Integer id;

    @Column(name = "create_date_time")
    private Date createDateTime;

    @Column(name = "modify_date_time")
    private Date modifyDateTime;

    @Column(name = "create_user_id")
    private Integer createUserId;

    @Column(name = "create_user_name")
    private String createUserName;

    @Column(name = "modify_user_id")
    private Integer modifyUserId;

    @Column(name = "modify_user_name")
    private String modifyUserName;

    @Column(name = "is_delete")
    private Byte isDelete;

    @Column(name = "is_sticky")
    private Byte isSticky;

    @Column(name = "helpful_num")
    private Integer helpfulNum;

    @Column(name = "unhelpful_num")
    private Integer unhelpfulNum;

    @Column(name = "comment_article_id")
    private Integer commentArticleId;

    @Column(name = "parent_id")
    private Integer parentId;

    private String path;

    /**
     * 回复作者id
     */
    @Column(name = "back_to_user_id")
    private Integer backToUserId;

    /**
     * 回复作者名称
     */
    @Column(name = "back_to_user_name")
    private String backToUserName;

    @Column(name = "comment_content")
    private String commentContent;

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
     * @return create_user_id
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * @param createUserId
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * @return create_user_name
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * @param createUserName
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    /**
     * @return modify_user_id
     */
    public Integer getModifyUserId() {
        return modifyUserId;
    }

    /**
     * @param modifyUserId
     */
    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    /**
     * @return modify_user_name
     */
    public String getModifyUserName() {
        return modifyUserName;
    }

    /**
     * @param modifyUserName
     */
    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
    }

    /**
     * @return is_delete
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * @param isDelete
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * @return is_sticky
     */
    public Byte getIsSticky() {
        return isSticky;
    }

    /**
     * @param isSticky
     */
    public void setIsSticky(Byte isSticky) {
        this.isSticky = isSticky;
    }

    /**
     * @return helpful_num
     */
    public Integer getHelpfulNum() {
        return helpfulNum;
    }

    /**
     * @param helpfulNum
     */
    public void setHelpfulNum(Integer helpfulNum) {
        this.helpfulNum = helpfulNum;
    }

    /**
     * @return unhelpful_num
     */
    public Integer getUnhelpfulNum() {
        return unhelpfulNum;
    }

    /**
     * @param unhelpfulNum
     */
    public void setUnhelpfulNum(Integer unhelpfulNum) {
        this.unhelpfulNum = unhelpfulNum;
    }

    /**
     * @return comment_article_id
     */
    public Integer getCommentArticleId() {
        return commentArticleId;
    }

    /**
     * @param commentArticleId
     */
    public void setCommentArticleId(Integer commentArticleId) {
        this.commentArticleId = commentArticleId;
    }

    /**
     * @return parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取回复作者id
     *
     * @return back_to_user_id - 回复作者id
     */
    public Integer getBackToUserId() {
        return backToUserId;
    }

    /**
     * 设置回复作者id
     *
     * @param backToUserId 回复作者id
     */
    public void setBackToUserId(Integer backToUserId) {
        this.backToUserId = backToUserId;
    }

    /**
     * 获取回复作者名称
     *
     * @return back_to_user_name - 回复作者名称
     */
    public String getBackToUserName() {
        return backToUserName;
    }

    /**
     * 设置回复作者名称
     *
     * @param backToUserName 回复作者名称
     */
    public void setBackToUserName(String backToUserName) {
        this.backToUserName = backToUserName;
    }

    /**
     * @return comment_content
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * @param commentContent
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}