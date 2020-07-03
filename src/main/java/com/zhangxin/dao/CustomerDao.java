package com.zhangxin.dao;

import com.zhangxin.vo.Customer;
import com.zhangxin.vo.QueryVo;

import java.util.List;

public interface CustomerDao {
    //总条数
    public Integer customerCount(QueryVo vo);
    //结果集
    public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
}
