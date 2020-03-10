package com.shangyd.jcartstoreback.dto.in;

import java.util.List;

public class OrderCheckoutInDTO {
    private Long orderId;
    private Short shipMethod;
    private Integer shipAddressId;
    private Double shipPrice;
    private Short payMethod;
    private Integer invoiceAddressId;
    private Double invoicePrice;
    private String comment;
    private List<OrderProductInDTO> orderProducts;

    public Short getShipMethod() {
        return shipMethod;
    }

    public void setShipMethod(Short shipMethod) {
        this.shipMethod = shipMethod;
    }

    public Double getShipPrice() {
        return shipPrice;
    }

    public void setShipPrice(Double shipPrice) {
        this.shipPrice = shipPrice;
    }

    public Short getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Short payMethod) {
        this.payMethod = payMethod;
    }

    public Double getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(Double invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<OrderProductInDTO> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProductInDTO> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getInvoiceAddressId() {
        return invoiceAddressId;
    }

    public void setInvoiceAddressId(Integer invoiceAddressId) {
        this.invoiceAddressId = invoiceAddressId;
    }

    public Integer getShipAddressId() {
        return shipAddressId;
    }

    public void setShipAddressId(Integer shipAddressId) {
        this.shipAddressId = shipAddressId;
    }
}
