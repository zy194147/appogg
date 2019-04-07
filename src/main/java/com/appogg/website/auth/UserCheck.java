package com.appogg.website.auth;

import com.appogg.website.entity.OggUser;
import com.appogg.website.util.RedisUtils;
import com.appogg.website.util.SerializeUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Component
public class UserCheck {
    @Resource
    private RedisUtils redisUtils;
    public OggUser getLoginUser(HttpServletRequest request){

        String token = request.getHeader("Authorization");// 从 http 请求头中取出 token
        if(token == null){
            return null;
        }
        String userObject = redisUtils.get(token);
        OggUser submitUser = new OggUser();
        try{
            submitUser = (OggUser) SerializeUtils.serializeToObject(userObject);
        } catch (Exception e){
            e.printStackTrace();
        }
        return submitUser;
    }
}
