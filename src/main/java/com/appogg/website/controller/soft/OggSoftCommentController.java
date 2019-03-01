package com.appogg.website.controller.soft;

import com.appogg.website.biz.soft.OggSoftCommentBiz;
import com.appogg.website.entity.OggSoftComment;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.rest.BaseController;
import com.appogg.website.util.Query;
import com.appogg.website.vo.article.ArticleCommentVO;
import com.appogg.website.vo.soft.SoftCommentVO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/soft/comment/")
public class OggSoftCommentController extends BaseController<OggSoftCommentBiz,OggSoftComment> {
    @RequestMapping("detail")
    public TableResultResponse selectCommentBySoftId(@RequestParam Map<String,Object> params){
        Query query = new Query(params);
        return this.baseBiz.selectCommentByQuery(query);
    }
    @PostMapping("add")
    public ObjectRestResponse addCommentBySoftId(@RequestBody SoftCommentVO commentVO){
        return this.baseBiz.insertSoftComment(commentVO);
    }
}
