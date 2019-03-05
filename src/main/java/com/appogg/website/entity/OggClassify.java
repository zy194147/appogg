package com.appogg.website.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ogg_classify")
public class OggClassify {
    @Id
    private Integer id;

    @Column(name = "create_date_time")
    private Date createDateTime;

    @Column(name = "modirfy_date_time")
    private Date modirfyDateTime;

    @Column(name = "classify_name")
    private String classifyName;

    @Column(name = "classify_type")
    private String classifyType;

    @Column(name = "classify_create_user_id")
    private Integer classifyCreateUserId;

    @Column(name = "classify_create_user_name")
    private String classifyCreateUserName;

    @Column(name = "is_enable")
    private Byte isEnable;

    @Column(name = "is_delete")
    private Byte isDelete;

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
     * @return modirfy_date_time
     */
    public Date getModirfyDateTime() {
        return modirfyDateTime;
    }

    /**
     * @param modirfyDateTime
     */
    public void setModirfyDateTime(Date modirfyDateTime) {
        this.modirfyDateTime = modirfyDateTime;
    }

    /**
     * @return classify_name
     */
    public String getClassifyName() {
        return classifyName;
    }

    /**
     * @param classifyName
     */
    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    /**
     * @return classify_type
     */
    public String getClassifyType() {
        return classifyType;
    }

    /**
     * @param classifyType
     */
    public void setClassifyType(String classifyType) {
        this.classifyType = classifyType;
    }

    /**
     * @return classify_create_user_id
     */
    public Integer getClassifyCreateUserId() {
        return classifyCreateUserId;
    }

    /**
     * @param classifyCreateUserId
     */
    public void setClassifyCreateUserId(Integer classifyCreateUserId) {
        this.classifyCreateUserId = classifyCreateUserId;
    }

    /**
     * @return classify_create_user_name
     */
    public String getClassifyCreateUserName() {
        return classifyCreateUserName;
    }

    /**
     * @param classifyCreateUserName
     */
    public void setClassifyCreateUserName(String classifyCreateUserName) {
        this.classifyCreateUserName = classifyCreateUserName;
    }

    /**
     * @return is_enable
     */
    public Byte getIsEnable() {
        return isEnable;
    }

    /**
     * @param isEnable
     */
    public void setIsEnable(Byte isEnable) {
        this.isEnable = isEnable;
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
}