package com.shangyd.jcartstoreback.service.impl;

import com.shangyd.jcartstoreback.dao.OrderMapper;
import com.shangyd.jcartstoreback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private  OrderMapper orderMapper;


}
