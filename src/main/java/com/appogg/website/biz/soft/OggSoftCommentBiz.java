package com.appogg.website.biz.soft;

import com.appogg.website.biz.BaseBiz;
import com.appogg.website.entity.OggArticleComment;
import com.appogg.website.entity.OggSoft;
import com.appogg.website.entity.OggSoftComment;
import com.appogg.website.mapper.OggSoftCommentMapper;
import com.appogg.website.mapper.OggSoftMapper;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.util.Query;
import com.appogg.website.vo.article.ArticleCommentVO;
import com.appogg.website.vo.soft.SoftCommentVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OggSoftCommentBiz extends BaseBiz<OggSoftCommentMapper, OggSoftComment> {

    @Autowired
    private OggSoftMapper softMapper;

    public TableResultResponse selectCommentByQuery(Query query) {
        Class<OggSoftComment> clazz = (Class<OggSoftComment>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Example example = new Example(clazz);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                criteria.andEqualTo(entry.getKey(), entry.getValue());
            }
        }

        // 分页
        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<OggSoftComment> list = mapper.selectByExample(example);
        return new TableResultResponse<OggSoftComment>(result.getTotal(), list);
    }


    public ObjectRestResponse insertSoftComment(SoftCommentVO commentVO) {

        OggSoftComment softComment = new OggSoftComment();
        softComment.setCreateUserId(1);
        softComment.setCreateUserName("zhangyj");
        softComment.setCreateDateTime(new Date());
        softComment.setModifyDateTime(new Date());
        softComment.setModifyUserId(1);
        softComment.setModifyUserName("zhangyj");
        softComment.setCommentContent(commentVO.getCommentContent());
        softComment.setIsDelete(new Byte((byte) 0));
        softComment.setIsSticky(new Byte((byte) 0));
        softComment.setHelpfulNum(0);
        softComment.setUnhelpfulNum(0);
        softComment.setCommentSoftId(commentVO.getCommentSoftId());
        softComment.setParentId(0);
        softComment.setPath(",1");
        softComment.setBackToUserId(0);
        softComment.setBackToUserName(null);



        this.mapper.insertSelective(softComment);
        // 更新软件的评论数
        OggSoft soft = softMapper.selectByPrimaryKey(softComment.getCommentSoftId());
        soft.setCommentNum(soft.getCommentNum()+1);
        softMapper.updateByPrimaryKeySelective(soft);

        return new ObjectRestResponse().data("ok");


    }

}
