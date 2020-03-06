package com.shangyd.jcartstoreback.service;

import com.github.pagehelper.Page;
import com.shangyd.jcartstoreback.dto.in.ProductCreateInDTO;
import com.shangyd.jcartstoreback.dto.in.ProductUploadInDTO;
import com.shangyd.jcartstoreback.dto.out.ProductListOutDTO;
import com.shangyd.jcartstoreback.dto.out.ProductShowOutDTO;

import java.util.List;

public interface ProductService {
    Integer create(ProductCreateInDTO productCreateInDTO);

    Page<ProductListOutDTO> search(Integer pageNum);

    void upload(ProductUploadInDTO productUploadInDTO);

    void delete(Integer productId);

    void batchdelete(List<Integer> productIds);

    ProductShowOutDTO getById(Integer productId);
}
