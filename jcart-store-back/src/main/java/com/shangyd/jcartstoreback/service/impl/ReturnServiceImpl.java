package com.shangyd.jcartstoreback.service.impl;

import com.shangyd.jcartstoreback.dao.ReturnMapper;
import com.shangyd.jcartstoreback.po.Return;
import com.shangyd.jcartstoreback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnServiceImpl implements ReturnService {

    @Autowired
    private ReturnMapper returnMapper;


    @Override
    public void create(Return returned) {
        returnMapper.insertSelective(returned);
    }
}
