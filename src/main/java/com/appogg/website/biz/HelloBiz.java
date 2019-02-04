package com.appogg.website.biz;

import com.appogg.website.entity.Hello;
import com.appogg.website.mapper.HelloMapper;
import com.appogg.website.msg.ObjectRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloBiz extends BaseBiz<HelloMapper,Hello> {

    public ObjectRestResponse say1(){
        return new ObjectRestResponse().data(this.mapper.selectByPrimaryKey(2));
    }
    public ObjectRestResponse say2(){
        return new ObjectRestResponse().data(this.mapper.selectAll());
    }
}
