package com.appogg.website.vo.comment;

import javax.persistence.Column;
import java.util.Date;

public class CommentListVo  {

    private int id;
    private int commentUserId;
    private String commentUserName;
    private Date createDateTime;
    private String commentUserIcon;
    private String commentContent;

    private Byte isAdopt;

    private Integer backToUserId;
    private String backToUserName;

    public Byte getIsAdopt() {
        return isAdopt;
    }

    public void setIsAdopt(Byte isAdopt) {
        this.isAdopt = isAdopt;
    }

    public String getBackToUserName() {
        return backToUserName;
    }

    public void setBackToUserName(String backToUserName) {
        this.backToUserName = backToUserName;
    }

    public Integer getBackToUserId() {
        return backToUserId;
    }

    public void setBackToUserId(Integer backToUserId) {
        this.backToUserId = backToUserId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(int commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getCommentUserIcon() {
        return commentUserIcon;
    }

    public void setCommentUserIcon(String commentUserIcon) {
        this.commentUserIcon = commentUserIcon;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
