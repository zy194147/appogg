package com.appogg.website.vo.need;

import java.util.Date;

public class NeedListVo extends NeedVo {

    private int createUserId;
    private String createUserName;
    private Date createDateTime;
    private Byte isSolved;
    private int readNum;

    private String userHeadIcon;

    private String userAuthName;
    private String userAuthIcon;

    public String getUserAuthName() {
        return userAuthName;
    }

    public void setUserAuthName(String userAuthName) {
        this.userAuthName = userAuthName;
    }

    public String getUserAuthIcon() {
        return userAuthIcon;
    }

    public void setUserAuthIcon(String userAuthIcon) {
        this.userAuthIcon = userAuthIcon;
    }

    public String getUserHeadIcon() {
        return userHeadIcon;
    }

    public void setUserHeadIcon(String userHeadIcon) {
        this.userHeadIcon = userHeadIcon;
    }

    public int getReadNum() {
        return readNum;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }

    public int getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(int createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Byte getIsSolved() {
        return isSolved;
    }

    public void setIsSolved(Byte isSolved) {
        this.isSolved = isSolved;
    }
}
