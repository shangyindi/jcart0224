package com.shangyd.jcartstoreback.service;

import com.shangyd.jcartstoreback.po.Address;

import java.util.List;

public interface AddressService {
    Integer createAddress(Address address);

    List<Address> getCustomerAddress(Integer customerId);
}
