package com.appogg.website.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ogg_menu")
public class OggMenu {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    @Column(name = "create_date_time")
    private Date createDateTime;

    @Column(name = "modify_date_time")
    private Date modifyDateTime;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "parent_id")
    private Integer parentId;

    private String path;

    @Column(name = "create_user_id")
    private Integer createUserId;

    @Column(name = "menu_name_english")
    private String menuNameEnglish;

    @Column(name = "create_user_name")
    private String createUserName;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
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
     * @return menu_name
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * @param menuName
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * @return parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
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
     * @return menu_name_english
     */
    public String getMenuNameEnglish() {
        return menuNameEnglish;
    }

    /**
     * @param menuNameEnglish
     */
    public void setMenuNameEnglish(String menuNameEnglish) {
        this.menuNameEnglish = menuNameEnglish;
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
}