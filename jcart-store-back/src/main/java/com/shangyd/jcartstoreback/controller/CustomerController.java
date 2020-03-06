package com.shangyd.jcartstoreback.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.github.pagehelper.Page;
import com.shangyd.jcartstoreback.constant.ClientExceptionConstant;
import com.shangyd.jcartstoreback.dto.in.CustomerCreateInDTO;
import com.shangyd.jcartstoreback.dto.in.CustomerLoginInDTO;
import com.shangyd.jcartstoreback.dto.out.AdministrationLoginOutDTO;
import com.shangyd.jcartstoreback.dto.out.CustomerListOutDTO;
import com.shangyd.jcartstoreback.dto.out.CustomerLoginOutDTO;
import com.shangyd.jcartstoreback.dto.out.PageOutDTO;
import com.shangyd.jcartstoreback.exception.ClientException;
import com.shangyd.jcartstoreback.po.Customer;
import com.shangyd.jcartstoreback.service.CustomerService;
import com.shangyd.jcartstoreback.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
     JWTUtil jwtUtil;

    @GetMapping("/search")
    public PageOutDTO<CustomerListOutDTO> search(@RequestParam(defaultValue = "1",required = false) Integer pageNum){
        Page<CustomerListOutDTO> customerListOutDTOS = customerService.search(pageNum);
        PageOutDTO<CustomerListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setList(customerListOutDTOS);
        pageOutDTO.setPageNum(customerListOutDTOS.getPageNum());
        pageOutDTO.setPageSize(customerListOutDTOS.getPageSize());
        pageOutDTO.setTotal(customerListOutDTOS.getTotal());
        return pageOutDTO;
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
        customer.setUsername(customerCreateInDTO.getUsername());
        customer.setRealName(customerCreateInDTO.getRealName());
        customer.setStatus(customerCreateInDTO.getStatus());
        customer.setNewsSubscribed(customerCreateInDTO.getNewsSubscribed());
        customer.setRewordPoints(0);
        customer.setMobileVerified(false);
        customer.setEmailVerified(false);
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, customerCreateInDTO.getPassword().toCharArray());
        customer.setEncryptedPassword(bcryptHashString);
        Integer register = customerService.register(customer);
        return register;
    }

    @GetMapping("/login")
    public CustomerLoginOutDTO login(CustomerLoginInDTO customerLoginInDTO) throws ClientException {
        Customer customer = customerService.login(customerLoginInDTO.getUsername());
        if(customer == null){
            throw new ClientException(ClientExceptionConstant.ADMINISTRATOR_USERNAME_NOT_EXIST_ERRCODE, ClientExceptionConstant.ADMINISTRATOR_USERNAME_NOT_EXIST_ERRMSG);
        }
        String encPwdDB = customer.getEncryptedPassword();
        BCrypt.Result result = BCrypt.verifyer().verify(customerLoginInDTO.getPassword().toCharArray(), encPwdDB);
        if (result.verified) {
            CustomerLoginOutDTO customerLoginOutDTO = jwtUtil.issueToken(customer);
            return customerLoginOutDTO;
        }else {
            throw new ClientException(ClientExceptionConstant.ADNINISTRATOR_PASSWORD_INVALID_ERRCODE, ClientExceptionConstant.ADNINISTRATOR_PASSWORD_INVALID_ERRMSG);
        }

    }
}
