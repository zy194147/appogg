package com.appogg.website.vo.comment;

import com.appogg.website.entity.OggArticleComment;

import java.util.List;

public class CommentShowList {
    private OggArticleComment oggArticleComment;
    private List<OggArticleComment> oggArticleCommentList;

    public OggArticleComment getOggArticleComment() {
        return oggArticleComment;
    }

    public void setOggArticleComment(OggArticleComment oggArticleComment) {
        this.oggArticleComment = oggArticleComment;
    }

    public List<OggArticleComment> getOggArticleCommentList() {
        return oggArticleCommentList;
    }

    public void setOggArticleCommentList(List<OggArticleComment> oggArticleCommentList) {
        this.oggArticleCommentList = oggArticleCommentList;
    }
}
