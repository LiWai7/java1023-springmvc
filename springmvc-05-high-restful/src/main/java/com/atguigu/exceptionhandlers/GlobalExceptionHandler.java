package com.atguigu.exceptionhandlers;

import com.atguigu.utils.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.net.PortUnreachableException;

/**
 * projectName: com.atguigu.exceptionhandlers
 *
 * @author: 赵伟风
 * description: 项目的所有异常都来我这,我统一处理
 */



@RestControllerAdvice
//@ResponseBody
//@ControllerAdvice //异常都会先访问你
public class GlobalExceptionHandler {


    //handler -> 异常类型
    @ExceptionHandler(NullPointerException.class)
    public R nullPointExceptionHandler(NullPointerException e , HttpServletRequest request){
        System.out.println(e.getMessage());
        return R.fail(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public R exceptionHandler(Exception e){
        System.out.println(e.getMessage());
        return R.fail(e.getMessage());
    }


}
