package com.appogg.website.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ogg_soft")
public class OggSoft {
    @Id
    private Integer id;

    @Column(name = "soft_title_name")
    private String softTitleName;

    @Column(name = "soft_title_icon")
    private String softTitleIcon;

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

    @Column(name = "soft_auth_id")
    private Integer softAuthId;

    @Column(name = "soft_classify_group")
    private String softClassifyGroup;

    @Column(name = "is_delete")
    private Byte isDelete;

    @Column(name = "read_num")
    private Integer readNum;

    @Column(name = "comment_num")
    private Integer commentNum;

    @Column(name = "is_sticky")
    private Byte isSticky;

    @Column(name = "is_fine")
    private Byte isFine;

    @Column(name = "helpful_num")
    private Integer helpfulNum;

    @Column(name = "unhelpful_num")
    private Integer unhelpfulNum;

    @Column(name = "soft_system_platform")
    private String softSystemPlatform;

    @Column(name = "soft_download_addr")
    private String softDownloadAddr;

    @Column(name = "soft_content")
    private String softContent;

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
     * @return soft_title_name
     */
    public String getSoftTitleName() {
        return softTitleName;
    }

    /**
     * @param softTitleName
     */
    public void setSoftTitleName(String softTitleName) {
        this.softTitleName = softTitleName;
    }

    /**
     * @return soft_title_icon
     */
    public String getSoftTitleIcon() {
        return softTitleIcon;
    }

    /**
     * @param softTitleIcon
     */
    public void setSoftTitleIcon(String softTitleIcon) {
        this.softTitleIcon = softTitleIcon;
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
     * @return soft_auth_id
     */
    public Integer getSoftAuthId() {
        return softAuthId;
    }

    /**
     * @param softAuthId
     */
    public void setSoftAuthId(Integer softAuthId) {
        this.softAuthId = softAuthId;
    }

    /**
     * @return soft_classify_group
     */
    public String getSoftClassifyGroup() {
        return softClassifyGroup;
    }

    /**
     * @param softClassifyGroup
     */
    public void setSoftClassifyGroup(String softClassifyGroup) {
        this.softClassifyGroup = softClassifyGroup;
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
     * @return comment_num
     */
    public Integer getCommentNum() {
        return commentNum;
    }

    /**
     * @param commentNum
     */
    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
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
     * @return soft_system_platform
     */
    public String getSoftSystemPlatform() {
        return softSystemPlatform;
    }

    /**
     * @param softSystemPlatform
     */
    public void setSoftSystemPlatform(String softSystemPlatform) {
        this.softSystemPlatform = softSystemPlatform;
    }

    /**
     * @return soft_download_addr
     */
    public String getSoftDownloadAddr() {
        return softDownloadAddr;
    }

    /**
     * @param softDownloadAddr
     */
    public void setSoftDownloadAddr(String softDownloadAddr) {
        this.softDownloadAddr = softDownloadAddr;
    }

    /**
     * @return soft_content
     */
    public String getSoftContent() {
        return softContent;
    }

    /**
     * @param softContent
     */
    public void setSoftContent(String softContent) {
        this.softContent = softContent;
    }
}