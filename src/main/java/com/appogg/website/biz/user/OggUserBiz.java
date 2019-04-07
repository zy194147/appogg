package com.appogg.website.biz.user;

import com.alibaba.fastjson.JSONObject;
import com.appogg.website.biz.BaseBiz;
import com.appogg.website.biz.token.TokenBiz;
import com.appogg.website.entity.*;
import com.appogg.website.mapper.*;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.util.Query;
import com.appogg.website.util.RedisUtils;
import com.appogg.website.util.SerializeUtils;
import com.appogg.website.vo.article.ArticleListVo;
import com.appogg.website.vo.need.NeedListVo;
import com.appogg.website.vo.soft.SoftListVO;
import com.appogg.website.vo.user.UserVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OggUserBiz extends BaseBiz<OggUserMapper, OggUser> {

    @Resource
    private RedisUtils redisUtils;

    @Autowired
    private OggArticleMapper articleMapper;

    @Autowired
    private OggSoftMapper softMapper;

    @Autowired
    private OggNoticeMapper noticeMapper;

    @Autowired
    private OggNeedMapper needMapper;

    @Autowired
    private OggAuthMapper authMapper;

    @Autowired
    TokenBiz tokenBiz;

    public ObjectRestResponse userLogin(OggUser user) {

        JSONObject jsonObject = new JSONObject();
        OggUser userForBase = this.mapper.selectByUserName(user.getUserName());
        OggUser userForBaseByEmail = this.mapper.selectByUserEmail(user.getUserName());
        // 使用用户名登录
        if (userForBase != null) {
            if (!userForBase.getUserPassword().equals(user.getUserPassword())) {
                jsonObject.put("message", "登录失败,密码错误");
                jsonObject.put("status", 10011);

                return new ObjectRestResponse().data(jsonObject);
            } else {
                String token = tokenBiz.getToken(userForBase);
                try {
                    String userString = SerializeUtils.serialize(userForBase);
                    System.out.println("序列字符串:" + userString);
                    try {
                        OggUser user1 = (OggUser) SerializeUtils.serializeToObject(userString);
                        System.out.println("序列字duixiang:" + user1);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    redisUtils.set(token, userString);
                } catch (IOException e) {
                    jsonObject.put("message", "登录失败,序列化对象失败");
                    jsonObject.put("status", 10012);

                    return new ObjectRestResponse().data(jsonObject);
                }
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);

                return new ObjectRestResponse().data(jsonObject);
            }
            // 使用邮箱登录
        } else if (userForBaseByEmail != null) {
            if (!userForBaseByEmail.getUserPassword().equals(user.getUserPassword())) {
                jsonObject.put("message", "登录失败,密码错误");
                jsonObject.put("status", 10011);

                return new ObjectRestResponse().data(jsonObject);
            } else {
                String token = tokenBiz.getToken(userForBaseByEmail);
                try {
                    String userString = SerializeUtils.serialize(userForBaseByEmail);
                    System.out.println("序列字符串:" + userString);
                    try {
                        OggUser user1 = (OggUser) SerializeUtils.serializeToObject(userString);
                        System.out.println("序列字duixiang:" + user1);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    redisUtils.set(token, userString);
                } catch (IOException e) {
                    jsonObject.put("message", "登录失败,序列化对象失败");
                    jsonObject.put("status", 10012);

                    return new ObjectRestResponse().data(jsonObject);
                }
                jsonObject.put("token", token);
                jsonObject.put("user", userForBaseByEmail);

                return new ObjectRestResponse().data(jsonObject);
            }
        } else {
            jsonObject.put("message", "登录失败,用户不存在");
            jsonObject.put("status", 10010);

            return new ObjectRestResponse().data(jsonObject);
        }
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    public ObjectRestResponse userSignUp(OggUser user) {

        JSONObject jsonObject = new JSONObject();
        OggUser userForBase = this.mapper.selectByUserName(user.getUserName());
        OggUser userForBaseByEmail = this.mapper.selectByUserEmail(user.getUserEmail());

        if (userForBase != null) {
            jsonObject.put("message", "注册失败，用户已存在");
            jsonObject.put("status", 1);
            return new ObjectRestResponse().data(jsonObject);
        }
        if (userForBaseByEmail != null) {
            jsonObject.put("message", "注册失败，该邮箱已被注册");
            jsonObject.put("status", 2);
            return new ObjectRestResponse().data(jsonObject);
        } else {

            user.setCreateDateTime(new Date());
            user.setMemberLevelId(1);
            user.setMemberLevelName("灰钻会员");
            user.setIsDestroy(new Byte((byte) 0));
            user.setUserSex(new Byte((byte) 0));
            user.setUserIntroduce("暂无任何简介");
            user.setUserHeadIcon("http://149.28.144.141/image/39db2230-69b8-452a-b423-f36a8df20718.jpg");
            user.setUserPageIcon("http://149.28.144.141/image/77e8009f-eed3-4931-ab22-8b836d834d57.jpeg");
            user.setArticleReadNum(0);
            user.setArticleNum(0);

            this.mapper.insert(user);
            jsonObject.put("status", 200);
            jsonObject.put("message", "注册成功");

            // 生成一条系统通知
            OggNotice notice = new OggNotice();
            notice.setCreateDateTime(new Date());
            notice.setModifyDateTime(new Date());
            notice.setNoticeType("system");
            notice.setActionFromUserId(0);
            notice.setActionFromUserName("system");
            notice.setNoticeToUserId(user.getId());
            notice.setNoticeToUserName(user.getUserName());
            notice.setIsDelete(new Byte((byte) 0));
            notice.setReadStatus(new Byte((byte) 0));
            notice.setNoticeContent("恭喜注册成功");
            notice.setActionAccepter(0);
            noticeMapper.insert(notice);

            return new ObjectRestResponse().data(jsonObject);

        }
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    public ObjectRestResponse updateUserMsg(OggUser user) {
        this.mapper.updateByPrimaryKeySelective(user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 0);
        jsonObject.put("message", "成功");
        return new ObjectRestResponse().data(jsonObject);

    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    public ObjectRestResponse checkNameExist(OggUser user) {

        JSONObject jsonObject = new JSONObject();
        OggUser userForBase = this.mapper.selectByUserName(user.getUserName());
        if (userForBase != null) {
            jsonObject.put("message", "用户已存在");
            jsonObject.put("status", 1);
            return new ObjectRestResponse().data(jsonObject);
        } else {
            jsonObject.put("message", "用户不存在");
            jsonObject.put("status", 0);
            return new ObjectRestResponse().data(jsonObject);
        }
    }

    public ObjectRestResponse userLogout(HttpServletRequest request) {
        String token = request.getHeader("Authorization");// 从 http 请求头中取出 token
        String userObject = redisUtils.get(token);
        if (userObject == null) {
            throw new RuntimeException("退出登录失败，用户token不存在");
        }
        redisUtils.delete(token);
        return new ObjectRestResponse().data("ok");

    }

    public ObjectRestResponse selectUserDetail(Query query) {
        int userId = 0;
        OggUser user = null;
        UserVO userVO = new UserVO();
        Example example = new Example(OggUser.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("userId".equals(entry.getKey())) {
                        userId = Integer.parseInt(entry.getValue().toString());
                    }
                }
            }
            if (userId != 0) {
                user = this.mapper.selectByPrimaryKey(userId);
                OggAuth auth = authMapper.selectByPrimaryKey(user.getMemberLevelId());
                userVO.setId(user.getId());
                userVO.setUserName(user.getUserName());
                userVO.setMemberLevelId(user.getMemberLevelId());
                userVO.setMemberLevelName(user.getMemberLevelName());
                userVO.setUserCity(user.getUserCity());
                userVO.setUserSex(user.getUserSex());
                userVO.setUserIntroduce(user.getUserIntroduce());
                userVO.setUserHeadIcon(user.getUserHeadIcon());
                userVO.setUserPageIcon(user.getUserPageIcon());
                userVO.setCreateDateTime(user.getCreateDateTime());
                userVO.setArticleNum(user.getArticleNum());
                userVO.setArticleReadNum(user.getArticleReadNum());

                userVO.setUserAuthName(auth.getAuthName());
                userVO.setUserAuthIcon(auth.getAuthIcon());
            }
        }
        System.out.println(userVO.getUserSex());
        return new ObjectRestResponse().rel(true).data(userVO);
    }


    public TableResultResponse listArticles(Query query) {

        List<OggArticle> articleList = new ArrayList<>();
        Page result = PageHelper.startPage(query.getPage(), query.getLimit());

        Example example = new Example(OggArticle.class);
        example.setOrderByClause("create_date_time desc");
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("userId".equals(entry.getKey())) {
                        criteria.andEqualTo("createUserId", entry.getValue());
                    }
                }
            }
            articleList = articleMapper.selectByExample(example);
        }
        return new TableResultResponse<>(result.getTotal(), articleList);
    }


    public TableResultResponse listSofts(Query query) {

        List<OggSoft> softList = new ArrayList<>();
        List<SoftListVO> softListVOList = new ArrayList<>();
        Page result = PageHelper.startPage(query.getPage(), query.getLimit());

        Example example = new Example(OggSoft.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("userId".equals(entry.getKey())) {
                        criteria.andLike("createUserId", entry.getValue().toString());
                    }
                }
            }
            example.setOrderByClause("create_date_time desc");
            softList = softMapper.selectByExample(example);
        }
        return new TableResultResponse<>(result.getTotal(), softList);
    }

    public TableResultResponse listNeeds(Query query) {

        List<OggNeed> needList = new ArrayList<>();
        List<NeedListVo> needListVoList = new ArrayList<>();
        Page result = PageHelper.startPage(query.getPage(), query.getLimit());

        Example example = new Example(OggNeed.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString())) {
                    if ("userId".equals(entry.getKey())) {
                        criteria.andEqualTo("createUserId", entry.getValue());
                    }
                }
            }
            example.setOrderByClause("is_solved desc");
            needList = needMapper.selectByExample(example);
        }

        return new TableResultResponse<>(result.getTotal(), needList);
    }

}
