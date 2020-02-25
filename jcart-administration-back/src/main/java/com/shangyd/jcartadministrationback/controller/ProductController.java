package com.shangyd.jcartadministrationback.controller;

import com.shangyd.jcartadministrationback.dto.in.ProductCreateOutDTO;
import com.shangyd.jcartadministrationback.dto.out.PageOutInfo;
import com.shangyd.jcartadministrationback.dto.out.ProductListOutDTO;
import org.springframework.web.bind.annotation.*;

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

    /**
     *
     * @param productCreateOutDTO
     * @return
     */
    @PostMapping("/create")
    public int create(@RequestBody ProductCreateOutDTO productCreateOutDTO){
        return 0;
    }
    

}
