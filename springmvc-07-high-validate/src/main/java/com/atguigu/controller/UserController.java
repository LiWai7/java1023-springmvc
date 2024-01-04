package com.atguigu.controller;

import com.atguigu.pojo.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * projectName: com.atguigu.controller
 *
 * @author: 赵伟风
 * description:
 *
 * 参数校验实现：
 *     步骤1： 导入hibernate的依赖
 *     步骤2： 实体属性添加校验注解  @NotNull @NotEmpty @NotBlank @Min @Max @Length @Past @Future
 *     步骤3： 形成列表接收，并且开启校验  handler( @Validated 对象)
 * 结果处理：
 *     失败处理 -》 业务失败 --》 利用状态码处理  --》 R status = 200 | status = 300
 *     BindingResult result 获取本次校验结果！ 正确或者错误！
 *     注意：BindingResult 必须紧紧的挨着校验的实体对象
 *
 */

@RestController
@RequestMapping("user")
public class UserController {


    @PostMapping("/login")
    public Object login(@Validated @RequestBody User user, BindingResult result,HttpSession session){
        if (result.hasErrors()) {
            //result.hasErrors() 获取绑定结果 true 有错误 ， false没错误
            Map data= new HashMap();
            data.put("status","300");
            data.put("msg","参数校验失败！");
            return data;
        }

        System.out.println("user = " + user);
        System.out.println("UserController.login");
        return user;
    }

}
