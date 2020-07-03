package com.zhangxin.dao;

import com.zhangxin.vo.BaseDict;

import java.util.List;

public interface BaseDictDao {
    //查询
    public List<BaseDict> selectBaseDictListByCode(String code);
}
