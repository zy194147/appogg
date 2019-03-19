package com.appogg.website.vo.need;

public class NeedAnswerVO {

    private String answerContent;

    private int answerNeedId;

    private int answerUserId;

    public int getAnswerUserId() {
        return answerUserId;
    }

    public void setAnswerUserId(int answerUserId) {
        this.answerUserId = answerUserId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public int getAnswerNeedId() {
        return answerNeedId;
    }

    public void setAnswerNeedId(int answerNeedId) {
        this.answerNeedId = answerNeedId;
    }
}
