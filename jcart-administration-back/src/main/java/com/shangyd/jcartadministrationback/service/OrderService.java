package com.shangyd.jcartadministrationback.service;

import com.github.pagehelper.Page;
import com.shangyd.jcartadministrationback.dto.in.OrderSearchInDTO;
import com.shangyd.jcartadministrationback.dto.out.OrderListOutDTO;
import com.shangyd.jcartadministrationback.dto.out.OrderShowOutDTO;
import com.shangyd.jcartadministrationback.dto.out.PageOutDTO;

public interface OrderService {
    Page<OrderListOutDTO> search(Integer pageNum, OrderSearchInDTO orderSearchInDTO);

    OrderShowOutDTO getByOrderId(Long orderId);
}
