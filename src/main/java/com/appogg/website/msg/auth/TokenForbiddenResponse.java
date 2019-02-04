package com.appogg.website.msg.auth;


import com.appogg.website.constant.RestCodeConstants;
import com.appogg.website.msg.BaseResponse;

/**
 * Created by ace on 2017/8/25.
 */
public class TokenForbiddenResponse  extends BaseResponse {
    public TokenForbiddenResponse(String message) {
        super(RestCodeConstants.TOKEN_FORBIDDEN_CODE, message);
    }
}
