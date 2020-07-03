package com.zhangxin.controller;


import com.zhangxin.service.BaseDictDaoService;
import com.zhangxin.service.CustomerService;
import com.zhangxin.utils.Page;
import com.zhangxin.vo.BaseDict;
import com.zhangxin.vo.Customer;
import com.zhangxin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Autowired
    private CustomerService customerService;

    //注解在成员变量上
    @Value("${fromType.code}")
    private String fromTypeCode;

    @Value("${industryType.code}")
    private String industryTypeCode;

    @Value("${levelType.code}")
    private String levelTypeCode;

    //入口
    @RequestMapping(value = "/customer/list")
    public String list(QueryVo vo, Model model) {

        List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
        List<BaseDict> industryType = baseDictService.selectBaseDictListByCode(industryTypeCode);
        List<BaseDict> levelType = baseDictService.selectBaseDictListByCode(levelTypeCode);

        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);

        //通过四个条件查询分页对象
        Page<Customer> page = customerService.selectPageByQueryVo(vo);
        model.addAttribute("page", page);
        model.addAttribute("custName", vo.getCustName());
        model.addAttribute("custSource", vo.getCustSource());
        model.addAttribute("custIndustry", vo.getCustIndustry());
        model.addAttribute("custLevel", vo.getCustLevel());
        return "customer";
    }

    //去修改页面
    @RequestMapping(value="/customer/edit.action")
    @ResponseBody
    public Customer edit(Integer id){
        Customer customer =new Customer();
        customer =customerService.selectCustomerById(id);
        return customer;

    }

    //修改
    @RequestMapping(value="/customer/update.action")
    @ResponseBody
    public String update(Customer customer){
        customerService.updateCustomer(customer);
        return "OK";

    }

    //删除
    @RequestMapping(value="/customer/delete.action")
    @ResponseBody
    public String delete(Integer id){
        customerService.deleteCustomerById(id);
        return "OK";

    }
}