package com.appogg.website.exception.auth;


import com.appogg.website.constant.CommonConstants;
import com.appogg.website.exception.BaseException;

/**
 * Created by ace on 2017/9/10.
 */
public class ClientTokenException extends BaseException {
    public ClientTokenException(String message) {
        super(message, CommonConstants.EX_CLIENT_INVALID_CODE);
    }
}
