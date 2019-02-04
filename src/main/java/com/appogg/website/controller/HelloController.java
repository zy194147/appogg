package com.appogg.website.controller;

import com.appogg.website.biz.HelloBiz;
import com.appogg.website.entity.Hello;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.rest.BaseController;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/hello/")
public class HelloController extends BaseController<HelloBiz,Hello> {


    @RequestMapping("say")
    public ObjectRestResponse hello(HttpServletResponse response){
//        response.setHeader("Access-Control-Allow-Origin", "*");
        ObjectRestResponse objectRestResponse = this.baseBiz.say2();
//        List<Hello> hellos = helloBiz.say2();
        return objectRestResponse;
    }

}
