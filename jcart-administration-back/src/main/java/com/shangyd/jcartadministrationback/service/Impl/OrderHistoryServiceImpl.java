package com.shangyd.jcartadministrationback.service.Impl;

import com.shangyd.jcartadministrationback.dao.OrderHistoryMapper;
import com.shangyd.jcartadministrationback.dto.in.OrderHistoryCreateInDTO;
import com.shangyd.jcartadministrationback.po.OrderHistory;
import com.shangyd.jcartadministrationback.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

    @Autowired
    private OrderHistoryMapper orderHistoryMapper;


    @Override
    @Transactional
    public Long create(OrderHistoryCreateInDTO orderHistoryCreateInDTO) {
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setComment(orderHistoryCreateInDTO.getComment());
        orderHistory.setCustomerNotified(orderHistoryCreateInDTO.getCustomerNotified());
        orderHistory.setOrderId(orderHistoryCreateInDTO.getOrderId());
        orderHistory.setOrderStatus(orderHistoryCreateInDTO.getOrderStatus());
        orderHistory.setTime(new Date());
        orderHistoryMapper.insertSelective(orderHistory);
        Long orderHistoryId = orderHistory.getOrderHistoryId();
        return orderHistoryId;
    }
}
