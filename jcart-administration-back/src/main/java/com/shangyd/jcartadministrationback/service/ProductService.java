package com.shangyd.jcartadministrationback.service;

import com.shangyd.jcartadministrationback.dto.in.ProductCreateInDTO;

public interface ProductService {
    Integer create(ProductCreateInDTO productCreateInDTO);
}
