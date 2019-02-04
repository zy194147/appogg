package com.appogg.website.msg.auth;


import com.appogg.website.constant.RestCodeConstants;
import com.appogg.website.msg.BaseResponse;

/**
 * Created by ace on 2017/8/23.
 */
public class TokenErrorResponse extends BaseResponse {
    public TokenErrorResponse(String message) {
        super(RestCodeConstants.TOKEN_ERROR_CODE, message);
    }
}
