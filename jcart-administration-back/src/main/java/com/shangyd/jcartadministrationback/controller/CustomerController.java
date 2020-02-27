package com.shangyd.jcartadministrationback.controller;

import com.shangyd.jcartadministrationback.dto.in.CustomerCreateInDTO;
import com.shangyd.jcartadministrationback.dto.out.CustomerListOutDTO;
import com.shangyd.jcartadministrationback.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

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

}
