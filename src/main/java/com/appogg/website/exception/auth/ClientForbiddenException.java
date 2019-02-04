package com.appogg.website.exception.auth;


import com.appogg.website.constant.CommonConstants;
import com.appogg.website.exception.BaseException;

/**
 * Created by ace on 2017/9/12.
 */
public class ClientForbiddenException extends BaseException {
    public ClientForbiddenException(String message) {
        super(message, CommonConstants.EX_CLIENT_FORBIDDEN_CODE);
    }

}
