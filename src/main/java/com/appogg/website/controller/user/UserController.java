package com.appogg.website.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.appogg.website.annotation.UserLoginToken;
import com.appogg.website.biz.token.TokenBiz;
import com.appogg.website.biz.user.OggUserBiz;
import com.appogg.website.entity.OggUser;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.rest.BaseController;
import com.appogg.website.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/user/")
public class UserController extends BaseController<OggUserBiz,OggUser> {

    //登录
    @PostMapping("/login")
    public ObjectRestResponse login(@RequestBody OggUser user){

        return this.baseBiz.userLogin(user);
    }
    //登出
    @GetMapping("/logout")
    public ObjectRestResponse logout(HttpServletRequest request){


        System.out.println("deng出");
        return this.baseBiz.userLogout(request);
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }

    @RequestMapping("detail")
    public ObjectRestResponse userDetail(@RequestParam Map<String,Object> params){
        System.out.println("userddddddddddddddddddd");
        Query query = new Query(params);
        return this.baseBiz.selectUserDetail(query);

    }




}
