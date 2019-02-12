package com.appogg.website.controller.user;

import com.appogg.website.biz.user.OggUserBiz;
import com.appogg.website.entity.OggUser;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.rest.BaseController;
import com.appogg.website.util.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user/")
public class UserController extends BaseController<OggUserBiz,OggUser> {

    @RequestMapping("detail")
    public ObjectRestResponse userDetail(@RequestParam Map<String,Object> params){
        Query query = new Query(params);
        return this.baseBiz.selectUserDetail(query);

    }
}
