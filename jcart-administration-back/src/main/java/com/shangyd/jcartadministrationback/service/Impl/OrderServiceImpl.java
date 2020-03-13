package com.shangyd.jcartadministrationback.service.Impl;

import com.alibaba.fastjson.JSON;
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
import com.shangyd.jcartadministrationback.po.OrderDetail;
import com.shangyd.jcartadministrationback.service.CustomerService;
import com.shangyd.jcartadministrationback.service.OrderService;
import com.shangyd.jcartadministrationback.vo.OrderProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
        Customer customer = customerMapper.selectByPrimaryKey(order.getCustomerId());
        OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(orderId);
        OrderShowOutDTO orderShowOutDTO = new OrderShowOutDTO();
        orderShowOutDTO.setOrderId(orderId);
        orderShowOutDTO.setCustomerId(order.getCustomerId());
        orderShowOutDTO.setCustomerName(customer.getRealName());
        orderShowOutDTO.setStatus(order.getStatus());
        orderShowOutDTO.setTotalPrice(order.getTotalPrice());
        orderShowOutDTO.setRewordPoints(order.getRewordPoints());
        orderShowOutDTO.setCreateTimestamp(order.getCreateTime().getTime());
        orderShowOutDTO.setUpdateTimestamp(order.getUpdateTime().getTime());

        orderShowOutDTO.setShipMethod(orderDetail.getShipMethod());
        orderShowOutDTO.setShipAddress(orderDetail.getShipAddress());
        orderShowOutDTO.setShipPrice(orderDetail.getShipPrice());
        orderShowOutDTO.setPayMethod(orderDetail.getPayMethod());
        orderShowOutDTO.setInvoiceAddress(orderDetail.getInvoiceAddress());
        orderShowOutDTO.setInvoicePrice(orderDetail.getInvoicePrice());
        orderShowOutDTO.setComment(orderDetail.getComment());

        List<OrderProductVO> orderProductVOS = JSON.parseArray(orderDetail.getOrderProducts(), OrderProductVO.class);
        orderShowOutDTO.setOrderProducts(orderProductVOS);
        return orderShowOutDTO;
    }
}
