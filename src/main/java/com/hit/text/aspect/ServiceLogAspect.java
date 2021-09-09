package com.hit.text.aspect;

import com.hit.text.dao.HttpMapper;
import com.hit.text.entity.Http;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yang
 * @create 2021-09-08 23:18
 */
@Component
@Aspect
public class ServiceLogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceLogAspect.class);
    @Autowired
    private HttpMapper httpMapper;

    @Pointcut("execution(* com.hit.text.service.*.*(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return;
        }
        HttpServletRequest request = attributes.getRequest();
        String ip = request.getRemoteHost();
        int port = request.getRemotePort();
        String requestURI = request.getRequestURI();
        String connection = request.getHeader("Connection");
        String encoding = request.getHeader("Accept-Encoding");
        String accept = request.getHeader("Accept");
        String protocol = request.getProtocol();
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String target = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Http http = new Http(time, ip, port, requestURI, protocol, connection, encoding, accept, target);
        httpMapper.insertHttp(http);
        LOGGER.info(String.format("用户[%s],在[%s]，访问了[%s].", ip, time, target));
    }
}
