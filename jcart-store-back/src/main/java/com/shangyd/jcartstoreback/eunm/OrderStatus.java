package com.shangyd.jcartstoreback.eunm;

public enum  OrderStatus {
    //待处理
    ToProcess,
    //处理中
    Processing,
    //带发货
    ToShip,
    //已发货
    Shipped,
    //待签收
    ToRecevice,
    //取消
    Cancel,
    //待评价
    TocComment,
    //已评价
    Commented
}
