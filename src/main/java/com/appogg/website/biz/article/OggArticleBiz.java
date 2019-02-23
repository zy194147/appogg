package com.appogg.website.biz.article;

import com.appogg.website.biz.BaseBiz;
import com.appogg.website.entity.OggArticle;
import com.appogg.website.mapper.OggArticleMapper;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.util.Query;
import com.appogg.website.vo.article.ArticleVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

@Service
public class OggArticleBiz extends BaseBiz<OggArticleMapper,OggArticle> {

    public ObjectRestResponse insertArticleMsg(ArticleVo articleVo){
        OggArticle article = new OggArticle();
        article.setCreateDateTime(new Date());
        article.setModifyDateTime(new Date());
        article.setCreateUserId(1);
        article.setIsDelete(new Byte((byte)0));
        article.setReadNum(0);
        article.setCommentNum(0);
        article.setIsSticky(new Byte((byte)0));
        article.setIsFine(new Byte((byte)0));
        article.setArticleTitleIcon(articleVo.getArticleTitleIcon());
        article.setArticleTitleName(articleVo.getArticleTitleName());
        article.setArticleAuthId(articleVo.getArticleAuthId());
        article.setArticleClassifyGroup(Arrays.toString(articleVo.getArticleClassifyGroup()));
        article.setArticleSummary(articleVo.getArticleSummary());
        article.setArticleContent(articleVo.getArticleContent());
        this.mapper.insertSelective(article);
        return new ObjectRestResponse().rel(true).data("添加文章成功");
    }

    public TableResultResponse listPublicArticleMsg(Query query){

        List<OggArticle> articleList ;
        Page result = PageHelper.startPage(query.getPage(),query.getLimit());

        Example example = new Example(OggArticle.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("isFine".equals(entry.getKey())) {
                        criteria.andEqualTo("isFine",1);
                    }
                }
            }
            articleList = this.mapper.selectByExample(example);
        } else {
            articleList = this.mapper.selectAll();
        }

        return new TableResultResponse<>(result.getTotal(),articleList);
    }

    public ObjectRestResponse selectArticleDetail(Query query){

        int articleId = 0;
        OggArticle article = null;
        Example example = new Example(OggArticle.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("id".equals(entry.getKey())) {
                        articleId = Integer.parseInt(entry.getValue().toString());
                    }
                }
            }
            if(articleId != 0){
                article = this.mapper.selectByPrimaryKey(articleId);
            }
        }
        return new ObjectRestResponse().rel(true).data(article);
    }
    public ObjectRestResponse updateArticleReadNum(Query query){

        int articleId = 0;
        OggArticle article = null;
        Example example = new Example(OggArticle.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("id".equals(entry.getKey())) {
                        articleId = Integer.parseInt(entry.getValue().toString());
                    }
                }
            }
            if(articleId != 0){
                article = this.mapper.selectByPrimaryKey(articleId);
                article.setReadNum(article.getReadNum()+1);
                this.mapper.updateByPrimaryKey(article);
            }
        }
        return new ObjectRestResponse().rel(true).data("ok");
    }
}
