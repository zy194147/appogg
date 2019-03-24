package com.appogg.website.biz.need;

import com.appogg.website.biz.BaseBiz;
import com.appogg.website.entity.*;
import com.appogg.website.mapper.*;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.util.Query;
import com.appogg.website.vo.comment.CommentListVo;
import com.appogg.website.vo.need.NeedAnswerVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
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
    private OggNoticeMapper noticeMapper;

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
        example.setOrderByClause("is_adopt desc");
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
            commentListVo.setIsAdopt(needAnswer.getIsAdopt());
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


        // 生成一条系统通知
        OggNotice notice = new OggNotice();
        notice.setCreateDateTime(new Date());
        notice.setModifyDateTime(new Date());
        notice.setNoticeType("article");
        notice.setActionFromUserId(user.getId());
        notice.setActionFromUserName(user.getUserName());
        notice.setNoticeToUserId(need.getCreateUserId());
        OggUser toUser = userMapper.selectByPrimaryKey(need.getCreateUserId());
        notice.setNoticeToUserName(toUser.getUserName());
        notice.setIsDelete(new Byte((byte) 0));
        notice.setReadStatus(new Byte((byte) 0));
        notice.setNoticeContent(notice.getActionFromUserName() + " 在" + notice.getCreateDateTime() + " 评论了你的软件");
        notice.setActionAccepter(answerVO.getAnswerNeedId());
        noticeMapper.insert(notice);

        return new ObjectRestResponse().data("ok");


    }





    public ObjectRestResponse needAdoptAnswer(Query query) {

        int answerId = 0;
        OggNeedAnswer needAnswer = null;
        OggNeed need ;
        Example example = new Example(OggArticle.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("id".equals(entry.getKey())) {
                        answerId = Integer.parseInt(entry.getValue().toString());
                    }
                }
            }
            if (answerId != 0) {
                needAnswer = this.mapper.selectByPrimaryKey(answerId);
                needAnswer.setIsAdopt(new Byte((byte)1));
                // 更新打案为采纳
                this.mapper.updateByPrimaryKeySelective(needAnswer);
                need = needMapper.selectByPrimaryKey(needAnswer.getAnswerNeedId());
                need.setIsSolved(new Byte((byte)1));
                // 更新问题文章为已解决
                needMapper.updateByPrimaryKeySelective(need);

            }
        }
        return new ObjectRestResponse().rel(true).data("ok");
    }




    public ObjectRestResponse needUnadoptAnswer(Query query) {

        int answerId = 0;
        OggNeedAnswer needAnswer = null;
        OggNeed need ;
        Example example = new Example(OggArticle.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("id".equals(entry.getKey())) {
                        answerId = Integer.parseInt(entry.getValue().toString());
                    }
                }
            }
            if (answerId != 0) {
                needAnswer = this.mapper.selectByPrimaryKey(answerId);
                needAnswer.setIsAdopt(new Byte((byte)0));
                // 更新打案为采纳
                this.mapper.updateByPrimaryKeySelective(needAnswer);
                need = needMapper.selectByPrimaryKey(needAnswer.getAnswerNeedId());
                need.setIsSolved(new Byte((byte)0));
                // 更新问题文章为已解决
                needMapper.updateByPrimaryKeySelective(need);

            }
        }
        return new ObjectRestResponse().rel(true).data("ok");
    }





}
