package com.appogg.website.vo.need;

public class NeedVo {
    private int id;
    private int needUserId;
    private int answerNum;

    private String needTitleName;
    private String[] needClassifyGroup;
    private String needContent;

    public int getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(int answerNum) {
        this.answerNum = answerNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNeedUserId() {
        return needUserId;
    }

    public void setNeedUserId(int needUserId) {
        this.needUserId = needUserId;
    }

    public String getNeedTitleName() {
        return needTitleName;
    }

    public void setNeedTitleName(String needTitleName) {
        this.needTitleName = needTitleName;
    }

    public String[] getNeedClassifyGroup() {
        return needClassifyGroup;
    }

    public void setNeedClassifyGroup(String[] needClassifyGroup) {
        this.needClassifyGroup = needClassifyGroup;
    }

    public String getNeedContent() {
        return needContent;
    }

    public void setNeedContent(String needContent) {
        this.needContent = needContent;
    }
}
