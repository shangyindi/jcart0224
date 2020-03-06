package com.shangyd.jcartstoreback.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shangyd.jcartstoreback.dao.CustomerMapper;
import com.shangyd.jcartstoreback.dto.out.CustomerListOutDTO;
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

    @Override
    public Page<CustomerListOutDTO> search(Integer pageNum) {
        PageHelper.startPage(1,10);
        Page<CustomerListOutDTO> page = customerMapper.search(pageNum);
        return page;
    }

    @Override
    public Customer login(String username) {
        Customer customer = customerMapper.login(username);
        return customer;
    }
}
