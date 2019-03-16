package com.appogg.website.biz.article;

import com.appogg.website.auth.UserCheck;
import com.appogg.website.biz.BaseBiz;
import com.appogg.website.entity.OggArticle;
import com.appogg.website.entity.OggUser;
import com.appogg.website.mapper.OggArticleMapper;
import com.appogg.website.mapper.OggUserMapper;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.util.EntityUtils;
import com.appogg.website.util.Query;
import com.appogg.website.util.RedisUtils;
import com.appogg.website.util.SerializeUtils;
import com.appogg.website.vo.article.ArticleListVo;
import com.appogg.website.vo.article.ArticleVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

@Service
public class OggArticleBiz extends BaseBiz<OggArticleMapper, OggArticle> {

    @Autowired
    private OggUserMapper userMapper;

    @Autowired
    private UserCheck userCheck;

    public ObjectRestResponse insertArticleMsg(ArticleVo articleVo,HttpServletRequest request) {

        OggUser loginUser = userCheck.getLoginUser(request);
        System.out.println("asdkfasdk:" + loginUser);

        if(loginUser == null){
            return new ObjectRestResponse().rel(true).data("添加失败，未登录");
        }

        OggArticle article = new OggArticle();
        article.setCreateDateTime(new Date());
        article.setModifyDateTime(new Date());

        article.setCreateUserId(loginUser.getId());
        article.setCreateUserName(loginUser.getUserName());
        article.setIsDelete(new Byte((byte) 0));
        article.setReadNum(0);
        article.setCommentNum(0);
        article.setIsSticky(new Byte((byte) 0));
        article.setIsFine(new Byte((byte) 0));
        article.setArticleTitleIcon(articleVo.getArticleTitleIcon());
        article.setArticleTitleName(articleVo.getArticleTitleName());
        article.setArticleAuthId(articleVo.getArticleAuthId());
        article.setArticleClassifyGroup(Arrays.toString(articleVo.getArticleClassifyGroup()));
        article.setArticleSummary(articleVo.getArticleSummary());
        article.setArticleContent(articleVo.getArticleContent());

        OggUser user = userMapper.selectByPrimaryKey(loginUser.getId());
        user.setArticleNum(user.getArticleNum()+1);
        userMapper.updateByPrimaryKeySelective(user);
        this.mapper.insertSelective(article);
        return new ObjectRestResponse().rel(true).data("添加文章成功");
    }

    public TableResultResponse listPublicArticleMsg(Query query) {

        List<OggArticle> articleList;
        Page result = PageHelper.startPage(query.getPage(), query.getLimit());

        Example example = new Example(OggArticle.class);
        example.setOrderByClause("create_date_time desc");
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("isFine".equals(entry.getKey())) {
                        criteria.andEqualTo("isFine", 1);
                    }
                }
            }
            articleList = this.mapper.selectByExample(example);
        } else {
            articleList = this.mapper.selectAll();
        }


        List<ArticleListVo> articleListVoList = new ArrayList<>();
        articleListVoList = getArticleListVo(articleList);

        return new TableResultResponse<>(result.getTotal(), articleListVoList);
    }


    private List<ArticleListVo> getArticleListVo(List<OggArticle> articleList) {
        List<ArticleListVo> articleListVoList = new ArrayList<>();
        for (OggArticle article : articleList) {
            ArticleListVo articleListVo = new ArticleListVo();

            articleListVo.setArticleSummary(article.getArticleSummary());
            articleListVo.setCreateDateTime(article.getCreateDateTime());
            articleListVo.setCreateUserName(article.getCreateUserName());
            articleListVo.setArticleTitleIcon(article.getArticleTitleIcon());
            articleListVo.setCreateUserId(article.getCreateUserId());
            articleListVo.setArticleTitleName(article.getArticleTitleName());
            articleListVo.setId(article.getId());
            articleListVo.setArticleClassifyGroup(article.getArticleClassifyGroup().substring(1, article.getArticleClassifyGroup().length() - 1).split(","));
            articleListVo.setIsFine(article.getIsFine());
            articleListVo.setIsSticky(article.getIsSticky());

            OggUser user = userMapper.selectByPrimaryKey(article.getCreateUserId());
            articleListVo.setUserHeadIcon(user.getUserHeadIcon());
            articleListVoList.add(articleListVo);
        }
        return articleListVoList;
    }


    public TableResultResponse listTrendingArticleMsg(Query query) {

        List<OggArticle> articleList;
        List<ArticleVo> articleListVOList = new ArrayList<>();
        Page result = PageHelper.startPage(query.getPage(), query.getLimit());
        Example example = new Example(OggArticle.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("createUserId".equals(entry.getKey())) {
                        criteria.andEqualTo("createUserId", Integer.parseInt(entry.getValue().toString()));
                    }
                }
            }
            articleList = this.mapper.selectByExample(example);
        } else {
            articleList = this.mapper.selectAll();
        }
        example.setOrderByClause("comment_num desc");
        for (OggArticle article : articleList) {
            ArticleVo articleVo = new ArticleVo();
            articleVo.setId(article.getId());
            articleVo.setCreateUserId(article.getCreateUserId());
            articleVo.setArticleTitleName(article.getArticleTitleName());
            articleVo.setCommentNum(article.getCommentNum());
            articleListVOList.add(articleVo);
        }
        return new TableResultResponse<>(result.getTotal(), articleListVOList);
    }


    public TableResultResponse listAuthorTrendingArticle(Query query) {

        List<OggArticle> articleList;
        List<ArticleVo> articleListVOList = new ArrayList<>();
        Page result = PageHelper.startPage(query.getPage(), query.getLimit());
        Example example = new Example(OggArticle.class);
        example.setOrderByClause("comment_num desc");
        articleList = this.mapper.selectByExample(example);
        for (OggArticle article : articleList) {
            ArticleVo articleVo = new ArticleVo();
            articleVo.setId(article.getId());
            articleVo.setCreateUserId(article.getCreateUserId());
            articleVo.setArticleTitleName(article.getArticleTitleName());
            articleVo.setCommentNum(article.getCommentNum());
            articleListVOList.add(articleVo);
        }
        return new TableResultResponse<>(result.getTotal(), articleListVOList);
    }


    public ObjectRestResponse selectArticleDetail(Query query) {

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
            if (articleId != 0) {
                article = this.mapper.selectByPrimaryKey(articleId);
            }
        }

        ArticleVo articleVo = getArticleVo(article);
        return new ObjectRestResponse().rel(true).data(articleVo);
    }

    private ArticleVo getArticleVo(OggArticle article){

        ArticleVo articleVo = new ArticleVo();
        articleVo.setId(article.getId());
        articleVo.setCreateUserId(article.getCreateUserId());
        articleVo.setCommentNum(article.getCommentNum());
        articleVo.setArticleTitleName(article.getArticleTitleName());
        articleVo.setArticleContent(article.getArticleContent());
        articleVo.setArticleClassifyGroup(article.getArticleClassifyGroup().substring(1, article.getArticleClassifyGroup().length() - 1).split(","));
        articleVo.setIsFine(article.getIsFine());
        articleVo.setCreateDateTime(article.getCreateDateTime());
        articleVo.setReadNum(article.getReadNum());
        return articleVo;
    }

    public ObjectRestResponse updateArticleReadNum(Query query) {

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
            if (articleId != 0) {
                article = this.mapper.selectByPrimaryKey(articleId);
                article.setReadNum(article.getReadNum() + 1);

                // 更新总阅读量
                OggUser user = userMapper.selectByPrimaryKey(article.getCreateUserId());
                user.setArticleReadNum(user.getArticleReadNum()+1);
                userMapper.updateByPrimaryKeySelective(user);

                this.mapper.updateByPrimaryKey(article);
            }
        }
        return new ObjectRestResponse().rel(true).data("ok");
    }


    public ObjectRestResponse uploadArticleTitleImage(HttpServletRequest request, MultipartFile multipartFile) {
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
                byte[] bytes = new byte[(int) file.length()];
                in.read(bytes);
                String base64String = Base64.getEncoder().encodeToString(bytes);

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
