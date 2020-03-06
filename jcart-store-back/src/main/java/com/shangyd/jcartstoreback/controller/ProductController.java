package com.shangyd.jcartstoreback.controller;

import com.github.pagehelper.Page;
import com.shangyd.jcartstoreback.dto.in.ProductCreateInDTO;
import com.shangyd.jcartstoreback.dto.in.ProductSearchInDTO;
import com.shangyd.jcartstoreback.dto.in.ProductUploadInDTO;
import com.shangyd.jcartstoreback.dto.out.PageOutDTO;
import com.shangyd.jcartstoreback.dto.out.ProductListOutDTO;
import com.shangyd.jcartstoreback.dto.out.ProductShowOutDTO;
import com.shangyd.jcartstoreback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO, @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<ProductListOutDTO> page = productService.search(pageNum);
        PageOutDTO<ProductListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(page);
        return pageOutDTO;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody ProductCreateInDTO productCreateInDTO){
        Integer productId = productService.create(productCreateInDTO);
        return productId;
    }

    @PostMapping("/update")
    public void upload(@RequestBody ProductUploadInDTO productUploadInDTO){
        productService.upload(productUploadInDTO);
    }

    @PostMapping("/delete")
    public void delete(@RequestParam Integer productId){
        productService.delete(productId);
    }

    @PostMapping("/batchdelete")
    public void batchdelete(@RequestBody List<Integer> productIds){
        productService.batchdelete(productIds);
    }

    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){
        ProductShowOutDTO productShowOutDTO = productService.getById(productId);
        return productShowOutDTO;
    }
}
