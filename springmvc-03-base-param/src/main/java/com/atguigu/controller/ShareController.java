package com.atguigu.controller;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

/**
 * projectName: com.atguigu.controller
 *
 * @author: 赵伟风
 * description: 获取三大共享域对象
 */


@SessionAttributes("key")
@RestController
@RequestMapping("share")
public class ShareController {


    @Autowired
    private ServletContext servletContext;

    //request session

    // handler 一次请求 request session
    @RequestMapping("data1")
    public String data1(HttpServletRequest request , HttpSession session){
        //servletContext
        return null;
    }

    @RequestMapping("data2")
    public String data1(HttpServletRequest request){
        HttpSession session = request.getSession();
        return null;
    }


    //application ServletContext [组件]  已经被加入到ioc容器!  全局唯一  不搭  handler


    //springmvc框架对共享域对象的一些其他扩展

    /**
     *
     * 原生方式:  我们 -> 原生对象 servletRequest | session | servletContext
     * 间接方式: 我们 ->  springmvc -> Map Model ModelMap (request)  -> 原生对象 servletRequest | session | servletContext
     *
     * 我们 -> 中通 \ 圆通 \ 申通 \ 韵达 \ 顺丰
     * 我们 -> 菜鸟驿站  -> 中通 \ 圆通 \ 申通 \ 韵达 \ 顺丰
     *
     */

    @RequestMapping("data3")
    public String data3( ModelMap modelMap){
        modelMap.addAttribute("key","value");
        return null;
    }


}
