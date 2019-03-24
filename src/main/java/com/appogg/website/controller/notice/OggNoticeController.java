package com.appogg.website.controller.notice;

import com.appogg.website.biz.notice.OggNoticeBiz;
import com.appogg.website.entity.OggNotice;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.rest.BaseController;
import com.appogg.website.util.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/notice/")
public class OggNoticeController extends BaseController<OggNoticeBiz,OggNotice> {


//    @GetMapping("listNotice")
//    public TableResultResponse listCommentNotice(@RequestParam Map<String,Object> params){
//        Query query = new Query(params);
//        return this.baseBiz.listNotice(query);
//
//    }

    @GetMapping("noticeTotal")
    public ObjectRestResponse getNoticeTotal(@RequestParam Map<String,Object> params){
        Query query = new Query(params);
        return this.baseBiz.getNotReadNoticeTotal(query);
    }

    @GetMapping("noticeList")
    public ObjectRestResponse listCommentNotice(@RequestParam Map<String,Object> params){
        Query query = new Query(params);
        return this.baseBiz.listCommentNotice(query);
    }
    @GetMapping("setRead")
    public ObjectRestResponse setCommentNoticeRead(@RequestParam Map<String,Object> params){
        Query query = new Query(params);
        return this.baseBiz.setCommentNoticeRead(query);
    }

}
