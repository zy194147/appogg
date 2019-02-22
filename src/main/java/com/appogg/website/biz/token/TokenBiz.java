package com.appogg.website.biz.token;

import com.appogg.website.entity.OggUser;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;


@Service("TokenService")
public class TokenBiz {
    public String getToken(OggUser user) {
        String token="";
        token= JWT.create().withAudience(user.getId().toString())// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(user.getUserPassword()));// 以 password 作为 token 的密钥
        return token;
    }
}
