package com.shangyd.jcartstoreback.controller;

import com.shangyd.jcartstoreback.dto.in.AddressCreateInDTO;
import com.shangyd.jcartstoreback.po.Address;
import com.shangyd.jcartstoreback.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/create")
    public Integer createAddress(@RequestBody AddressCreateInDTO addressCreateInDTO , @RequestAttribute("customerId")Integer customerId){
        Address address = new Address();
        address.setContent(addressCreateInDTO.getContent());
        address.setCustomerId(customerId);
        address.setReceiverMobile(addressCreateInDTO.getReceiverMobile());
        address.setReceiverName(addressCreateInDTO.getReceiverName());
        address.setTag(addressCreateInDTO.getTag());
        Integer addressId = addressService.createAddress(address);
        return addressId;

    }
}
