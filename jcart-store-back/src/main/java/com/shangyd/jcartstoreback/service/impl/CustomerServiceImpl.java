package com.shangyd.jcartstoreback.service.impl;

import com.shangyd.jcartstoreback.dao.CustomerMapper;
import com.shangyd.jcartstoreback.po.Customer;
import com.shangyd.jcartstoreback.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private  CustomerMapper customerMapper;

    @Override
    public Integer register(Customer customer) {
        int insertSelective = customerMapper.insertSelective(customer);
        return insertSelective;
    }
}
