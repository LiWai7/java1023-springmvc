package com.atguigu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * projectName: com.atguigu.controller
 *
 * @author: 赵伟风
 * description:
 */

@WebServlet("say/hello")
public class HelloController extends HttpServlet {

    /**
     * @param req  前端发送的信息,封装的请求对象 [请求行,请求头,请求体]
     * @param resp 后台向前端响应数据的对象,tomcat将resp转成响应数据格式传递给前端
     *
     *       前端---> 字符串(空格|换行) ---> [ tomcat ----> 字符串 ----> HttpServletRequest ] ----->  service (req)
     *             resp -----> tomcat -----> http响应字符串  -------> 前端
     *
     *       控制层  --- 表述层 ---- controller ---- [前台]
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 利用request对象获取前端的请求参数  [简化参数接收]
        //结束json数据
        //传统:
//        BufferedReader reader = req.getReader();
//        String json  = reader.readLine();
//        ObjectMapper objectMapper = new ObjectMapper(); //jackson
//        JavaPojo user =  objectMapper.xxxxxxx(json);
//
//        //框架 [ key = value  | json ]
//        service(@RequestBody JavaPojo user)
//
//        //2. 调用业务逻辑操作  [该咋整 还咋整]
//        xxxx();
//        //3. 利用response对象完成前端响应数据的封装 [简化数据响应]
//        //传统:
//        JavaPojo user;
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json  =  objectMapper.xxxxx(user);
//        resp.getWriter().print(json);
//
//        //框架
//        return user;

    }
}
