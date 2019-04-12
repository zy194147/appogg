package com.appogg.website.biz.soft;

import com.appogg.website.auth.UserCheck;
import com.appogg.website.biz.BaseBiz;
import com.appogg.website.entity.OggAuth;
import com.appogg.website.entity.OggSoft;
import com.appogg.website.entity.OggUser;
import com.appogg.website.mapper.OggAuthMapper;
import com.appogg.website.mapper.OggSoftMapper;
import com.appogg.website.mapper.OggUserMapper;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.util.Query;
import com.appogg.website.vo.soft.SoftListVO;
import com.appogg.website.vo.soft.SoftVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class OggSoftBiz extends BaseBiz<OggSoftMapper, OggSoft> {

    @Autowired
    private OggUserMapper oggUserMapper;
    @Autowired
    private UserCheck userCheck;

    @Autowired
    private OggAuthMapper authMapper;


    public ObjectRestResponse insertSoftMsg(SoftVO softVO, HttpServletRequest request) {
        OggUser loginUser = userCheck.getLoginUser(request);

        if(loginUser == null){
            return new ObjectRestResponse().rel(true).data("添加失败，未登录");
        }
        OggSoft soft = new OggSoft();
        soft.setSoftTitleName(softVO.getSoftTitleName());
        soft.setSoftTitleIcon(softVO.getSoftTitleIcon());
        soft.setCreateDateTime(new Date());
        soft.setModifyDateTime(new Date());
        soft.setCreateUserId(loginUser.getId());
        soft.setCreateUserName(loginUser.getUserName());
        soft.setIsDelete(new Byte((byte) 0));
        soft.setSoftAuthId(0);
        soft.setSoftClassifyGroup(Arrays.toString(softVO.getSoftClassifyGroup()));
        soft.setSoftContent(softVO.getSoftContent());
        soft.setReadNum(0);
        soft.setCommentNum(0);
        soft.setIsSticky(new Byte((byte) 0));
        soft.setIsFine(new Byte((byte) 0));
        soft.setHelpfulNum(0);
        soft.setUnhelpfulNum(0);
        soft.setSoftSystemPlatform(softVO.getSoftSystemPlatform());
        soft.setSoftDownloadAddr(softVO.getSoftDownloadAddr());

        OggUser user = oggUserMapper.selectByPrimaryKey(loginUser.getId());
        user.setArticleNum(user.getArticleNum()+1);
        oggUserMapper.updateByPrimaryKeySelective(user);

        this.mapper.insertSelective(soft);
        return new ObjectRestResponse().rel(true).data("添加软件成功");
    }


    public TableResultResponse listPublicSoftMsg(Query query) {

        List<OggSoft> softList;
        List<SoftListVO> softListVOList = new ArrayList<>();
        Page result = PageHelper.startPage(query.getPage(), query.getLimit());

        Example example = new Example(OggSoft.class);
        Example.Criteria criteria = example.createCriteria();
        if (query.entrySet().size() > 0) {
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("softSystemPlatform".equals(entry.getKey())) {
                        criteria.andLike("softSystemPlatform", entry.getValue().toString());
                    }
                }
            }
            example.setOrderByClause("create_date_time desc");
        }
        criteria.andEqualTo("isDelete",0);
        softList = this.mapper.selectByExample(example);
        softListVOList = getSoftListData(softList);
        return new TableResultResponse<>(result.getTotal(), softListVOList);
    }


    public TableResultResponse listTrendingSoftMsg(Query query) {

        List<OggSoft> softList;
        List<SoftListVO> softListVOList = new ArrayList<>();
        Page result = PageHelper.startPage(query.getPage(), query.getLimit());
        Example example = new Example(OggSoft.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDelete",0);
        example.setOrderByClause("comment_num desc");
        softList = this.mapper.selectByExample(example);
        softListVOList = getSoftListData(softList);
        return new TableResultResponse<>(result.getTotal(), softListVOList);
    }


    public ObjectRestResponse selectSoftDetail(Query query) {

        int softId = 0;
        OggSoft soft = null;
        Example example = new Example(OggSoft.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("id".equals(entry.getKey())) {
                        softId = Integer.parseInt(entry.getValue().toString());
                    }
                }
            }
            if (softId != 0) {
                soft = this.mapper.selectByPrimaryKey(softId);
            }
        }
        SoftListVO softListVO = getSoftListVOData(soft);
        return new ObjectRestResponse().rel(true).data(softListVO);
    }

    public ObjectRestResponse updateSoftReadNum(Query query) {

        int softId = 0;
        OggSoft soft = null;
        Example example = new Example(OggSoft.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("id".equals(entry.getKey())) {
                        softId = Integer.parseInt(entry.getValue().toString());
                    }
                }
            }
            if (softId != 0) {
                soft = this.mapper.selectByPrimaryKey(softId);
                soft.setReadNum(soft.getReadNum() + 1);

                // 更新总阅读量
                OggUser user = oggUserMapper.selectByPrimaryKey(soft.getCreateUserId());
                user.setArticleReadNum(user.getArticleReadNum()+1);
                oggUserMapper.updateByPrimaryKeySelective(user);
                this.mapper.updateByPrimaryKey(soft);
            }
        }
        return new ObjectRestResponse().rel(true).data("ok");
    }

    private List<SoftListVO> getSoftListData(List<OggSoft> softList) {
        List<SoftListVO> softListVOList = new ArrayList<>();
        for (OggSoft soft : softList) {
            SoftListVO softListVO = getSoftListVOData(soft);
            softListVOList.add(softListVO);
        }
        return softListVOList;
    }

    private SoftListVO getSoftListVOData(OggSoft soft) {
        OggUser user = oggUserMapper.selectByPrimaryKey(soft.getCreateUserId());
        SoftListVO softListVO = new SoftListVO();
        softListVO.setId(soft.getId());
        softListVO.setSoftUserIcon(user.getUserHeadIcon());
        softListVO.setSoftUserLevelName(user.getMemberLevelName());
        softListVO.setCreateUserName(soft.getCreateUserName());
        softListVO.setCommentNum(soft.getCommentNum());
        softListVO.setSoftTitleName(soft.getSoftTitleName());
        softListVO.setCreateUserId(soft.getCreateUserId());
        softListVO.setSoftClassifyGroup(soft.getSoftClassifyGroup().substring(1, soft.getSoftClassifyGroup().length() - 1).split(","));
        softListVO.setCreateDateTime(soft.getCreateDateTime());
        softListVO.setSoftContent(soft.getSoftContent());
        softListVO.setSoftSystemPlatform(soft.getSoftSystemPlatform());
        softListVO.setReadNum(soft.getReadNum());
        softListVO.setSoftTitleIcon(soft.getSoftTitleIcon());
        softListVO.setSoftDownloadAddr(soft.getSoftDownloadAddr().split(";"));
        softListVO.setUserHeadIcon(user.getUserHeadIcon());

        OggAuth auth = authMapper.selectByPrimaryKey(user.getMemberLevelId());
        softListVO.setUserAuthName(auth.getAuthName());
        softListVO.setUserAuthIcon(auth.getAuthIcon());
        return softListVO;
    }

}
