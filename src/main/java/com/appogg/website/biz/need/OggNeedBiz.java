package com.appogg.website.biz.need;

import com.appogg.website.auth.UserCheck;
import com.appogg.website.biz.BaseBiz;
import com.appogg.website.entity.OggArticle;
import com.appogg.website.entity.OggNeed;
import com.appogg.website.entity.OggUser;
import com.appogg.website.mapper.OggNeedMapper;
import com.appogg.website.mapper.OggUserMapper;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.util.Query;
import com.appogg.website.vo.need.NeedListVo;
import com.appogg.website.vo.need.NeedVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Service
public class OggNeedBiz extends BaseBiz<OggNeedMapper,OggNeed> {

    @Autowired
    private OggUserMapper userMapper;

    @Autowired
    private UserCheck userCheck;

    public ObjectRestResponse insertNeedMsg(NeedVo needVo, HttpServletRequest request){
        OggUser loginUser = userCheck.getLoginUser(request);

        if(loginUser == null){
            return new ObjectRestResponse().rel(true).data("添加失败，未登录");
        }
        OggNeed need = new OggNeed();
        need.setCreateDateTime(new Date());
        need.setModifyDateTime(new Date());
        need.setCreateUserId(loginUser.getId());
        need.setCreateUserName(loginUser.getUserName());
        need.setModifyUserId(loginUser.getId());
        need.setModifyUserName(loginUser.getUserName());
        need.setHelpfulNum(0);
        need.setUnhelpfulNum(0);
        need.setIsSolved(new Byte((byte)0));
        need.setIsDelete(new Byte((byte)0));
        need.setReadNum(0);
        need.setAnswerNum(0);
        need.setIsSticky(new Byte((byte)0));
        need.setIsFine(new Byte((byte)0));
        need.setNeedTitleName(needVo.getNeedTitleName());
        need.setNeedClassifyGroup(Arrays.toString(needVo.getNeedClassifyGroup()));
        need.setNeedContent(needVo.getNeedContent());
        // 更新文章数量
        OggUser user = userMapper.selectByPrimaryKey(loginUser.getId());
        user.setArticleNum(user.getArticleNum()+1);
        userMapper.updateByPrimaryKeySelective(user);
        this.mapper.insertSelective(need);
        return new ObjectRestResponse().rel(true).data("添加需求成功");
    }



    public TableResultResponse listPublicNeedMsg(Query query){

        List<OggNeed> needList ;
        List<NeedListVo> needListVoList = new ArrayList<>();
        Page result = PageHelper.startPage(query.getPage(),query.getLimit());

        Example example = new Example(OggNeed.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString())) {
                    if ("isSolved".equals(entry.getKey())) {
                        criteria.andEqualTo("isSolved",entry.getValue());
                    }
                    if ("createUserId".equals(entry.getKey())) {
                        criteria.andEqualTo("createUserId",entry.getValue());
                    }
                }
            }
            example.setOrderByClause("is_solved desc");
            needList = this.mapper.selectByExample(example);
        } else {
            needList = this.mapper.selectAll();
        }
        for(OggNeed need:needList){
            NeedListVo needListVo = getNeedListVo(need);
            needListVoList.add(needListVo);
        }

        return new TableResultResponse<>(result.getTotal(),needListVoList);
    }


    public TableResultResponse listTrendingNeedMsg(Query query) {

        List<OggNeed> needList;
        List<NeedVo> needListVOList = new ArrayList<>();
        Page result = PageHelper.startPage(query.getPage(), query.getLimit());
        Example example = new Example(OggNeed.class);

        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("needUserId".equals(entry.getKey())) {
                        criteria.andEqualTo("needUserId",1);
                    }
                }
            }
            needList = this.mapper.selectByExample(example);
        } else {
            needList = this.mapper.selectAll();
        }
        example.setOrderByClause("answer_num desc");
//        needList = this.mapper.selectByExample(example);
        for(OggNeed need:needList){
            NeedVo needVo = new NeedVo();
            needVo.setNeedTitleName(need.getNeedTitleName());
            needVo.setId(need.getId());
            needVo.setAnswerNum(need.getAnswerNum());
            needVo.setNeedUserId(need.getCreateUserId());
            needListVOList.add(needVo);
        }
        return new TableResultResponse<>(result.getTotal(), needListVOList);
    }

    public ObjectRestResponse selectNeedDetail(Query query){

        int needId = 0;
        OggNeed need = null;
        Example example = new Example(OggNeed.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("id".equals(entry.getKey())) {
                        needId = Integer.parseInt(entry.getValue().toString());
                    }
                }
            }
            if(needId != 0){
                need = this.mapper.selectByPrimaryKey(needId);
            }
        }
        NeedListVo needListVo = getNeedListVo(need);
        return new ObjectRestResponse().rel(true).data(needListVo);
    }


    public ObjectRestResponse updateNeedReadNum(Query query) {

        int needId = 0;
        OggNeed need = null;
        Example example = new Example(OggArticle.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("id".equals(entry.getKey())) {
                        needId = Integer.parseInt(entry.getValue().toString());
                    }
                }
            }
            if (needId != 0) {
                need = this.mapper.selectByPrimaryKey(needId);
                need.setReadNum(need.getReadNum() + 1);
                // 更新总阅读量
                OggUser user = userMapper.selectByPrimaryKey(need.getCreateUserId());
                user.setArticleReadNum(user.getArticleReadNum()+1);
                userMapper.updateByPrimaryKeySelective(user);
                this.mapper.updateByPrimaryKey(need);
            }
        }
        return new ObjectRestResponse().rel(true).data("ok");
    }


    private NeedListVo getNeedListVo(OggNeed need){

        NeedListVo needListVo = new NeedListVo();
        needListVo.setId(need.getId());
        needListVo.setCreateDateTime(need.getCreateDateTime());
        needListVo.setCreateUserId(need.getCreateUserId());
        needListVo.setCreateUserName(need.getCreateUserName());
        needListVo.setIsSolved(need.getIsSolved());
        needListVo.setNeedTitleName(need.getNeedTitleName());
        needListVo.setNeedClassifyGroup(need.getNeedClassifyGroup().substring(1, need.getNeedClassifyGroup().length() - 1).split(","));
        needListVo.setNeedContent(need.getNeedContent());
        needListVo.setAnswerNum(need.getAnswerNum());
        needListVo.setReadNum(need.getReadNum());

        OggUser user = userMapper.selectByPrimaryKey(need.getCreateUserId());
        needListVo.setUserHeadIcon(user.getUserHeadIcon());

        return needListVo;
    }

}
