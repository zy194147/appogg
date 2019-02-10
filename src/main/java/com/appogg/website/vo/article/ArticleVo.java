package com.appogg.website.vo.article;

public class ArticleVo {

    private String articleTitleIcon;
    private String articleTitleName;
    private Integer articleAuthId;
    private String[] articleClassifyGroup;
    private String articleSummary;
    private String articleContent;

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
