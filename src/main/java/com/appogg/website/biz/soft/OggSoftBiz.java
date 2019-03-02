package com.appogg.website.biz.soft;

import com.appogg.website.biz.BaseBiz;
import com.appogg.website.entity.OggArticle;
import com.appogg.website.entity.OggSoft;
import com.appogg.website.entity.OggSoft;
import com.appogg.website.mapper.OggSoftMapper;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.util.Query;
import com.appogg.website.vo.soft.SoftVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OggSoftBiz extends BaseBiz<OggSoftMapper, OggSoft> {

    public ObjectRestResponse insertSoftMsg(SoftVO softVO) {

        OggSoft soft = new OggSoft();
        soft.setSoftTitleName(softVO.getSoftTitleName());
        soft.setSoftTitleIcon(softVO.getSoftTitleIcon());
        soft.setCreateDateTime(new Date());
        soft.setModifyDateTime(new Date());
        soft.setCreateUserId(1);
        soft.setCreateUserName("zhangyj");
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

        this.mapper.insertSelective(soft);
        return new ObjectRestResponse().rel(true).data("添加软件成功");
    }



    public TableResultResponse listPublicSoftMsg(Query query){

        List<OggSoft> softList ;
        List<SoftVO> softVOList ;
        Page result = PageHelper.startPage(query.getPage(),query.getLimit());

        Example example = new Example(OggSoft.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("softSystemPlatform".equals(entry.getKey())) {
                        criteria.andEqualTo("softSystemPlatform",entry.getValue());
                    }
                }
            }
            softList = this.mapper.selectByExample(example);
        } else {
            softList = this.mapper.selectAll();
        }
        return new TableResultResponse<>(result.getTotal(),softList);
    }



    public ObjectRestResponse selectSoftDetail(Query query){

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
            if(softId != 0){
                soft = this.mapper.selectByPrimaryKey(softId);
            }
        }
        return new ObjectRestResponse().rel(true).data(soft);
    }
    public ObjectRestResponse updateSoftReadNum(Query query){

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
            if(softId != 0){
                soft = this.mapper.selectByPrimaryKey(softId);
                soft.setReadNum(soft.getReadNum()+1);
                this.mapper.updateByPrimaryKey(soft);
            }
        }
        return new ObjectRestResponse().rel(true).data("ok");
    }


}
