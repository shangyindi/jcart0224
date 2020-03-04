package com.shangyd.jcartadministrationback.service.Impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shangyd.jcartadministrationback.dao.ProductDetailMapper;
import com.shangyd.jcartadministrationback.dao.ProductMapper;
import com.shangyd.jcartadministrationback.dto.in.ProductCreateInDTO;
import com.shangyd.jcartadministrationback.dto.in.ProductSearchInDTO;
import com.shangyd.jcartadministrationback.dto.in.ProductUploadInDTO;
import com.shangyd.jcartadministrationback.dto.out.ProductListOutDTO;
import com.shangyd.jcartadministrationback.dto.out.ProductShowOutDTO;
import com.shangyd.jcartadministrationback.po.Product;
import com.shangyd.jcartadministrationback.po.ProductDetail;
import com.shangyd.jcartadministrationback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductDetailMapper productDetailMapper;


    @Override
    @Transactional
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
        product.setProductAbstract(productCreateInDTO.getProductAbstract());
        product.setStockQuantity(productCreateInDTO.getStockQuantity());
        String description = productCreateInDTO.getDescription();
        String substring = description.substring(0, Math.min(100, description.length()));
        product.setProductAbstract(substring);
        productMapper.insertSelective(product);
        ProductDetail productDetail = new ProductDetail();
        Integer productId = product.getProductId();
        productDetail.setProductId(productId);
        List<String> otherPicUrls = productCreateInDTO.getOtherPicUrls();
        productDetail.setOtherPicUrls(JSON.toJSONString(otherPicUrls));
        productDetail.setDescription(productCreateInDTO.getDescription());
        productDetailMapper.insertSelective(productDetail);
        return productId;
    }

    @Override
    @Transactional
    public Page<ProductListOutDTO> search(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        Page<ProductListOutDTO> page = productMapper.search();
        return page;
    }

    @Override
    @Transactional
    public void upload(ProductUploadInDTO productUploadInDTO) {
        Product product = new Product();
        product.setProductName(productUploadInDTO.getProductName());
        product.setProductId(productUploadInDTO.getProductId());
        product.setPrice(productUploadInDTO.getPrice());
        product.setDiscount(productUploadInDTO.getDiscount());
        product.setMainPicUrl(productUploadInDTO.getMainPicUrl());
        product.setRewordPoints(productUploadInDTO.getRewordPoints());
        product.setSortOrder(productUploadInDTO.getSortOrder());
        product.setStatus(productUploadInDTO.getStatus());
        product.setStockQuantity(productUploadInDTO.getStockQuantity());
        String description = productUploadInDTO.getDescription();
        String substring = description.substring(0, Math.min(100, description.length()));
        product.setProductAbstract(substring);
        productMapper.updateByPrimaryKeySelective(product);
        ProductDetail productDetail = new ProductDetail();
        List<String> otherPicUrls = productUploadInDTO.getOtherPicUrls();
        productDetail.setOtherPicUrls(JSON.toJSONString(otherPicUrls));
        productDetail.setDescription(productDetail.getDescription());
        productDetail.setProductId(productDetail.getProductId());
        productDetailMapper.updateByPrimaryKeySelective(productDetail);
    }

    @Override
    @Transactional
    public void delete(Integer productId) {
        productMapper.deleteByPrimaryKey(productId);
        productDetailMapper.deleteByPrimaryKey(productId);
    }

    @Override
    @Transactional
    public void batchdelete(List<Integer> productIds) {
        productMapper.batchdelete(productIds);
        productDetailMapper.batchdelete(productIds);
    }

    @Override
    @Transactional
    public ProductShowOutDTO getById(Integer productId) {
        ProductShowOutDTO productShowOutDTO= new ProductShowOutDTO();
        Product product = productMapper.selectByPrimaryKey(productId);
        ProductDetail productDetail = productDetailMapper.selectByPrimaryKey(productId);
        productShowOutDTO.setDescription(productDetail.getDescription());
        productShowOutDTO.setMainPicUrl(product.getMainPicUrl());
        productShowOutDTO.setPrice(product.getPrice());
        productShowOutDTO.setProductId(product.getProductId());
        productShowOutDTO.setProductCode(product.getProductCode());
        productShowOutDTO.setProductName(product.getProductName());
        productShowOutDTO.setProductAbstract(product.getProductAbstract());
        productShowOutDTO.setStatus(product.getStatus());
        productShowOutDTO.setSortOrder(product.getSortOrder());
        productShowOutDTO.setRewordPoints(product.getRewordPoints());
        productShowOutDTO.setStockQuantity(product.getStockQuantity());
        productShowOutDTO.setDiscount(product.getDiscount());
        String otherPicUrls = productDetail.getOtherPicUrls();
        List<String> strings = JSON.parseArray(otherPicUrls, String.class);
        productShowOutDTO.setOtherPicUrls(strings);
        return productShowOutDTO;
    }

}
