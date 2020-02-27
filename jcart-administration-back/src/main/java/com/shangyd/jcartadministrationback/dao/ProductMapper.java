package com.shangyd.jcartadministrationback.dao;

import com.github.pagehelper.Page;
import com.shangyd.jcartadministrationback.dto.out.ProductListOutDTO;
import com.shangyd.jcartadministrationback.po.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    Page<ProductListOutDTO> search();

    void batchdelete(@Param("productIds") List<Integer> productIds);
}