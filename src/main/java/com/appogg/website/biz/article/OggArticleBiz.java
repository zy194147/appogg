package com.appogg.website.biz.article;

import com.appogg.website.biz.BaseBiz;
import com.appogg.website.entity.OggArticle;
import com.appogg.website.mapper.OggArticleMapper;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.util.EntityUtils;
import com.appogg.website.util.Query;
import com.appogg.website.vo.article.ArticleVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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


    public ObjectRestResponse uploadArticleTitleImage(HttpServletRequest request, MultipartFile multipartFile){
        String fileName = multipartFile.getOriginalFilename();
        String fileType = StringUtils.substringAfter(fileName, ".");

        String imageSrc = null;


        if (!multipartFile.isEmpty()) {
            try {
                // 文件保存路径
                String filePath = "F:\\appogg\\uploadTitleImage\\" + "upload\\"
                        + multipartFile.getOriginalFilename();
                // 转存文件
                System.out.println("...path:" + filePath);
                multipartFile.transferTo(new File(filePath));
                File file = new File(filePath);
                InputStream in = new FileInputStream(file);
                byte[] bytes=new byte[(int)file.length()];
                in.read(bytes);
                String base64String =  Base64.getEncoder().encodeToString(bytes);

                System.out.println("data:image/jpeg;base64," + base64String);

                imageSrc = "data:image/jpeg;base64," + base64String;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("name:" + fileName + "type:" + fileType);
        return new ObjectRestResponse().data(imageSrc);
    }
}
