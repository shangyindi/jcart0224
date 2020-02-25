package com.shangyd.jcartadministrationback.controller;

import com.shangyd.jcartadministrationback.dto.out.PageOutInfo;
import com.shangyd.jcartadministrationback.dto.out.ProductListOutDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    /**
     *
     * @param pageNum
     * @return
     */
    @GetMapping("/getlist")
    public PageOutInfo<ProductListOutDTO> getList(@RequestParam Integer pageNum){
        return null;
    }


}
