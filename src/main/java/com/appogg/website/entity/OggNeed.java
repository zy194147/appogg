package com.appogg.website.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ogg_need")
public class OggNeed {
    @Id
    private Integer id;

    @Column(name = "create_date_time")
    private Date createDateTime;

    @Column(name = "modify_date_time")
    private Date modifyDateTime;

    @Column(name = "need_title_name")
    private String needTitleName;

    @Column(name = "create_user_id")
    private Integer createUserId;

    @Column(name = "create_user_name")
    private String createUserName;

    @Column(name = "modify_user_id")
    private Integer modifyUserId;

    @Column(name = "modify_user_name")
    private String modifyUserName;

    @Column(name = "answer_num")
    private Integer answerNum;

    @Column(name = "is_solved")
    private Byte isSolved;

    @Column(name = "read_num")
    private Integer readNum;

    @Column(name = "is_delete")
    private Byte isDelete;

    @Column(name = "is_fine")
    private Byte isFine;

    @Column(name = "is_sticky")
    private Byte isSticky;

    @Column(name = "helpful_num")
    private Integer helpfulNum;

    @Column(name = "unhelpful_num")
    private Integer unhelpfulNum;

    @Column(name = "need_content")
    private String needContent;

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
     * @return need_title_name
     */
    public String getNeedTitleName() {
        return needTitleName;
    }

    /**
     * @param needTitleName
     */
    public void setNeedTitleName(String needTitleName) {
        this.needTitleName = needTitleName;
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
     * @return answer_num
     */
    public Integer getAnswerNum() {
        return answerNum;
    }

    /**
     * @param answerNum
     */
    public void setAnswerNum(Integer answerNum) {
        this.answerNum = answerNum;
    }

    /**
     * @return is_solved
     */
    public Byte getIsSolved() {
        return isSolved;
    }

    /**
     * @param isSolved
     */
    public void setIsSolved(Byte isSolved) {
        this.isSolved = isSolved;
    }

    /**
     * @return read_num
     */
    public Integer getReadNum() {
        return readNum;
    }

    /**
     * @param readNum
     */
    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
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
     * @return is_fine
     */
    public Byte getIsFine() {
        return isFine;
    }

    /**
     * @param isFine
     */
    public void setIsFine(Byte isFine) {
        this.isFine = isFine;
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
     * @return need_content
     */
    public String getNeedContent() {
        return needContent;
    }

    /**
     * @param needContent
     */
    public void setNeedContent(String needContent) {
        this.needContent = needContent;
    }
}