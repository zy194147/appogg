package com.appogg.website.controller.article;


import com.appogg.website.biz.article.OggArticleCommentBiz;
import com.appogg.website.entity.OggArticleComment;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.rest.BaseController;
import com.appogg.website.util.Query;
import com.appogg.website.vo.article.ArticleCommentVO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article/comment/")
public class OggArticleCommentController extends BaseController<OggArticleCommentBiz,OggArticleComment> {

    @RequestMapping("detail")
    public TableResultResponse selectCommentByArticleId(@RequestParam Map<String,Object> params){
        Query query = new Query(params);
        return this.baseBiz.selectCommentByQuery(query);
    }
    @PostMapping("add")
    public ObjectRestResponse addCommentByArticleId(@RequestBody ArticleCommentVO commentVO){
        System.out.println("dslj...................");
        return this.baseBiz.insertArticleComment(commentVO);
    }

}
