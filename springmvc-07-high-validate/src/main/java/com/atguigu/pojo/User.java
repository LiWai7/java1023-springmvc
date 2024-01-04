package com.atguigu.pojo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * projectName: com.atguigu.pojo
 *
 * @author: 赵伟风
 * description:
 *
 * 账号不能为null和" "
 * 密码是6-14位
 * 年龄大于18
 * 生日必须是过去时间
 */
@Data
public class User {

    @NotBlank
    private String account;

    //[]
    @Length(min = 6,max = 14)
    private String password;

    @Min(value = 19,message = "哈哈哈，太小了，不能看！不好！")
    private int age;

    @Past
    private Date birthday;
}
