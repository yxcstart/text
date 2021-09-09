package com.hit.text.controller.advice;

import com.hit.text.utils.StudentUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author yang
 * @create 2021-09-08 23:18
 */
@ControllerAdvice(annotations = Controller.class)
public class ExceptionAdvice {


    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);


    @ExceptionHandler(Exception.class)
    public void handleException(Exception e, HttpServletResponse response, HttpServletRequest request) throws IOException {
        LOGGER.error("服务器发生异常:" + e.getMessage());
        for (StackTraceElement element : e.getStackTrace()) {
            LOGGER.error(element.toString());
        }
        String xRequestedWith = request.getHeader("x-requested-with");
        if ("XMLHttpRequest".equals(xRequestedWith)) {
            response.setContentType("application/plain;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.write(StudentUtils.getJSONString(1, "服务器异常！"));
        } else {
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
