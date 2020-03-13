package com.shangyd.jcartadministrationback.controller;

import com.shangyd.jcartadministrationback.dto.in.CustomerCreateInDTO;
import com.shangyd.jcartadministrationback.dto.out.CustomerListOutDTO;
import com.shangyd.jcartadministrationback.dto.out.PageOutDTO;
import com.shangyd.jcartadministrationback.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     *
     * @param customerId
     * @return
     */
    @GetMapping("/search")
    public PageOutDTO<CustomerListOutDTO> search(@RequestParam Integer customerId){
        return null;
    }

    /**
     *
     * @param customerCreateInDTO
     * @return
     */
    @PostMapping("/create")
    public int create(@RequestBody CustomerCreateInDTO customerCreateInDTO){
        return 0;
    }

    @GetMapping("/getById")
    public void getById(){

    }
}
