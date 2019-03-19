package com.appogg.website.vo.soft;

public class SoftCommentVO {
    private String commentContent;

    private int commentUserId;

    private int commentSoftId;

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
