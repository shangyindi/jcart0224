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

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
@CrossOrigin
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
        List<CustomerListOutDTO> pageOutDTO = page.stream().map(customer -> {
            CustomerListOutDTO customerListOutDTO = new CustomerListOutDTO();
            customerListOutDTO.setCustomerId(customer.getCustomerId());
            customerListOutDTO.setEmail(customer.getEmail());
            customerListOutDTO.setStatus(customer.getStatus());
            customerListOutDTO.setMobile(customer.getMobile());
            customerListOutDTO.setRealName(customer.getRealName());
            customerListOutDTO.setUsername(customer.getUsername());
            customerListOutDTO.setCreateTimestamp(customer.getCreateTime().getTime());
            return  customerListOutDTO;
        }).collect(Collectors.toList());
        PageOutDTO<CustomerListOutDTO> customerListOutDTOPageOutDTO =new PageOutDTO<>();
        customerListOutDTOPageOutDTO.setTotal(page.getTotal());
        customerListOutDTOPageOutDTO.setPageNum(page.getPageNum());
        customerListOutDTOPageOutDTO.setPageSize(page.getPageSize());
        customerListOutDTOPageOutDTO.setList(pageOutDTO);
        return customerListOutDTOPageOutDTO;
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
