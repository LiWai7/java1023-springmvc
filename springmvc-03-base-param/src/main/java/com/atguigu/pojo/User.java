package com.atguigu.pojo;

import lombok.Data;

/**
 * projectName: com.atguigu.pojo
 *
 * @author: 赵伟风
 * description:
 */

@Data
public class User {

    private String user_name;
    private String password;

    private Integer page = 1;

    private Integer size;
}
