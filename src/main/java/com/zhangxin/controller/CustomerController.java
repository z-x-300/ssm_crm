package com.zhangxin.controller;


import com.zhangxin.service.BaseDictDaoService;
import com.zhangxin.vo.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 客户管理
 *
 * @author zx
 */

@Controller
public class CustomerController {

    @Autowired
    private BaseDictDaoService baseDictService;

    //入口
    @RequestMapping(value = "/customer/list")
    public String list(Model model) {

        List<BaseDict> fromType = baseDictService.selectBaseDictListByCode("002");
        List<BaseDict> industryType = baseDictService.selectBaseDictListByCode("001");
        List<BaseDict> levelType = baseDictService.selectBaseDictListByCode("006");

        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);

        return "customer";
    }
}