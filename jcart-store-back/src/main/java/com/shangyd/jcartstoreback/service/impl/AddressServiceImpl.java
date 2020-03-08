package com.shangyd.jcartstoreback.service.impl;

import com.shangyd.jcartstoreback.dao.AddressMapper;
import com.shangyd.jcartstoreback.po.Address;
import com.shangyd.jcartstoreback.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Integer createAddress(Address address) {
        Integer success = addressMapper.insertSelective(address);
        return success;
    }
}
