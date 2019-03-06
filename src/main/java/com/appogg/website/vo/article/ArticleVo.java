package com.appogg.website.vo.article;

public class ArticleVo {
    private int id;
    private int createUserId;

    private String articleTitleIcon;
    private String articleTitleName;
    private Integer articleAuthId;
    private String[] articleClassifyGroup;
    private String articleSummary;
    private String articleContent;

    private int commentNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(int createUserId) {
        this.createUserId = createUserId;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public String getArticleTitleIcon() {
        return articleTitleIcon;
    }

    public void setArticleTitleIcon(String articleTitleIcon) {
        this.articleTitleIcon = articleTitleIcon;
    }

    public String getArticleTitleName() {
        return articleTitleName;
    }

    public void setArticleTitleName(String articleTitleName) {
        this.articleTitleName = articleTitleName;
    }

    public Integer getArticleAuthId() {
        return articleAuthId;
    }

    public void setArticleAuthId(Integer articleAuthId) {
        this.articleAuthId = articleAuthId;
    }

    public String[] getArticleClassifyGroup() {
        return articleClassifyGroup;
    }

    public void setArticleClassifyGroup(String[] articleClassifyGroup) {
        this.articleClassifyGroup = articleClassifyGroup;
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }
}
