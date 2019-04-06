package com.appogg.website.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.appogg.website.annotation.UserLoginToken;
import com.appogg.website.biz.token.TokenBiz;
import com.appogg.website.biz.user.OggUserBiz;
import com.appogg.website.entity.OggUser;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
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


    //注册
    @PostMapping("/signUp")
    public ObjectRestResponse signUp(@RequestBody OggUser user){
        return this.baseBiz.userSignUp(user);
    }
    //检测用户名是否已被注册
    @PostMapping("/checkNameExist")
    public ObjectRestResponse checkNameExist(@RequestBody OggUser user){
        return this.baseBiz.checkNameExist(user);
    }






    //检测用户名是否已被注册
    @PostMapping("/updateMsg")
    public ObjectRestResponse updateUserMsg(@RequestBody OggUser user){
        return this.baseBiz.updateUserMsg(user);
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


    @GetMapping("listArticle")
    public TableResultResponse listArticles(@RequestParam Map<String,Object> params){
        Query query = new Query(params);
        return this.baseBiz.listArticles(query);
    }


    @GetMapping("listSoft")
    public TableResultResponse listSofts(@RequestParam Map<String,Object> params){
        Query query = new Query(params);
        return this.baseBiz.listSofts(query);
    }


    @GetMapping("listNeed")
    public TableResultResponse listNeeds(@RequestParam Map<String,Object> params){
        Query query = new Query(params);
        return this.baseBiz.listNeeds(query);
    }




}
