package com.zhangxin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 客户管理
 * @author zx
 */

@Controller
public class CustomerController  {

    //入口
    @RequestMapping(value ="/customer/list")
    public String list(){
        return "customer";
    }
}