package com.atguigu.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * projectName: com.atguigu.controller
 *
 * @author: 赵伟风
 * description: handler返回的是一个视图页面  jsp
 *
 *
 * 注意： 想要返回一个模板页面
 *     步骤1： 导入对应的依赖
 *     步骤2： 配置对应的视图解析器（spring）,指定共有的前缀和后缀
 *     步骤3： handler返回字符串值，值是中间部分地址！
 *     注意：  handler不要被@ResponseBody修饰 【修饰了 就不走视图解析器，直接将数据放在响应体，返回给客户端！】
 *
 * 跳转技术：
 *     转发和重定向
 *     //转发
 *     request.getRequestDispatcher("转发地址").forward(request,response);
 *     转发地址： 项目下的相对地址不要写项目根路径  /jsp/jump
 *     //重定向
 *     response.sendRedirect("重定向地址");
 *     重定向： 是全地址或者简化地址  http://localhost:8080/app/jsp/jump
 *                                  /app/jsp/jump
 *
 *     springmvc
 *       1. 返回的返回值还是String
 *       2. 方法不要被@ResponseBody
 *       3. 转发： return "forward:/转发地址"  重定向： return "redirect: /重定向地址";;
 *       注意： 地址都是项目下的地址
 */

@Controller
@RequestMapping("jsp")
public class JspController {


    @RequestMapping("forward")
    public String data1(){
        System.out.println("JspController.data1");
        return "forward:/jsp/jump";
    }


    @RequestMapping("redirect")
    public String data2(){
        System.out.println("JspController.data2");
        return "redirect:/jsp/jump";
    }

    @RequestMapping("baidu")
    public String data3(){
        System.out.println("JspController.data3");
        return "redirect:http://www.baidu.com";
    }




    //jsp/jump -》 handler -> login.jsp  [request -> key]

    @ResponseBody
    @RequestMapping("jump")
    public String jumpJsp(HttpServletRequest request){
        request.setAttribute("key","heiheihei");
        return "login";
    }


    @RequestMapping("index")
    public String jumpIndex(){
        System.out.println("JspController.jumpIndex");
        return "user/index";
    }

}
