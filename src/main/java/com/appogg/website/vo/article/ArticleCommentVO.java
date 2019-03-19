package com.appogg.website.vo.article;

public class ArticleCommentVO {

    private String commentContent;

    private int commentArticleId;

    private int commentUserId;

    public int getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(int commentUserId) {
        this.commentUserId = commentUserId;
    }

    public int getCommentArticleId() {
        return commentArticleId;
    }

    public void setCommentArticleId(int commentArticleId) {
        this.commentArticleId = commentArticleId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
