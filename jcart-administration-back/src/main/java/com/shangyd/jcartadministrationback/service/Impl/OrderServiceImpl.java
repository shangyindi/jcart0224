package com.shangyd.jcartadministrationback.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shangyd.jcartadministrationback.dao.CustomerMapper;
import com.shangyd.jcartadministrationback.dao.OrderDetailMapper;
import com.shangyd.jcartadministrationback.dao.OrderMapper;
import com.shangyd.jcartadministrationback.dto.in.OrderSearchInDTO;
import com.shangyd.jcartadministrationback.dto.out.OrderListOutDTO;
import com.shangyd.jcartadministrationback.dto.out.OrderShowOutDTO;
import com.shangyd.jcartadministrationback.po.Customer;
import com.shangyd.jcartadministrationback.po.Order;
import com.shangyd.jcartadministrationback.service.CustomerService;
import com.shangyd.jcartadministrationback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Page<OrderListOutDTO> search(Integer pageNum, OrderSearchInDTO orderSearchInDTO) {
        PageHelper.startPage(pageNum,10);
        Page<OrderListOutDTO> page = orderMapper.search(
                orderSearchInDTO.getStatus(),
                orderSearchInDTO.getOrderId(),
                orderSearchInDTO.getCustomerName(),
                orderSearchInDTO.getTotalPrice(),
                orderSearchInDTO.getStartTimestamp() == null ? null : new Date(orderSearchInDTO.getStartTimestamp()),
                orderSearchInDTO.getEndTimestamp() == null ? null : new Date(orderSearchInDTO.getEndTimestamp()));
        return page;
    }

    @Override
    @Transactional
    public OrderShowOutDTO getByOrderId(Long orderId) {
        Order order = orderMapper.getByOrderId(orderId);
        OrderShowOutDTO orderShowOutDTO = new OrderShowOutDTO();
        orderShowOutDTO.setCreateTime(order.getCreateTime());
        orderShowOutDTO.setOrderId(order.getOrderId());
        orderShowOutDTO.setUpdateTime(order.getUpdateTime());
        orderShowOutDTO.setTotalPrice(order.getTotalPrice());
        Customer customer = customerMapper.selectByPrimaryKey(order.getCustomerId());
        orderShowOutDTO.setEmail(customer.getEmail());
        orderShowOutDTO.setCustomerId(customer.getCustomerId());
        orderShowOutDTO.setMobile(customer.getMobile());
        orderShowOutDTO.setRealName(customer.getRealName());

        return orderShowOutDTO;
    }
}
