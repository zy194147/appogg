package com.appogg.website.biz.need;

import com.appogg.website.biz.BaseBiz;
import com.appogg.website.entity.OggNeedAnswer;
import com.appogg.website.mapper.OggNeedAnswerMapper;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.util.Query;
import com.appogg.website.vo.need.NeedAnswerVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OggNeedAnswerBiz extends BaseBiz<OggNeedAnswerMapper,OggNeedAnswer> {


    public TableResultResponse selectAnswerByQuery(Query query) {
        Class<OggNeedAnswer> clazz = (Class<OggNeedAnswer>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Example example = new Example(clazz);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                criteria.andEqualTo(entry.getKey(), entry.getValue());
            }
        }
        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<OggNeedAnswer> list = mapper.selectByExample(example);
        return new TableResultResponse<OggNeedAnswer>(result.getTotal(), list);
    }


    public ObjectRestResponse insertNeedAnswer(NeedAnswerVO answerVO) {

        OggNeedAnswer needAnswer = new OggNeedAnswer();
        needAnswer.setCreateUserId(1);
        needAnswer.setCreateUserName("zhangyj");
        needAnswer.setCreateDateTime(new Date());
        needAnswer.setModifyDateTime(new Date());
        needAnswer.setModifyUserId(1);
        needAnswer.setModifyUserName("zhangyj");
        needAnswer.setAnswerContent(answerVO.getAnswerContent());
        needAnswer.setIsDelete(new Byte((byte) 0));
        needAnswer.setIsSticky(new Byte((byte) 0));
        needAnswer.setHelpfulNum(0);
        needAnswer.setUnhelpfulNum(0);
        needAnswer.setAnswerNeedId(answerVO.getAnswerNeedId());
        needAnswer.setParentId(0);
        needAnswer.setPath(",1");
        needAnswer.setBackToUserId(0);
        needAnswer.setBackToUserName(null);
        needAnswer.setIsAdopt(new Byte((byte)0));
        needAnswer.setIsEnable(new Byte((byte)0));

        this.mapper.insertSelective(needAnswer);
        return new ObjectRestResponse().data("ok");


    }
}
