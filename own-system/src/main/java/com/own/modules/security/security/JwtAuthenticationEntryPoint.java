package com.own.modules.security.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 类功能说明: 用来解决匿名用户访问无权限资源时的异常
 * 类修改者	创建日期2020/7/28
 * 修改说明
 *
 * @author wzy
 * @version V1.0
 **/
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
             // 当用户尝试访问安全的REST资源而不提供任何凭据时，将调用此方法发送401 响应
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,e == null ? "Unauthorized":e.getMessage());
    }
}
