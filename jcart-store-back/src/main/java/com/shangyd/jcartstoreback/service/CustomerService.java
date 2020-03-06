package com.shangyd.jcartstoreback.service;

import com.github.pagehelper.Page;
import com.shangyd.jcartstoreback.dto.out.CustomerListOutDTO;
import com.shangyd.jcartstoreback.po.Customer;

public interface CustomerService {
    Integer register(Customer customer);

    Page<CustomerListOutDTO> search(Integer pageNum);

    Customer login(String username);
}
