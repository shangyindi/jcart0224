package com.shangyd.jcartadministrationback.service.Impl;

import com.shangyd.jcartadministrationback.dao.CustomerMapper;
import com.shangyd.jcartadministrationback.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;



}
