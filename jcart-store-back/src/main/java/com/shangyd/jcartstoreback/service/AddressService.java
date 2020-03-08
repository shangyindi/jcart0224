package com.shangyd.jcartstoreback.service;

import com.shangyd.jcartstoreback.dto.in.AddressUploadInDTO;
import com.shangyd.jcartstoreback.dto.out.AddressShowOutDTO;
import com.shangyd.jcartstoreback.po.Address;

import java.util.List;

public interface AddressService {
    Integer createAddress(Address address);

    List<Address> getCustomerAddress(Integer customerId);

    AddressShowOutDTO getByAddress(Integer addressId);

    void uploadAddress(AddressUploadInDTO addressUploadInDTO);
}
