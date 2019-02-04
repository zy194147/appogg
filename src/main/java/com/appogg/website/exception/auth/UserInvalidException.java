package com.appogg.website.exception.auth;


import com.appogg.website.constant.CommonConstants;
import com.appogg.website.exception.BaseException;

/**
 * Created by ace on 2017/9/8.
 */
public class UserInvalidException extends BaseException {
    public UserInvalidException(String message) {
        super(message, CommonConstants.EX_USER_PASS_INVALID_CODE);
    }
}
