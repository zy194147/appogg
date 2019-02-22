package com.appogg.website.biz.user;

import com.alibaba.fastjson.JSONObject;
import com.appogg.website.biz.BaseBiz;
import com.appogg.website.biz.token.TokenBiz;
import com.appogg.website.entity.OggArticle;
import com.appogg.website.entity.OggUser;
import com.appogg.website.mapper.OggUserMapper;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.util.Query;
import com.appogg.website.util.RedisUtils;
import com.appogg.website.util.SerializeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

@Service
public class OggUserBiz extends BaseBiz<OggUserMapper,OggUser> {

    @Resource
    private RedisUtils redisUtils;

    @Autowired
    TokenBiz tokenBiz;

    public ObjectRestResponse userLogin(OggUser user){

        JSONObject jsonObject=new JSONObject();
        OggUser userForBase=this.mapper.selectByUserName(user.getUserName());
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return new ObjectRestResponse().data(jsonObject);
        }else {
            if (!userForBase.getUserPassword().equals(user.getUserPassword())){
                jsonObject.put("message","登录失败,密码错误");
                return new ObjectRestResponse().data(jsonObject);
            }else {
                String token = tokenBiz.getToken(userForBase);
                try{
                    String userString = SerializeUtils.serialize(userForBase);
                    System.out.println("序列字符串:" + userString);
                    try{
                        OggUser user1 = (OggUser)SerializeUtils.serializeToObject(userString);
                        System.out.println("序列字duixiang:" + user1);
                    } catch (ClassNotFoundException e){
                        e.printStackTrace();
                    }
                    redisUtils.set(token, userString);
                } catch (IOException e){
                    jsonObject.put("message","登录失败,序列化对象失败");
                    return new ObjectRestResponse().data(jsonObject);
                }
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);

                return new ObjectRestResponse().data(jsonObject);
            }
        }
    }

    public ObjectRestResponse selectUserDetail(Query query){
        int userId = 0;
        OggUser user = null;
        Example example = new Example(OggUser.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("userId".equals(entry.getKey())) {
                        userId = Integer.parseInt(entry.getValue().toString());
                    }
                }
            }
            if(userId != 0){
                user = this.mapper.selectByPrimaryKey(userId);
            }
        }
        return new ObjectRestResponse().rel(true).data(user);
    }

}
