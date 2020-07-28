package com.own.annotation.aspect;

import com.own.domain.Log;
import com.own.utils.RequestHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 类功能说明:
 * 类修改者	创建日期2020/7/28
 * 修改说明
 *
 * @author wzy
 * @version V1.0
 **/
@Slf4j
@Aspect
@Component
public class LogAspect {

    ThreadLocal<Long> currentTime = new ThreadLocal<>();
    /**
     * 配置切入点
     */
    @Pointcut("@annotation(com.own.annotation.Log)")
    public void logPointcut(){
        //   该方法无方法体,主要为了让同类中其他方法使用此切入点

    }
    /**
     * 配置环绕通知,使用在方法logPointcut()上注册的切入点
     * @param joinPoint join point for advice
     */
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        Object result;
        currentTime.set(System.currentTimeMillis());
        result = joinPoint.proceed();
        Log info = new Log("INFO", System.currentTimeMillis() - currentTime.get());
        currentTime.remove();
        HttpServletRequest request = RequestHolder.getHttpServletRequest();
//        logService.save(getUsername(), StringUtils.getBrowser(request), StringUtils.getIp(request),joinPoint, log);
        return result;
    }
}
