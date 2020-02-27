package com.shangyd.jcartadministrationback.service;

import com.github.pagehelper.Page;
import com.shangyd.jcartadministrationback.dto.in.ProductCreateInDTO;
import com.shangyd.jcartadministrationback.dto.in.ProductUploadInDTO;
import com.shangyd.jcartadministrationback.dto.out.ProductListOutDTO;

import java.util.List;

public interface ProductService {
    Integer create(ProductCreateInDTO productCreateInDTO);

    Page<ProductListOutDTO> search(Integer pageNum);

    void upload(ProductUploadInDTO productUploadInDTO);

    void delete(Integer productId);

    void batchdelete(List<Integer> productIds);
}
