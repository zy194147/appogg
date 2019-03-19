package com.appogg.website.biz.need;

import com.appogg.website.biz.BaseBiz;
import com.appogg.website.entity.OggArticleComment;
import com.appogg.website.entity.OggNeed;
import com.appogg.website.entity.OggNeedAnswer;
import com.appogg.website.entity.OggUser;
import com.appogg.website.mapper.OggNeedAnswerMapper;
import com.appogg.website.mapper.OggNeedMapper;
import com.appogg.website.mapper.OggSoftMapper;
import com.appogg.website.mapper.OggUserMapper;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.util.Query;
import com.appogg.website.vo.comment.CommentListVo;
import com.appogg.website.vo.need.NeedAnswerVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OggNeedAnswerBiz extends BaseBiz<OggNeedAnswerMapper,OggNeedAnswer> {

    @Autowired
    private OggNeedMapper needMapper;

    @Autowired
    private OggUserMapper userMapper;


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

        List<CommentListVo> commentListVoList = getCommentList(list);

        return new TableResultResponse<CommentListVo>(result.getTotal(), commentListVoList);
    }




    private List<CommentListVo> getCommentList(List<OggNeedAnswer> needAnswerList){

        List<CommentListVo> commentListVoList = new ArrayList<>();
        for(OggNeedAnswer needAnswer:needAnswerList){
            CommentListVo commentListVo = new CommentListVo();
            OggUser user = userMapper.selectByPrimaryKey(needAnswer.getCreateUserId());
            commentListVo.setId(needAnswer.getId());
            commentListVo.setCommentContent(needAnswer.getAnswerContent());
            commentListVo.setCommentUserIcon(user.getUserHeadIcon());
            commentListVo.setCommentUserId(needAnswer.getCreateUserId());
            commentListVo.setCommentUserName(needAnswer.getCreateUserName());
            commentListVo.setCreateDateTime(needAnswer.getCreateDateTime());
            commentListVo.setBackToUserId(needAnswer.getBackToUserId());
            commentListVo.setBackToUserName(needAnswer.getBackToUserName());
            commentListVoList.add(commentListVo);
        }
        return commentListVoList;

    }


    public ObjectRestResponse insertNeedAnswer(NeedAnswerVO answerVO) {

        OggNeedAnswer needAnswer = new OggNeedAnswer();

        OggUser user = userMapper.selectByPrimaryKey(answerVO.getAnswerUserId());

        needAnswer.setCreateUserId(user.getId());
        needAnswer.setCreateUserName(user.getUserName());
        needAnswer.setCreateDateTime(new Date());
        needAnswer.setModifyDateTime(new Date());
        needAnswer.setModifyUserId(user.getId());
        needAnswer.setModifyUserName(user.getUserName());
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

        // 更新问题评论数
        OggNeed need = needMapper.selectByPrimaryKey(needAnswer.getAnswerNeedId());
        need.setAnswerNum(need.getAnswerNum() + 1);
        needMapper.updateByPrimaryKeySelective(need);

        return new ObjectRestResponse().data("ok");


    }
}
