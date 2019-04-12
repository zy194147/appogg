package com.appogg.website.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ogg_auth")
public class OggAuth {
    @Id
    private Integer id;

    @Column(name = "auth_id")
    private Integer authId;

    @Column(name = "auth_name")
    private String authName;

    @Column(name = "auth_icon")
    private String authIcon;

    @Column(name = "create_date_time")
    private Date createDateTime;

    @Column(name = "modify_date_time")
    private Date modifyDateTime;

    /**
     * 价格：年
     */
    @Column(name = "auth_price")
    private Integer authPrice;

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
     * @return auth_id
     */
    public Integer getAuthId() {
        return authId;
    }

    /**
     * @param authId
     */
    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    /**
     * @return auth_name
     */
    public String getAuthName() {
        return authName;
    }

    /**
     * @param authName
     */
    public void setAuthName(String authName) {
        this.authName = authName;
    }

    /**
     * @return auth_icon
     */
    public String getAuthIcon() {
        return authIcon;
    }

    /**
     * @param authIcon
     */
    public void setAuthIcon(String authIcon) {
        this.authIcon = authIcon;
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
     * 获取价格：年
     *
     * @return auth_price - 价格：年
     */
    public Integer getAuthPrice() {
        return authPrice;
    }

    /**
     * 设置价格：年
     *
     * @param authPrice 价格：年
     */
    public void setAuthPrice(Integer authPrice) {
        this.authPrice = authPrice;
    }
}