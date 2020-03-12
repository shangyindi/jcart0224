package com.shangyd.jcartadministrationback.controller;

import com.github.pagehelper.Page;
import com.shangyd.jcartadministrationback.dto.in.OrderSearchInDTO;
import com.shangyd.jcartadministrationback.dto.out.OrderListOutDTO;
import com.shangyd.jcartadministrationback.dto.out.OrderShowOutDTO;
import com.shangyd.jcartadministrationback.dto.out.PageOutDTO;
import com.shangyd.jcartadministrationback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/search")
    public PageOutDTO<OrderListOutDTO> search(OrderSearchInDTO orderSearchInDTO, @RequestParam(required = false, defaultValue = "1") Integer pageNum){
        Page<OrderListOutDTO> page = orderService.search(pageNum,orderSearchInDTO);
        PageOutDTO<OrderListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setList(page);
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageNum(page.getPageNum());
        return pageOutDTO;
    }

    @GetMapping("/getByOrderId")
    public OrderShowOutDTO getByOrderId(@RequestParam("orderId")Long orderId){
        OrderShowOutDTO orderShowOutDTO = orderService.getByOrderId(orderId);
        return orderShowOutDTO;
    }
}
