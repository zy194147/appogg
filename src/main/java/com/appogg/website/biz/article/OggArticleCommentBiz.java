package com.appogg.website.biz.article;

import com.appogg.website.biz.BaseBiz;
import com.appogg.website.entity.OggArticleComment;
import com.appogg.website.mapper.OggArticleCommentMapper;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.util.Query;
import com.appogg.website.vo.comment.CommentTree;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class OggArticleCommentBiz extends BaseBiz<OggArticleCommentMapper,OggArticleComment> {

    public TableResultResponse selectCommentByQuery(Query query){
        Class<OggArticleComment> clazz = (Class<OggArticleComment>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Example example = new Example(clazz);
        if(query.entrySet().size()>0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                criteria.andEqualTo(entry.getKey(), entry.getValue());
            }
        }
        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<OggArticleComment> list = mapper.selectByExample(example);
//        for(OggArticleComment articleComment:list){
//            System.out.println("1"+articleComment.toString());
//        }
//        List<CommentTree> commentTreeNodeList = getCommentTreeList(list);
//        List<CommentTree> commentNodeList = TreeUtil.buildByRecursive(commentTreeNodeList,0);

//        for(CommentTree commentTree:commentNodeList){
//            System.out.println("2"+commentTree.toString());
//        }

        return new TableResultResponse<OggArticleComment>(result.getTotal(), list);
    }




    private List<CommentTree> getCommentTreeList(List<OggArticleComment> commentList){
        List<CommentTree> treeNodeList = new ArrayList<>();
        // 遍历查询结果，将结果转化为树形list
        for (OggArticleComment articleComment : commentList) {
            CommentTree tree = new CommentTree();
            tree.setName(articleComment.getCommentContent());
            tree.setValue(articleComment.getId().toString());
            tree.setLabel(articleComment.getCommentContent());
            tree.setId(articleComment.getId());
            tree.setParentId(articleComment.getParentId());

            tree.setCommentId(articleComment.getId());
            tree.setCreateDateTime(articleComment.getCreateDateTime());
            tree.setModifyDateTime(articleComment.getModifyDateTime());
            tree.setCreateUserId(articleComment.getCreateUserId());
            tree.setCreateUserName(articleComment.getCreateUserName());
            tree.setModifyUserId(articleComment.getModifyUserId());
            tree.setModifyUserName(articleComment.getModifyUserName());
            tree.setIsDelete(articleComment.getIsDelete());
            tree.setIsSticky(articleComment.getIsSticky());
            tree.setHelpfulNum(articleComment.getHelpfulNum());
            tree.setUnhelpfulNum(articleComment.getUnhelpfulNum());
            tree.setCommentArticleId(articleComment.getCommentArticleId());
            tree.setPath(articleComment.getPath());
            tree.setCommentContent(articleComment.getCommentContent());

            treeNodeList.add(tree);
        }
        return treeNodeList;
    }
}
