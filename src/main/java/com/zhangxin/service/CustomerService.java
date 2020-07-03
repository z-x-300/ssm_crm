package com.zhangxin.service;

import com.zhangxin.dao.CustomerDao;
import com.zhangxin.utils.Page;
import com.zhangxin.vo.Customer;
import com.zhangxin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;
    //通过四个条件查询分页对象
    public Page<Customer> selectPageByQueryVo(QueryVo vo){
        Page<Customer> customerPage =new Page<Customer>();
        //每页数
        customerPage.setSize(5);
        vo.setSize(5);
        if (vo !=null) {
            //判断当前页
            if (vo.getPage() != null) {
                customerPage.setPage(vo.getPage());
                vo.setStartRow((vo.getPage()-1)*vo.getSize());
            }
            if(vo.getCustName()!=null&&vo.getCustName().trim().equals("")){
                vo.setCustName(vo.getCustName().trim());
            }
            if(vo.getCustSource()!=null&&vo.getCustSource().trim().equals("")){
                vo.setCustSource(vo.getCustSource().trim());
            }
            if(vo.getCustIndustry()!=null&&vo.getCustIndustry().trim().equals("")){
                vo.setCustIndustry(vo.getCustIndustry().trim());
            }
            if(vo.getCustLevel()!=null&&vo.getCustLevel().trim().equals("")){
                vo.setCustLevel(vo.getCustLevel().trim());
            }
            //总条数
            customerPage.setTotal(customerDao.customerCount(vo));
            customerPage.setRows(customerDao.selectCustomerListByQueryVo(vo));
        }

        return customerPage;
    }

    public Customer selectCustomerById(Integer id){
        return customerDao.selectCustomerById(id);
    }
}
