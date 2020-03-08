package com.shangyd.jcartstoreback.service.impl;

import com.shangyd.jcartstoreback.dao.AddressMapper;
import com.shangyd.jcartstoreback.dto.in.AddressUploadInDTO;
import com.shangyd.jcartstoreback.dto.out.AddressShowOutDTO;
import com.shangyd.jcartstoreback.po.Address;
import com.shangyd.jcartstoreback.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Integer createAddress(Address address) {
        Integer success = addressMapper.insertSelective(address);
        return success;
    }

    @Override
    public List<Address> getCustomerAddress(Integer customerId) {
        List<Address> addresses = addressMapper.getCustomerAddress(customerId);
        return addresses;
    }

    @Override
    @Transactional
    public AddressShowOutDTO getByAddress(Integer addressId) {
        Address address = addressMapper.selectByPrimaryKey(addressId);
        AddressShowOutDTO addressShowOutDTO = new AddressShowOutDTO();
        addressShowOutDTO.setAddressId(address.getAddressId());
        addressShowOutDTO.setContent(address.getContent());
        addressShowOutDTO.setReceiverMobile(address.getReceiverMobile());
        addressShowOutDTO.setReceiverName(address.getReceiverName());
        addressShowOutDTO.setTag(address.getTag());
        return addressShowOutDTO;
    }


    @Override
    @Transactional
    public void uploadAddress(AddressUploadInDTO addressUploadInDTO) {
        Address address = new Address();
        address.setTag(addressUploadInDTO.getTag());
        address.setReceiverName(addressUploadInDTO.getReceiverName());
        address.setReceiverMobile(addressUploadInDTO.getReceiverMobile());
        address.setContent(addressUploadInDTO.getContent());
        address.setAddressId(addressUploadInDTO.getAddressId());
        addressMapper.updateByPrimaryKeySelective(address);
    }
}
