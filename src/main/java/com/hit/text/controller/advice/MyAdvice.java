package com.hit.text.controller.advice;

import com.hit.text.dao.SQLMapper;
import com.hit.text.entity.SQLStatement;
import com.hit.text.utils.SqlUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yang
 * @create 2021-09-08 23:51
 */
@Component
@Aspect
public class MyAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyAdvice.class);
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    private SQLMapper sqlMapper;

    /**
     * 定义切点
     */
    @Pointcut("@annotation(com.hit.text.annotation.ModelSubmit)")
    private void pc() {
    }

    /**
     * 指定该方法是前置通知，并指定切入点
     */
    @Before("MyAdvice.pc()")
    public void before() {
    }

    /**
     * 后置通知
     */
    @AfterReturning("MyAdvice.pc()")
    public void afterReturning() {
    }

    /**
     * 环绕通知
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("MyAdvice.pc()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 1.调用目标方法
        Object proceed = pjp.proceed();
        // 2.获取SQL
        String sql = SqlUtils.getMybatisSql(pjp, sqlSessionFactory);
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        String namespace = method.getDeclaringClass().getName();
        String methodName = method.getName();
        // 3.打印SQL语句到日志文件
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return null;
        }
        HttpServletRequest request = attributes.getRequest();
        String ip = request.getRemoteHost();
        int port = request.getRemotePort();
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        LOGGER.info(String.format("用户[%s],在[%s]执行了", ip+":"+port, time)+"[SQL语句 {}.{}]： {}}", namespace, methodName, sql);
        // 4.保存SQL语句到数据库
        SQLStatement statement = new SQLStatement(time, ip, port, sql);
        sqlMapper.insertSql(statement);
        // 5.通知同步程序
        return proceed;
    }

    /**
     * 异常通知
     */
    @AfterThrowing("MyAdvice.pc()")
    public void afterException() {
    }

    /**
     * 后置通知
     */
    @After("MyAdvice.pc()")
    public void after() {
    }

}
