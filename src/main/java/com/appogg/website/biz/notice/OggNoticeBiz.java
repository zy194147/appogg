package com.appogg.website.biz.notice;

import com.appogg.website.biz.BaseBiz;
import com.appogg.website.entity.OggNotice;
import com.appogg.website.entity.OggUser;
import com.appogg.website.mapper.OggNoticeMapper;
import com.appogg.website.mapper.OggUserMapper;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.util.Query;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

@Service
public class OggNoticeBiz extends BaseBiz<OggNoticeMapper,OggNotice> {

    @Autowired
    private OggUserMapper userMapper;


    public TableResultResponse listNotice(Query query){

        Example example = new Example(OggNotice.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if ("id".equals(entry.getKey())) {
                    criteria.andEqualTo("noticeToUserId", entry.getValue());
                }
            }
        }

        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());

        List<OggNotice> noticeList = this.mapper.selectByExample(example);

        return new TableResultResponse<OggNotice>(result.getTotal(), noticeList);
    }

    public ObjectRestResponse listCommentNotice(Query query){

        List<OggNotice> noticeList = new ArrayList<>();
        List<OggNotice> commentNoticeList = new ArrayList<>();
        List<OggNotice> leaveMsgNoticeList = new ArrayList<>();
        List<OggNotice> systemNoticeList = new ArrayList<>();
        Map<String,List<OggNotice>> stringListMap = new HashMap<>();
        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        Example example = new Example(OggNotice.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria1 = example.createCriteria();
            example.setOrderByClause("read_status desc");
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if ("id".equals(entry.getKey())) {
                    criteria1.andEqualTo("noticeToUserId", entry.getValue());
                }
            }
        }
        example.setOrderByClause("create_date_time desc");
        noticeList = this.mapper.selectByExample(example);
        for(OggNotice notice:noticeList){
            if("comment".equals(notice.getNoticeType())){
                commentNoticeList.add(notice);
            } else if("leaveMsg".equals(notice.getNoticeType())){
                leaveMsgNoticeList.add(notice);
            } else if("system".equals(notice.getNoticeType())){
                systemNoticeList.add(notice);
            }
        }
        stringListMap.put("commentNotice",commentNoticeList);
        stringListMap.put("leaveMsgNotice",leaveMsgNoticeList);
        stringListMap.put("systemNotice",systemNoticeList);
        return new ObjectRestResponse().data(stringListMap);
    }

    public ObjectRestResponse setCommentNoticeRead(Query query){

        OggNotice notice = new OggNotice();
        if (query.entrySet().size() > 0) {
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if ("id".equals(entry.getKey())) {
                    notice.setId(Integer.parseInt(entry.getValue().toString()));
                    notice.setReadStatus(new Byte((byte) 1));
                }
            }
        }

        this.mapper.updateByPrimaryKeySelective(notice);
        return new ObjectRestResponse().data("ok");
    }

    public ObjectRestResponse sendGlobalNotice(OggNotice sendNotice){
        List<OggUser> userList = this.userMapper.selectAll();
        for(OggUser user:userList){
            OggNotice notice = new OggNotice();
            notice.setNoticeContent(sendNotice.getNoticeContent());
            notice.setCreateDateTime(new Date());
            notice.setModifyDateTime(new Date());
            notice.setActionFromUserId(0);
            notice.setActionFromUserName("system");
            notice.setIsDelete(new Byte((byte) 0));
            notice.setNoticeToUserId(user.getId());
            notice.setNoticeToUserName(user.getUserName());
            notice.setNoticeType("system");
            notice.setActionAccepter(0);
            notice.setNoticeModule("system");
            notice.setReadStatus(new Byte((byte) 0));
            this.mapper.insert(notice);
        }
//        OggNotice notice = new OggNotice();
//        notice.setNoticeContent(sendNotice.getNoticeContent());
//        notice.setCreateDateTime(new Date());
//        notice.setModifyDateTime(new Date());
//        notice.setActionFromUserId(0);
//        notice.setActionFromUserName("system");
//        notice.setIsDelete(new Byte((byte) 0));
//        notice.setNoticeToUserId(0);
//        notice.setNoticeToUserName("all");
//        notice.setNoticeType("system");
//        notice.setActionAccepter(0);
//        notice.setNoticeModule("system");
//        notice.setReadStatus(new Byte((byte) 0));
//
//        this.mapper.insert(notice);
        return new ObjectRestResponse().data("ok");
    }

    public ObjectRestResponse getNotReadNoticeTotal(Query query){

        Example example = new Example(OggNotice.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if ("id".equals(entry.getKey())) {
                    criteria.andEqualTo("noticeToUserId", entry.getValue());
                }
                if ("noticeType".equals(entry.getKey())) {
                    criteria.andEqualTo("noticeType", entry.getValue());
                }
            }
            criteria.andEqualTo("readStatus",0);
        }

        int noticeTotal = this.mapper.selectCountByExample(example);

        return new ObjectRestResponse().data(noticeTotal);
    }

    public ObjectRestResponse insertCommentNotice(int fromId,int toId, int accepterId){
        OggNotice notice = new OggNotice();
        notice.setCreateDateTime(new Date());
        notice.setModifyDateTime(new Date());
        notice.setNoticeType("article");
        if(fromId > 0){
            notice.setActionFromUserId(fromId);
            OggUser fromUser = userMapper.selectByPrimaryKey(fromId);
            notice.setActionFromUserName(fromUser.getUserName());
        }
        if(toId > 0){
            notice.setNoticeToUserId(toId);
            OggUser toUser = userMapper.selectByPrimaryKey(toId);
            notice.setNoticeToUserName(toUser.getUserName());
        }
        notice.setIsDelete(new Byte((byte) 0));
        notice.setReadStatus(new Byte((byte) 0));
        notice.setNoticeContent(notice.getActionFromUserName() + " 在" + notice.getCreateDateTime() + " 评论了你的文章");
        notice.setActionAccepter(accepterId);
        this.mapper.insert(notice);
        return new ObjectRestResponse().data("ok");

    }

}
