package com.appogg.website.biz.need;

import com.appogg.website.biz.BaseBiz;
import com.appogg.website.entity.OggNeed;
import com.appogg.website.mapper.OggNeedMapper;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.util.Query;
import com.appogg.website.vo.need.NeedVo;
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
public class OggNeedBiz extends BaseBiz<OggNeedMapper,OggNeed> {
    public ObjectRestResponse insertNeedMsg(NeedVo needVo){
        OggNeed need = new OggNeed();
        need.setCreateDateTime(new Date());
        need.setModifyDateTime(new Date());
        need.setCreateUserId(1);
        need.setCreateUserName("zhangyj");
        need.setModifyUserId(1);
        need.setModifyUserName("zhangyj");
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
        this.mapper.insertSelective(need);
        return new ObjectRestResponse().rel(true).data("添加需求成功");
    }



    public TableResultResponse listPublicNeedMsg(Query query){

        List<OggNeed> needList ;
        Page result = PageHelper.startPage(query.getPage(),query.getLimit());

        Example example = new Example(OggNeed.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("isSolved".equals(entry.getKey())) {
                        System.out.println(".sdfslfkj...");
                        criteria.andEqualTo("isSolved",entry.getValue());
                    }
                }
            }
            needList = this.mapper.selectByExample(example);
        } else {
            needList = this.mapper.selectAll();
        }

        return new TableResultResponse<>(result.getTotal(),needList);
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
        return new ObjectRestResponse().rel(true).data(need);
    }

}
