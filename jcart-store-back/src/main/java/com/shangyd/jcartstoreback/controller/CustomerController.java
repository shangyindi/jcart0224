package com.shangyd.jcartstoreback.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.shangyd.jcartstoreback.dto.in.CustomerCreateInDTO;
import com.shangyd.jcartstoreback.dto.out.CustomerListOutDTO;
import com.shangyd.jcartstoreback.dto.out.PageOutDTO;
import com.shangyd.jcartstoreback.dto.out.CustomerListOutDTO;
import com.shangyd.jcartstoreback.dto.out.PageOutDTO;
import com.shangyd.jcartstoreback.po.Customer;
import com.shangyd.jcartstoreback.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

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

    @PostMapping("/register")
    public Integer register(@RequestBody CustomerCreateInDTO customerCreateInDTO){
        Customer customer = new Customer();
        customer.setCreateTime(new Date());
        customer.setEmail(customerCreateInDTO.getEmail());
        customer.setMobile(customerCreateInDTO.getMobile());
        customer.setNewsSubscribed(customerCreateInDTO.getNewsSubscribed());
        customer.setUsername(customerCreateInDTO.getUsername());
        customer.setRealName(customerCreateInDTO.getRealName());
        customer.setStatus(customerCreateInDTO.getStatus());
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, customerCreateInDTO.getPassword().toCharArray());
        customer.setEncryptedPassword(bcryptHashString);
        Integer customerId = customerService.register(customer);
        return customerId;
    }
}