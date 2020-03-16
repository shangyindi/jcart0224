package com.shangyd.jcartadministrationback.service.Impl;

import com.shangyd.jcartadministrationback.dao.OrderHistoryMapper;
import com.shangyd.jcartadministrationback.service.OrderHistoryService;
import com.shangyd.jcartadministrationback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

    @Autowired
    private OrderHistoryMapper orderHistoryMapper;



}
