package com.shangyd.jcartstoreback.service;

import com.shangyd.jcartstoreback.dto.in.OrderCheckoutInDTO;

public interface OrderService {
    Long checkout(OrderCheckoutInDTO checkoutInDTO, Integer customerId);

}
