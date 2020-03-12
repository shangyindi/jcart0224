package com.shangyd.jcartadministrationback.dao;

import com.github.pagehelper.Page;
import com.shangyd.jcartadministrationback.dto.out.OrderListOutDTO;
import com.shangyd.jcartadministrationback.po.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Page<OrderListOutDTO> search(@Param("status") Byte status,
                                 @Param("orderId") Long orderId,
                                 @Param("customerName") String customerName,
                                 @Param("totalPrice") Double totalPrice,
                                 @Param("startTime")Date startTime,
                                 @Param("endTime") Date endTime);

    Order getByOrderId(Long orderId);
}