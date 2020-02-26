package com.shangyd.jcartadministrationback.service.Impl;

import com.shangyd.jcartadministrationback.dao.ProductDetailMapper;
import com.shangyd.jcartadministrationback.dao.ProductMapper;
import com.shangyd.jcartadministrationback.dto.in.ProductCreateInDTO;
import com.shangyd.jcartadministrationback.po.Product;
import com.shangyd.jcartadministrationback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductDetailMapper productDetailMapper;

    @Override
    public Integer create(ProductCreateInDTO productCreateInDTO) {
        Product product = new Product();
        product.setProductCode(productCreateInDTO.getProductCode());
        product.setProductName(productCreateInDTO.getProductName());
        product.setPrice(productCreateInDTO.getPrice());
        product.setDiscount(productCreateInDTO.getDiscount());
        product.setMainPicUrl(productCreateInDTO.getMainPicUrl());
        product.setRewordPoints(productCreateInDTO.getRewordPoints());
        product.setSortOrder(productCreateInDTO.getSortOrder());
        product.setStatus(productCreateInDTO.getStatus());
        String description = productCreateInDTO.getDescription();
        String substring = description.substring(0, Math.max(100, description.length()));
        product.setProductAbstract(substring);
        productMapper.insertSelective(product);
        
        return null;
    }
}
