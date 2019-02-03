package com.appogg.website.biz;

import com.appogg.website.entity.Hello;
import com.appogg.website.mapper.HelloMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloBiz {


    @Autowired
    private HelloMapper helloMapper;



    public String say(){
        return "这里是biz";
    }
    public String say1(){
        return helloMapper.selectByPrimaryKey(1).toString();
    }
    public List<Hello> say2(){
        return helloMapper.selectAll();
    }
}
