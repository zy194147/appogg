package com.appogg.website.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ogg_notice")
public class OggNotice {
    @Id
    private Integer id;

    @Column(name = "create_date_time")
    private Date createDateTime;

    @Column(name = "modify_date_time")
    private Date modifyDateTime;

    /**
     * 动作产生者id，0为系统
     */
    @Column(name = "action_from_user_id")
    private Integer actionFromUserId;

    /**
     * 动作产生着名称，system为系统
     */
    @Column(name = "action_from_user_name")
    private String actionFromUserName;

    /**
     * 是否已读
     */
    @Column(name = "read_status")
    private Byte readStatus;

    @Column(name = "is_delete")
    private Byte isDelete;

    @Column(name = "notice_to_user_id")
    private Integer noticeToUserId;

    @Column(name = "notice_to_user_name")
    private String noticeToUserName;

    /**
     * comment:评论相关,leaveMsg:留言相关,system:系统通知相关
     */
    @Column(name = "notice_type")
    private String noticeType;

    /**
     * 接收主题，若为评论相关通知，则为文章id
     */
    @Column(name = "action_accepter")
    private Integer actionAccepter;

    /**
     * article:文章通知，soft:软件通知，need需求通知
     */
    @Column(name = "notice_module")
    private String noticeModule;

    @Column(name = "notice_content")
    private String noticeContent;

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
     * 获取动作产生者id，0为系统
     *
     * @return action_from_user_id - 动作产生者id，0为系统
     */
    public Integer getActionFromUserId() {
        return actionFromUserId;
    }

    /**
     * 设置动作产生者id，0为系统
     *
     * @param actionFromUserId 动作产生者id，0为系统
     */
    public void setActionFromUserId(Integer actionFromUserId) {
        this.actionFromUserId = actionFromUserId;
    }

    /**
     * 获取动作产生着名称，system为系统
     *
     * @return action_from_user_name - 动作产生着名称，system为系统
     */
    public String getActionFromUserName() {
        return actionFromUserName;
    }

    /**
     * 设置动作产生着名称，system为系统
     *
     * @param actionFromUserName 动作产生着名称，system为系统
     */
    public void setActionFromUserName(String actionFromUserName) {
        this.actionFromUserName = actionFromUserName;
    }

    /**
     * 获取是否已读
     *
     * @return read_status - 是否已读
     */
    public Byte getReadStatus() {
        return readStatus;
    }

    /**
     * 设置是否已读
     *
     * @param readStatus 是否已读
     */
    public void setReadStatus(Byte readStatus) {
        this.readStatus = readStatus;
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
     * @return notice_to_user_id
     */
    public Integer getNoticeToUserId() {
        return noticeToUserId;
    }

    /**
     * @param noticeToUserId
     */
    public void setNoticeToUserId(Integer noticeToUserId) {
        this.noticeToUserId = noticeToUserId;
    }

    /**
     * @return notice_to_user_name
     */
    public String getNoticeToUserName() {
        return noticeToUserName;
    }

    /**
     * @param noticeToUserName
     */
    public void setNoticeToUserName(String noticeToUserName) {
        this.noticeToUserName = noticeToUserName;
    }

    /**
     * 获取comment:评论相关,leaveMsg:留言相关,system:系统通知相关
     *
     * @return notice_type - comment:评论相关,leaveMsg:留言相关,system:系统通知相关
     */
    public String getNoticeType() {
        return noticeType;
    }

    /**
     * 设置comment:评论相关,leaveMsg:留言相关,system:系统通知相关
     *
     * @param noticeType comment:评论相关,leaveMsg:留言相关,system:系统通知相关
     */
    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    /**
     * 获取接收主题，若为评论相关通知，则为文章id
     *
     * @return action_accepter - 接收主题，若为评论相关通知，则为文章id
     */
    public Integer getActionAccepter() {
        return actionAccepter;
    }

    /**
     * 设置接收主题，若为评论相关通知，则为文章id
     *
     * @param actionAccepter 接收主题，若为评论相关通知，则为文章id
     */
    public void setActionAccepter(Integer actionAccepter) {
        this.actionAccepter = actionAccepter;
    }

    /**
     * 获取article:文章通知，soft:软件通知，need需求通知
     *
     * @return notice_module - article:文章通知，soft:软件通知，need需求通知
     */
    public String getNoticeModule() {
        return noticeModule;
    }

    /**
     * 设置article:文章通知，soft:软件通知，need需求通知
     *
     * @param noticeModule article:文章通知，soft:软件通知，need需求通知
     */
    public void setNoticeModule(String noticeModule) {
        this.noticeModule = noticeModule;
    }

    /**
     * @return notice_content
     */
    public String getNoticeContent() {
        return noticeContent;
    }

    /**
     * @param noticeContent
     */
    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }
}