package com.shangyd.jcartstoreback.service.impl;

import com.alibaba.fastjson.JSON;
import com.shangyd.jcartstoreback.dao.OrderDetailMapper;
import com.shangyd.jcartstoreback.dao.OrderMapper;
import com.shangyd.jcartstoreback.dto.in.OrderCheckoutInDTO;
import com.shangyd.jcartstoreback.dto.in.OrderProductInDTO;
import com.shangyd.jcartstoreback.dto.out.AddressShowOutDTO;
import com.shangyd.jcartstoreback.dto.out.ProductShowOutDTO;
import com.shangyd.jcartstoreback.eunm.OrderStatus;
import com.shangyd.jcartstoreback.po.Order;
import com.shangyd.jcartstoreback.po.OrderDetail;
import com.shangyd.jcartstoreback.po.Product;
import com.shangyd.jcartstoreback.service.AddressService;
import com.shangyd.jcartstoreback.service.OrderService;
import com.shangyd.jcartstoreback.service.ProductService;
import com.shangyd.jcartstoreback.vo.OrderProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private  OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    private AddressService addressService;

    @Override
    @Transactional
    public Long checkout(OrderCheckoutInDTO checkoutInDTO, Integer customerId) {
        List<OrderProductInDTO> orderProducts = checkoutInDTO.getOrderProducts();
        List<OrderProductVO> orderProductVOS = orderProducts.stream().map(orderProductInDTO -> {
            Product orderProduct = productService.getProduct(orderProductInDTO.getProductId());
            OrderProductVO orderProductVO = new OrderProductVO();
            orderProductVO.setProductId(orderProductInDTO.getProductId());
            orderProductVO.setQuantity(orderProductInDTO.getQuantity());
            double unitPrice = orderProduct.getPrice() * orderProduct.getDiscount();
            orderProductVO.setUnitPrice(unitPrice);
            double totalPrice = unitPrice * orderProductInDTO.getQuantity();
            orderProductVO.setTotalPrice(totalPrice);
            orderProductVO.setProductCode(orderProduct.getProductCode());
            orderProductVO.setProductName(orderProduct.getProductName());
            orderProductVO.setUnitRewordPoints(orderProduct.getRewordPoints());
            //单品的总积分  商品 积分 *  数量
            Integer totalRewordPoints = orderProduct.getRewordPoints() * orderProductInDTO.getQuantity();
            orderProductVO.setTotalRewordPoints(totalRewordPoints);
            return orderProductVO;
        }).collect(Collectors.toList());
        //总价
        double AllTotalPrice = orderProductVOS.stream().mapToDouble(p -> p.getTotalPrice()).sum();
        int AllTotalRewordPoints = orderProductVOS.stream().mapToInt(p -> p.getTotalRewordPoints()).sum();

        Order order = new Order();
        order.setCustomerId(customerId);
        order.setStatus((byte)OrderStatus.ToProcess.ordinal());
        //设置总价
        order.setTotalPrice(AllTotalPrice);
        //设置积分
        order.setRewordPoints(AllTotalRewordPoints);
        Date now = new Date();
        order.setCreateTime(now);
        order.setUpdateTime(now);
        orderMapper.insertSelective(order);
        OrderDetail orderDetail = new OrderDetail();
        Long orderId = order.getOrderId();
        System.out.println(orderId);
        orderDetail.setOrderId(orderId);
        orderDetail.setShipMethod(checkoutInDTO.getShipMethod());
        // todo calculate shipMethod price
        orderDetail.setShipPrice(9.0);
        Integer addressId = checkoutInDTO.getShipAddressId();
        AddressShowOutDTO address = addressService.getByAddress(addressId);
        orderDetail.setShipAddress(address.getContent());
        orderDetail.setPayMethod(checkoutInDTO.getPayMethod());
        Integer invoiceAddressId = checkoutInDTO.getInvoiceAddressId();
        AddressShowOutDTO address1 = addressService.getByAddress(invoiceAddressId);
        orderDetail.setInvoiceAddress(address1.getContent());
        orderDetail.setInvoicePrice(AllTotalPrice);
        orderDetail.setComment(checkoutInDTO.getComment());
        // todo orderProductVOS
        orderDetail.setOrderProducts(JSON.toJSONString(orderProductVOS));
        orderDetailMapper.insertSelective(orderDetail);
        return orderId;
    }
}
