package com.shangyd.jcartadministrationback.controller;

import com.shangyd.jcartadministrationback.dto.in.ProductCreateInDTO;
import com.shangyd.jcartadministrationback.dto.in.ProductUploadInDTO;
import com.shangyd.jcartadministrationback.dto.out.PageOutInfo;
import com.shangyd.jcartadministrationback.dto.out.ProductListOutDTO;
import com.shangyd.jcartadministrationback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    public PageOutInfo<ProductListOutDTO> search(@RequestParam Integer pageNum){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody ProductCreateInDTO productCreateInDTO){
        Integer productId = productService.create(productCreateInDTO);
        return productId;
    }

    @PostMapping("/upload")
    public void upload(@RequestBody ProductUploadInDTO productUploadInDTO){

    }
}
