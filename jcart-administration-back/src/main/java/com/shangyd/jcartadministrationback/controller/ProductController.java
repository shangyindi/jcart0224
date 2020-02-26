package com.shangyd.jcartadministrationback.controller;

import com.shangyd.jcartadministrationback.dto.in.ProductCreateInDTO;
import com.shangyd.jcartadministrationback.dto.in.ProductUploadInDTO;
import com.shangyd.jcartadministrationback.dto.out.PageOutInfo;
import com.shangyd.jcartadministrationback.dto.out.ProductListOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/search")
    public PageOutInfo<ProductListOutDTO> search(@RequestParam Integer pageNum){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody ProductCreateInDTO productCreateInDTO){
        return null;
    }

    @PostMapping("/upload")
    public void upload(@RequestBody ProductUploadInDTO productUploadInDTO){

    }
}
