package com.shangyd.jcartadministrationback.controller;

import com.shangyd.jcartadministrationback.dto.in.OrderHistoryCreateInDTO;
import com.shangyd.jcartadministrationback.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
