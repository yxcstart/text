package com.hit.text.annotation;

import java.lang.annotation.*;

/**
 * @author yang
 * @create 2021-09-08 23:43
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ModelSubmit {
    //只是一个标记，获取mybatis执行的SQL语句的注解
}
