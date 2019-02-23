package com.appogg.website.controller.article;


import com.appogg.website.biz.article.OggArticleCommentBiz;
import com.appogg.website.entity.OggArticleComment;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.rest.BaseController;
import com.appogg.website.util.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/article/comment/")
public class OggArticleCommentController extends BaseController<OggArticleCommentBiz,OggArticleComment> {

    @RequestMapping("detail")
    public TableResultResponse selectCommentByArticleId(@RequestParam Map<String,Object> params){
        Query query = new Query(params);
        System.out.println("commti.");
        return this.baseBiz.selectCommentByQuery(query);
    }

}
