package com.shangyd.jcartadministrationback.dao;

import com.github.pagehelper.Page;
import com.shangyd.jcartadministrationback.dto.out.ProductListOutDTO;
import com.shangyd.jcartadministrationback.po.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    Page<ProductListOutDTO> search();
}