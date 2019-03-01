package com.appogg.website.controller.soft;

import com.appogg.website.annotation.UserLoginToken;
import com.appogg.website.biz.soft.OggSoftBiz;
import com.appogg.website.entity.OggSoft;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.rest.BaseController;
import com.appogg.website.util.Query;
import com.appogg.website.vo.soft.SoftVO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/soft")
public class OggSoftController extends BaseController<OggSoftBiz,OggSoft> {

    @UserLoginToken
    @PostMapping("add")
    public ObjectRestResponse insertSoft(@RequestBody SoftVO softVO){
        return this.baseBiz.insertSoftMsg(softVO);
    }

    @GetMapping("list")
    public TableResultResponse listSoft(@RequestParam Map<String,Object> params){
        Query query = new Query(params);
        return this.baseBiz.listPublicSoftMsg(query);
    }


    @GetMapping("detail")
    public ObjectRestResponse selectArticleDetail(@RequestParam Map<String,Object> params){
        Query query = new Query(params);
        return  this.baseBiz.selectSoftDetail(query);
    }
    @GetMapping("updateReadNum")
    public ObjectRestResponse uploadArticleReadNum(@RequestParam Map<String,Object> params){
        Query query = new Query(params);
        return  this.baseBiz.updateSoftReadNum(query);
    }
}
