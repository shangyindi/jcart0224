package com.shangyd.jcartadministrationback.service;

import com.shangyd.jcartadministrationback.dto.in.OrderHistoryCreateInDTO;

public interface OrderHistoryService {
    Long create(OrderHistoryCreateInDTO orderHistoryCreateInDTO);
}
