package com.shangyd.jcartstoreback.controller;

import com.shangyd.jcartstoreback.dto.in.OrderCheckoutInDTO;
import com.shangyd.jcartstoreback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/checkout")
    public Long checkout(@RequestBody OrderCheckoutInDTO checkoutInDTO, @RequestAttribute("customerId")Integer customerId){
        Long orderId = orderService.checkout(checkoutInDTO,customerId);
        return orderId;
    }
}
