package com.appogg.website.controller.article;

import com.appogg.website.annotation.UserLoginToken;
import com.appogg.website.biz.article.OggArticleBiz;
import com.appogg.website.entity.OggArticle;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.rest.BaseController;
import com.appogg.website.util.Query;
import com.appogg.website.vo.article.ArticleVo;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping("/article/")
public class OggArticleController extends BaseController<OggArticleBiz,OggArticle> {


    /**
     * 需要登录才能发文章
     * @param articleVo
     * @return
     */
    @UserLoginToken
    @PostMapping("add")
    public ObjectRestResponse insertArticle(@RequestBody ArticleVo articleVo){
        return this.baseBiz.insertArticleMsg(articleVo);
    }

    @GetMapping("list")
    public TableResultResponse listPublicArticle(@RequestParam Map<String,Object> params){
        Query query = new Query(params);
        return this.baseBiz.listPublicArticleMsg(query);
    }
    @GetMapping("detail")
    public ObjectRestResponse selectArticleDetail(@RequestParam Map<String,Object> params){
        Query query = new Query(params);
        return  this.baseBiz.selectArticleDetail(query);
    }
    @GetMapping("updateReadNum")
    public ObjectRestResponse uploadArticleReadNum(@RequestParam Map<String,Object> params){
        Query query = new Query(params);
        return  this.baseBiz.updateArticleReadNum(query);
    }
}
