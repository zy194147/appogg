package com.appogg.website.biz.classify;

import com.appogg.website.biz.BaseBiz;
import com.appogg.website.entity.OggClassify;
import com.appogg.website.mapper.OggClassifyMapper;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.util.Query;
import com.appogg.website.vo.classify.ClassifyVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OggClassifyBiz extends BaseBiz<OggClassifyMapper, OggClassify> {


    public TableResultResponse listClassify(Query query) {

        List<OggClassify> softList;
        Page result = PageHelper.startPage(query.getPage(), query.getLimit());

        Example example = new Example(OggClassify.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("classifyType".equals(entry.getKey())) {
                        criteria.andLike("classifyType", entry.getValue().toString());
                    }
                }
            }
            softList = this.mapper.selectByExample(example);
        } else {
            softList = this.mapper.selectAll();
        }
        return new TableResultResponse<>(result.getTotal(), softList);
    }

    public ObjectRestResponse addClassify(ClassifyVO classifyVO) {
        OggClassify classify = new OggClassify();
        classify.setClassifyName(classifyVO.getClassifyName());
        classify.setClassifyType(classifyVO.getClassifyType());
        classify.setCreateDateTime(new Date());
        classify.setModirfyDateTime(new Date());
        classify.setClassifyCreateUserId(1);
        classify.setClassifyCreateUserName("zhangyj");
        classify.setIsEnable(new Byte((byte) 1));
        classify.setIsDelete(new Byte((byte) 0));
        this.mapper.insertSelective(classify);
        return new ObjectRestResponse().data("ok");

    }

}
