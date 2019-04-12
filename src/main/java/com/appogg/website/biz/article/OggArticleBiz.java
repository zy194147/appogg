package com.appogg.website.biz.article;

import com.appogg.website.auth.UserCheck;
import com.appogg.website.biz.BaseBiz;
import com.appogg.website.entity.OggArticle;
import com.appogg.website.entity.OggAuth;
import com.appogg.website.entity.OggUser;
import com.appogg.website.mapper.OggArticleMapper;
import com.appogg.website.mapper.OggAuthMapper;
import com.appogg.website.mapper.OggUserMapper;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.util.Query;
import com.appogg.website.vo.article.ArticleListVo;
import com.appogg.website.vo.article.ArticleVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

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
    private OggAuthMapper authMapper;

    @Autowired
    private UserCheck userCheck;

    public ObjectRestResponse insertArticleMsg(ArticleVo articleVo,HttpServletRequest request,Byte isEdit) {

        OggUser loginUser = userCheck.getLoginUser(request);
        System.out.println("asdkfasdk:" + loginUser);

        if(loginUser == null){
            return new ObjectRestResponse().rel(true).data("添加失败，未登录");
        }

        OggArticle article = new OggArticle();
        article.setCreateUserId(loginUser.getId());
        article.setCreateUserName(loginUser.getUserName());
        article.setIsEdit(isEdit);
        OggUser user = userMapper.selectByPrimaryKey(loginUser.getId());
        user.setArticleNum(user.getArticleNum()+1);
        userMapper.updateByPrimaryKeySelective(user);

        if(articleVo.getId() == 0){
            article.setCreateDateTime(new Date());
            article.setModifyDateTime(new Date());
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

            this.mapper.insertSelective(article);
        } else {
            article.setId(articleVo.getId());

            OggArticle oggArticle = this.mapper.selectByPrimaryKey(articleVo.getId());
            oggArticle.setModifyDateTime(new Date());
            oggArticle.setArticleTitleIcon(articleVo.getArticleTitleIcon());
            oggArticle.setArticleTitleName(articleVo.getArticleTitleName());
            oggArticle.setArticleAuthId(articleVo.getArticleAuthId());
            oggArticle.setArticleClassifyGroup(Arrays.toString(articleVo.getArticleClassifyGroup()));
            oggArticle.setArticleSummary(articleVo.getArticleSummary());
            oggArticle.setArticleContent(articleVo.getArticleContent());

            this.mapper.updateByPrimaryKey(oggArticle);
        }
        return new ObjectRestResponse().rel(true).data("添加文章成功");
    }

    public TableResultResponse listPublicArticleMsg(Query query) {

        List<OggArticle> articleList;
        Page result = PageHelper.startPage(query.getPage(), query.getLimit());

        Example example = new Example(OggArticle.class);
        example.setOrderByClause("create_date_time desc");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("articleAuthId",0);
        // 查询已发布的
        criteria.andEqualTo("isEdit",0);
        if (query.entrySet().size() > 0) {
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("isFine".equals(entry.getKey())) {
                        criteria.andEqualTo("isFine", 1);
                    }
                }
            }
        }
        articleList = this.mapper.selectByExample(example);
        List<ArticleListVo> articleListVoList = new ArrayList<>();
        articleListVoList = getArticleListVo(articleList);

        return new TableResultResponse<>(result.getTotal(), articleListVoList);
    }

    public TableResultResponse listAllArticle(Query query) {

        List<OggArticle> articleList;
        Page result = PageHelper.startPage(query.getPage(), query.getLimit());
        Example example = new Example(OggArticle.class);
        example.setOrderByClause("create_date_time desc");
        Example.Criteria criteria = example.createCriteria();
        articleList = this.mapper.selectByExample(example);
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
            articleListVo.setCommentNum(article.getCommentNum());

            OggUser user = userMapper.selectByPrimaryKey(article.getCreateUserId());
            articleListVo.setUserHeadIcon(user.getUserHeadIcon());

            OggAuth auth = authMapper.selectByPrimaryKey(user.getMemberLevelId());
            articleListVo.setUserAuthName(auth.getAuthName());
            articleListVo.setUserAuthIcon(auth.getAuthIcon());
            articleListVoList.add(articleListVo);
        }
        return articleListVoList;
    }


    public TableResultResponse listTrendingArticleMsg(Query query) {

        List<OggArticle> articleList;
        List<ArticleVo> articleListVOList = new ArrayList<>();
        Page result = PageHelper.startPage(query.getPage(), query.getLimit());
        Example example = new Example(OggArticle.class);
        example.setOrderByClause("comment_num desc");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("articleAuthId",0);
        criteria.andEqualTo("isEdit",0);
        if (query.entrySet().size() > 0) {
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("createUserId".equals(entry.getKey())) {
                        criteria.andEqualTo("createUserId", Integer.parseInt(entry.getValue().toString()));
                    }
                }
            }
        }
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


    public TableResultResponse listAuthorTrendingArticle(Query query) {

        List<OggArticle> articleList = new ArrayList<>();
        List<ArticleVo> articleListVOList = new ArrayList<>();
        Page result = PageHelper.startPage(query.getPage(), query.getLimit());
        Example example = new Example(OggArticle.class);
        example.setOrderByClause("comment_num desc");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isEdit",0);


        if (query.entrySet().size() > 0) {
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("createUserId".equals(entry.getKey())) {
                        criteria.andEqualTo("createUserId", Integer.parseInt(entry.getValue().toString()));
                    }
                }
            }
        }
        articleList = this.mapper.selectByExample(example);

//        articleList = this.mapper.selectByExample(example);
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
        articleVo.setArticleSummary(article.getArticleSummary());
        articleVo.setArticleAuthId(article.getArticleAuthId());
        articleVo.setArticleTitleIcon(article.getArticleTitleIcon());
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
