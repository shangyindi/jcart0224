package com.shangyd.jcartadministrationback.controller;

import com.github.pagehelper.Page;
import com.shangyd.jcartadministrationback.dto.in.CustomerCreateInDTO;
import com.shangyd.jcartadministrationback.dto.in.CustomerSearchInDTO;
import com.shangyd.jcartadministrationback.dto.out.CustomerListOutDTO;
import com.shangyd.jcartadministrationback.dto.out.PageOutDTO;
import com.shangyd.jcartadministrationback.po.Customer;
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
     * @param pageNum
     * @return
     */
    @GetMapping("/search")
    public PageOutDTO<CustomerListOutDTO> search(CustomerSearchInDTO customerSearchInDTO, @RequestParam(defaultValue = "1",required = false) Integer pageNum){
        Page<Customer> page = customerService.search(customerSearchInDTO,pageNum);
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
