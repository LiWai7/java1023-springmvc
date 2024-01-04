package com.atguigu.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * projectName: com.atguigu.interceptors
 *
 * @author: 赵伟风
 * description:
 *    步骤1： 创建一个类 实现 拦截器接口 HandlerInterceptor
 *    步骤2： 选择拦截方法进行实现
 *    步骤3： ioc配置文件中声明
 *            <mvc:interceptors
 */
public class UserInterceptor  implements HandlerInterceptor {

    /**
     * 时机：在调用handler之前   handlerAdapter -->  preHandler() ----> handler()
     * 作用：验证和拦截
     * 返回值： boolean true -> 放行  false -> 拦截 【配合转发或者重定向】
     * 参数： 请求 ， 响应对象 ， handler就是要调用的目标方法
     *
     * filter -> doFilter
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("UserInterceptor.preHandle");
        System.out.println("request = " + request + ", response = " + response + ", handler = " + handler);
        return true;
    }

    /**
     * 时机：在调用handler之后   handler() -->  postHandler() ----> handlerAdapter
     * 作用：进行结果的校验和赛选 例如：敏感字检查等等
     * 参数： 请求 ， 响应对象 ， handler就是要调用的目标方法 ， modelAndView 返回的视图页面包裹的对象 返回的是json@ResponseBody修饰，这个参数为null
     *
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("UserInterceptor.postHandle");
        System.out.println("request = " + request + ", response = " + response + ", handler = " + handler + ", modelAndView = " + modelAndView);
    }


    /**
     * 时机：在调用handlerAdapter之后   handlerAdapter --> afterCompletion ---->  ds（ceo）
     * 作用：进行结果的校验和赛选 例如：敏感字检查\异常的后置检查！！！
     * 参数： 请求 ， 响应对象 ， handler就是要调用的目标方法  异常对象
     *
     * postHandle() 目标handler() 不报错，他执行！
     * afterCompletion() 目标的handler() 报不报错都执行！！
     *
     *
     *
     * try{
     *     preHandler()
     *     handler()
     *     postHandler()
     * }catch(){
     *
     * }finally{
     *    afterCompletion()
     * }
     *
     *
     *
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("UserInterceptor.afterCompletion");
        System.out.println("request = " + request + ", response = " + response + ", handler = " + handler + ", ex = " + ex);
    }

}













