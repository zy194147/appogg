package com.appogg.website.exception.auth;


import com.appogg.website.constant.CommonConstants;
import com.appogg.website.exception.BaseException;

/**
 * Created by ace on 2017/9/8.
 */
public class UserTokenException extends BaseException {
    public UserTokenException(String message) {
        super(message, CommonConstants.EX_USER_INVALID_CODE);
    }
}
