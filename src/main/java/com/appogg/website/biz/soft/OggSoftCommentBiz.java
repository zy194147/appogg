package com.appogg.website.biz.soft;

import com.appogg.website.biz.BaseBiz;
import com.appogg.website.entity.*;
import com.appogg.website.mapper.OggNoticeMapper;
import com.appogg.website.mapper.OggSoftCommentMapper;
import com.appogg.website.mapper.OggSoftMapper;
import com.appogg.website.mapper.OggUserMapper;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.util.Query;
import com.appogg.website.vo.comment.CommentListVo;
import com.appogg.website.vo.soft.SoftCommentVO;
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
public class OggSoftCommentBiz extends BaseBiz<OggSoftCommentMapper, OggSoftComment> {

    @Autowired
    private OggSoftMapper softMapper;

    @Autowired
    private OggNoticeMapper noticeMapper;

    @Autowired
    private OggUserMapper userMapper;

    public ObjectRestResponse selectCommentByQuery(Query query) {
        Class<OggSoftComment> clazz = (Class<OggSoftComment>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Example example = new Example(clazz);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                criteria.andEqualTo(entry.getKey(), entry.getValue());
            }
        }

        // 分页
//        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<OggSoftComment> list = mapper.selectByExample(example);
        List<CommentListVo> commentListVoList = getCommentList(list);

        return new ObjectRestResponse().data(commentListVoList);
    }



    private List<CommentListVo> getCommentList(List<OggSoftComment> softCommentList){

        List<CommentListVo> commentListVoList = new ArrayList<>();
        for(OggSoftComment softComment:softCommentList){
            CommentListVo commentListVo = new CommentListVo();
            OggUser user = userMapper.selectByPrimaryKey(softComment.getCreateUserId());
            commentListVo.setId(softComment.getId());
            commentListVo.setCommentContent(softComment.getCommentContent());
            commentListVo.setCommentUserIcon(user.getUserHeadIcon());
            commentListVo.setCommentUserId(softComment.getCreateUserId());
            commentListVo.setCommentUserName(softComment.getCreateUserName());
            commentListVo.setCreateDateTime(softComment.getCreateDateTime());
            commentListVo.setBackToUserId(softComment.getBackToUserId());
            commentListVo.setBackToUserName(softComment.getBackToUserName());
            commentListVoList.add(commentListVo);
        }
        return commentListVoList;

    }



    public ObjectRestResponse insertSoftComment(SoftCommentVO commentVO) {

        OggSoftComment softComment = new OggSoftComment();
        OggUser user = userMapper.selectByPrimaryKey(commentVO.getCommentUserId());
        softComment.setCreateUserId(user.getId());
        softComment.setCreateUserName(user.getUserName());
        softComment.setCreateDateTime(new Date());
        softComment.setModifyDateTime(new Date());
        softComment.setModifyUserId(user.getId());
        softComment.setModifyUserName(user.getUserName());
        softComment.setCommentContent(commentVO.getCommentContent());
        softComment.setIsDelete(new Byte((byte) 0));
        softComment.setIsSticky(new Byte((byte) 0));
        softComment.setHelpfulNum(0);
        softComment.setUnhelpfulNum(0);
        softComment.setCommentSoftId(commentVO.getCommentSoftId());
        softComment.setParentId(commentVO.getCommentParentId());
        softComment.setPath(",1");
        softComment.setBackToUserId(commentVO.getBackToUserId());
        softComment.setBackToUserName(commentVO.getBackToUserName());



        this.mapper.insertSelective(softComment);
        // 更新软件的评论数
        OggSoft soft = softMapper.selectByPrimaryKey(softComment.getCommentSoftId());
        soft.setCommentNum(soft.getCommentNum()+1);
        softMapper.updateByPrimaryKeySelective(soft);

        // 生成一条系统通知
        OggNotice notice = new OggNotice();
        notice.setCreateDateTime(new Date());
        notice.setModifyDateTime(new Date());
        notice.setNoticeType("comment");
        notice.setActionFromUserId(user.getId());
        notice.setActionFromUserName(user.getUserName());
        notice.setNoticeToUserId(soft.getCreateUserId());
        OggUser toUser = userMapper.selectByPrimaryKey(soft.getCreateUserId());
        notice.setNoticeToUserName(toUser.getUserName());
        notice.setIsDelete(new Byte((byte) 0));
        notice.setReadStatus(new Byte((byte) 0));
        notice.setNoticeContent(notice.getActionFromUserName() + " 在" + notice.getCreateDateTime() + " 评论了你的软件");
        notice.setActionAccepter(commentVO.getCommentSoftId());
        notice.setNoticeModule("soft");
        noticeMapper.insert(notice);


        return new ObjectRestResponse().data("ok");


    }

}
