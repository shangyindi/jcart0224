package com.shangyd.jcartstoreback.service.impl;

import com.shangyd.jcartstoreback.dao.AddressMapper;
import com.shangyd.jcartstoreback.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

}
