package com.appogg.website.controller;

import com.appogg.website.biz.HelloBiz;
import com.appogg.website.entity.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hello/")
public class HelloController {

    @Autowired
    private HelloBiz helloBiz;

    @RequestMapping("say")
    public String hello(){
        String bizString = helloBiz.say1();
//        List<Hello> hellos = helloBiz.say2();
        return "哈哈哈哈。。。" + bizString;
    }

}
