package com.shangyd.jcartstoreback.dto.in;

import java.util.List;

public class OrderCheckoutInDTO {
    private Short shipMethod;
    private String shipAddress;
    private Double shipPrice;
    private Short payMethod;
    private String invoiceAddress;
    private Double invoicePrice;
    private String comment;
    private List<OrderProductInDTO> orderProducts;
}
