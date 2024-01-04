package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * projectName: com.atguigu.controller
 *
 * @author: 赵伟风
 * description:
 *
 * 用户controller有两个功能,一个用户登录 , 用户注册
 *
 *
 */


@RequestMapping("user")
@ResponseBody
@Controller
public class UserController {

    /**
     *
     *  技术1: 如何将handler注册到handlerMapping中
     *
     *  实现: @RequestMapping(路径) 将我们handler注册到handlerMapping
     *        只有注册的handler才可以被外部访问
     *  细节1: 具体路径 @RequestMapping(value | path = {"路径1","路径2"})
     *         /user/login  [user/login]  /user/login/  user/login/
     *         /user/register
     *         注意: 开头的/可以省略
     *
     *  细节2: 模糊路径
     *         *  单层任意字符串  /user/*  -> /user/a  /user/aaa  /user/aaaaaaaaa  /user/a/a [不能]
     *         ** 多层任意字符串  /user/** -> /user/a  /user/aaa  /user/aaaaaaaaa  /user/a/a /user
     *
     *  细节3: 配置位置问题
     *         @Target({ElementType.TYPE, ElementType.METHOD})
     *         方法必须添加,类上可以选择添加,类上添加的作用就是[提取类下的通用地址]
     *         访问handler地址: 类 + 方法
     *         返回用户信息  /user
     *
     *  细节4: 请求方式限制
     *        @RequestMapping("login")  默认允许任何请求方式请求 [get post delete put....]
     *        method = {请求方式,....}
     *
     *  细节5: 扩展请求方式限制注解 (细节4升级)
     *        @PostMapping  = @RequestMapping(method = RequestMethod.POST)
     *        @GetMapping
     *        @PutMapping
     *        注意: 只能加到方法上!!!
     *
     */


    //handler2
    //@RequestMapping(value = "login",method = RequestMethod.POST)
    // ||
    @PostMapping("login")
    public String login(){
        System.out.println("UserController.login");
        return "login success!!";
    }
    //handler1
    //@RequestMapping(value = "register",method = RequestMethod.GET)
    @GetMapping("register")
    public String register(){
        System.out.println("UserController.register");
        return "register success!!";
    }

    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
//    @GetMapping
//    @PostMapping
    public String showUser(){
        System.out.println("UserController.showUser");
        return "showUser success!!";
    }

}
