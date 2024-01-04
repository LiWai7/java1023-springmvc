package com.atguigu.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * projectName: com.atguigu.controller
 *
 * @author: 赵伟风
 * description: 练习接收cookie和请求头
 */

@RestController
@RequestMapping("other")
public class OtherController {


    //接收请求头
    /**
     * User-Agent Host
     * 细节1: 不会自动拼接 -
     * 细节2: 会自动忽略大小写
     */
    @RequestMapping("data1")
    public String data1(@RequestHeader( "user-agent") String userAgent, @RequestHeader String host){
        System.out.println("OtherController.data1");
        System.out.println("userAgent = " + userAgent + ", host = " + host);
        return "userAgent = " + userAgent + ", host = " + host;
    }

    //接收cookie

    //存储cookie
    @RequestMapping("save")
    public String save(HttpServletResponse response){

        Cookie cookie = new Cookie("user","admin");
        response.addCookie(cookie);

        return "cookie save success!!";
    }


    /**
     * handler(param , path , [json] , requestHeader , cookie)
     *
     * @param user
     * @return
     */

    @RequestMapping("get")
    public String getCookie(@CookieValue String user){

        System.out.println("OtherController.getCookie");
        System.out.println("user = " + user);

        return "user = " + user;
    }


}
