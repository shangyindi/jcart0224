package com.shangyd.jcartadministrationback.controller;

import com.shangyd.jcartadministrationback.dto.out.CustomerListOutDTO;
import com.shangyd.jcartadministrationback.dto.out.PageOutInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    /**
     *
     * @param customerId
     * @return
     */
    @GetMapping("/getlist")
    public PageOutInfo<CustomerListOutDTO> getList(@RequestParam Integer customerId){
        return null;
    }

    @PostMapping("/create")
    public int create(){

    }

}
