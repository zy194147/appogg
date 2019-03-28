package com.appogg.website.vo.soft;

public class SoftCommentVO {
    private String commentContent;

    private int commentUserId;

    private int commentParentId;

    private int commentSoftId;

    private int backToUserId;

    private String backToUserName;

    public int getCommentParentId() {
        return commentParentId;
    }

    public void setCommentParentId(int commentParentId) {
        this.commentParentId = commentParentId;
    }

    public int getBackToUserId() {
        return backToUserId;
    }

    public void setBackToUserId(int backToUserId) {
        this.backToUserId = backToUserId;
    }

    public String getBackToUserName() {
        return backToUserName;
    }

    public void setBackToUserName(String backToUserName) {
        this.backToUserName = backToUserName;
    }

    public int getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(int commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getCommentSoftId() {
        return commentSoftId;
    }

    public void setCommentSoftId(int commentSoftId) {
        this.commentSoftId = commentSoftId;
    }
}
