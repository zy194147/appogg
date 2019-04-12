package com.appogg.website.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ogg_auth_grade")
public class OggAuthGrade {
    @Id
    private Integer id;

    /**
     * 会员等级
     */
    @Column(name = "auth_grade_id")
    private Integer authGradeId;

    /**
     * 权限操作内容，如发文章权限
     */
    @Column(name = "auth_operate_content")
    private String authOperateContent;

    @Column(name = "create_date_time")
    private Date createDateTime;

    @Column(name = "modify_date_time")
    private Date modifyDateTime;

    /**
     * 功能介绍
     */
    @Column(name = "auth_operate_intr")
    private String authOperateIntr;

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
     * 获取会员等级
     *
     * @return auth_grade_id - 会员等级
     */
    public Integer getAuthGradeId() {
        return authGradeId;
    }

    /**
     * 设置会员等级
     *
     * @param authGradeId 会员等级
     */
    public void setAuthGradeId(Integer authGradeId) {
        this.authGradeId = authGradeId;
    }

    /**
     * 获取权限操作内容，如发文章权限
     *
     * @return auth_operate_content - 权限操作内容，如发文章权限
     */
    public String getAuthOperateContent() {
        return authOperateContent;
    }

    /**
     * 设置权限操作内容，如发文章权限
     *
     * @param authOperateContent 权限操作内容，如发文章权限
     */
    public void setAuthOperateContent(String authOperateContent) {
        this.authOperateContent = authOperateContent;
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
     * 获取功能介绍
     *
     * @return auth_operate_intr - 功能介绍
     */
    public String getAuthOperateIntr() {
        return authOperateIntr;
    }

    /**
     * 设置功能介绍
     *
     * @param authOperateIntr 功能介绍
     */
    public void setAuthOperateIntr(String authOperateIntr) {
        this.authOperateIntr = authOperateIntr;
    }
}