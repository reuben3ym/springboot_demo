package com.reuben.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: springboot_demo
 * @description: params for page
 * @author: reuben
 * @create: 2020-03-20 18:36
 **/
@Data//get,set方法
@AllArgsConstructor//全参构造
@NoArgsConstructor//无参构造
public class PageParam {
    private User user;
    private Integer pageNum;
    private Integer pageSize;

}
