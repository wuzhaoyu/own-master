package com.own.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 类功能说明: 获取 HttpServletRequest
 * 类修改者	创建日期2020/7/28
 * 修改说明
 *
 * @author wzy
 * @version V1.0
 **/
public class RequestHolder {

    public static HttpServletRequest getHttpServletRequest(){
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

}
