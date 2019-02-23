package com.appogg.website.vo.comment;

import com.appogg.website.vo.TreeNode;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;


public class CommentTree extends TreeNode {

    private String name;
    private String value;
    private String label;

    private Integer commentId;

    private Date createDateTime;

    private Date modifyDateTime;

    private Integer createUserId;

    private String createUserName;

    private Integer modifyUserId;

    private String modifyUserName;

    private Byte isDelete;

    private Byte isSticky;

    private Integer helpfulNum;

    private Integer unhelpfulNum;

    private Integer commentArticleId;

    private String path;
    private String commentContent;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Date getModifyDateTime() {
        return modifyDateTime;
    }

    public void setModifyDateTime(Date modifyDateTime) {
        this.modifyDateTime = modifyDateTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Byte getIsSticky() {
        return isSticky;
    }

    public void setIsSticky(Byte isSticky) {
        this.isSticky = isSticky;
    }

    public Integer getHelpfulNum() {
        return helpfulNum;
    }

    public void setHelpfulNum(Integer helpfulNum) {
        this.helpfulNum = helpfulNum;
    }

    public Integer getUnhelpfulNum() {
        return unhelpfulNum;
    }

    public void setUnhelpfulNum(Integer unhelpfulNum) {
        this.unhelpfulNum = unhelpfulNum;
    }

    public Integer getCommentArticleId() {
        return commentArticleId;
    }

    public void setCommentArticleId(Integer commentArticleId) {
        this.commentArticleId = commentArticleId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Override
    public String toString() {
        return "CommentTree{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", label='" + label + '\'' +
                ", commentId=" + commentId +
                ", createDateTime=" + createDateTime +
                ", modifyDateTime=" + modifyDateTime +
                ", createUserId=" + createUserId +
                ", createUserName='" + createUserName + '\'' +
                ", modifyUserId=" + modifyUserId +
                ", modifyUserName='" + modifyUserName + '\'' +
                ", isDelete=" + isDelete +
                ", isSticky=" + isSticky +
                ", helpfulNum=" + helpfulNum +
                ", unhelpfulNum=" + unhelpfulNum +
                ", commentArticleId=" + commentArticleId +
                ", path='" + path + '\'' +
                ", commentContent='" + commentContent + '\'' +
                '}';
    }
}
