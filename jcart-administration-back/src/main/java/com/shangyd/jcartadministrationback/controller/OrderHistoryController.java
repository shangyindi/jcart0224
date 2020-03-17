package com.shangyd.jcartadministrationback.controller;

import com.shangyd.jcartadministrationback.dto.in.OrderHistoryCreateInDTO;
import com.shangyd.jcartadministrationback.dto.out.OrderHistoryListOutDTO;
import com.shangyd.jcartadministrationback.po.OrderHistory;
import com.shangyd.jcartadministrationback.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orderHistory")
@CrossOrigin
public class OrderHistoryController {

    @Autowired
    private OrderHistoryService orderHistoryService;

    @PostMapping("/create")
    public Long create(@RequestBody OrderHistoryCreateInDTO orderHistoryCreateInDTO){
        Long orderHistoryId = orderHistoryService.create(orderHistoryCreateInDTO);
        return orderHistoryId;
    }

    @GetMapping("/getByOrderList")
    public List<OrderHistoryListOutDTO> getByOrderList(Long orderId){
        List<OrderHistory> orderHistories = orderHistoryService.getByOrderList(orderId);
        List<OrderHistoryListOutDTO> orderHistoryListOutDTOS = orderHistories.stream().map(orderHistory -> {
            OrderHistoryListOutDTO orderHistoryListOutDTO = new OrderHistoryListOutDTO();
            orderHistoryListOutDTO.setOrderHistoryId(orderHistory.getOrderHistoryId());
            orderHistoryListOutDTO.setComment(orderHistory.getComment());
            orderHistoryListOutDTO.setCustomerNotified(orderHistory.getCustomerNotified());
            orderHistoryListOutDTO.setTimestamp(orderHistory.getTime().getTime());
            orderHistoryListOutDTO.setOrderStatus(orderHistory.getOrderStatus());
            return orderHistoryListOutDTO;
        }).collect(Collectors.toList());
        return orderHistoryListOutDTOS;
    }
}
