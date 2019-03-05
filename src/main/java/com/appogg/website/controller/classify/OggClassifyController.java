package com.appogg.website.controller.classify;

import com.appogg.website.annotation.UserLoginToken;
import com.appogg.website.biz.classify.OggClassifyBiz;
import com.appogg.website.entity.OggClassify;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.rest.BaseController;
import com.appogg.website.util.Query;
import com.appogg.website.vo.classify.ClassifyVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/classify/")
public class OggClassifyController extends BaseController<OggClassifyBiz,OggClassify> {

    @GetMapping("list")
    public TableResultResponse listClassify(@RequestParam Map<String,Object> params){
        Query query = new Query(params);
        return this.baseBiz.listClassify(query);
    }
    @UserLoginToken
    @PostMapping("add")
    public ObjectRestResponse addClassify(@RequestBody ClassifyVO classifyVO){
        return this.baseBiz.addClassify(classifyVO);
    }

}
