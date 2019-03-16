package com.appogg.website.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ogg_follow")
public class OggFollow {
    @Id
    private Integer id;

    /**
     * 关注我的用户id
     */
    @Column(name = "follow_user_id")
    private Integer followUserId;

    @Column(name = "follow_user_name")
    private String followUserName;

    /**
     * 我关注的用户id
     */
    @Column(name = "follow_to_user_id")
    private Integer followToUserId;

    @Column(name = "follow_to_user_name")
    private String followToUserName;

    @Column(name = "create_date_time")
    private Date createDateTime;

    @Column(name = "modify_date_time")
    private Date modifyDateTime;

    @Column(name = "is_enable")
    private Byte isEnable;

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
     * 获取关注我的用户id
     *
     * @return follow_user_id - 关注我的用户id
     */
    public Integer getFollowUserId() {
        return followUserId;
    }

    /**
     * 设置关注我的用户id
     *
     * @param followUserId 关注我的用户id
     */
    public void setFollowUserId(Integer followUserId) {
        this.followUserId = followUserId;
    }

    /**
     * @return follow_user_name
     */
    public String getFollowUserName() {
        return followUserName;
    }

    /**
     * @param followUserName
     */
    public void setFollowUserName(String followUserName) {
        this.followUserName = followUserName;
    }

    /**
     * 获取我关注的用户id
     *
     * @return follow_to_user_id - 我关注的用户id
     */
    public Integer getFollowToUserId() {
        return followToUserId;
    }

    /**
     * 设置我关注的用户id
     *
     * @param followToUserId 我关注的用户id
     */
    public void setFollowToUserId(Integer followToUserId) {
        this.followToUserId = followToUserId;
    }

    /**
     * @return follow_to_user_name
     */
    public String getFollowToUserName() {
        return followToUserName;
    }

    /**
     * @param followToUserName
     */
    public void setFollowToUserName(String followToUserName) {
        this.followToUserName = followToUserName;
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
}