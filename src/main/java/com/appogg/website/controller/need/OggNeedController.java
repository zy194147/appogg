package com.appogg.website.controller.need;

import com.appogg.website.annotation.UserLoginToken;
import com.appogg.website.biz.need.OggNeedBiz;
import com.appogg.website.entity.OggNeed;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.rest.BaseController;
import com.appogg.website.util.Query;
import com.appogg.website.vo.need.NeedVo;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/need/")
public class OggNeedController extends BaseController<OggNeedBiz,OggNeed> {

    @UserLoginToken
    @PostMapping("add")
    public ObjectRestResponse insertNeed(@RequestBody NeedVo needVo){
        return this.baseBiz.insertNeedMsg(needVo);
    }

    @GetMapping("list")
    public TableResultResponse listPublicNeed(@RequestParam Map<String,Object> params){
        Query query = new Query(params);
        return this.baseBiz.listPublicNeedMsg(query);
    }
    @GetMapping("detail")
    public ObjectRestResponse selectNeedDetail(@RequestParam Map<String,Object> params){
        Query query = new Query(params);
        return  this.baseBiz.selectNeedDetail(query);
    }

}
