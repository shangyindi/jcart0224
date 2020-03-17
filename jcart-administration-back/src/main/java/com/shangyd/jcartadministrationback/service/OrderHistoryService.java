package com.shangyd.jcartadministrationback.service;

import com.shangyd.jcartadministrationback.dto.in.OrderHistoryCreateInDTO;
import com.shangyd.jcartadministrationback.po.OrderHistory;

import java.util.List;

public interface OrderHistoryService {
    Long create(OrderHistoryCreateInDTO orderHistoryCreateInDTO);

    List<OrderHistory> getByOrderList(Long orderId);
}
