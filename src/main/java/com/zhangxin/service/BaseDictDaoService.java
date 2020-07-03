package com.zhangxin.service;

import com.zhangxin.dao.BaseDictDao;
import com.zhangxin.vo.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDictDaoService {

    @Autowired
    private BaseDictDao baseDictDao;
    public List<BaseDict> selectBaseDictListByCode(String code) {
        return baseDictDao.selectBaseDictListByCode(code);
    }
}
