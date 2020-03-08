package com.shangyd.jcartstoreback.controller;

import com.github.pagehelper.Page;
import com.shangyd.jcartstoreback.dto.in.AddressCreateInDTO;
import com.shangyd.jcartstoreback.dto.out.AddressListOutDTO;
import com.shangyd.jcartstoreback.dto.out.PageOutDTO;
import com.shangyd.jcartstoreback.po.Address;
import com.shangyd.jcartstoreback.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/getCustomerAddress")
    public List<AddressListOutDTO> getCustomerAddress(@RequestAttribute("customerId")Integer customerId){
        List<Address> addresses = addressService.getCustomerAddress(customerId);
        List<AddressListOutDTO> addressListOutDTOS = addresses.stream().map(address -> {
            AddressListOutDTO addressListOutDTO = new AddressListOutDTO();
            addressListOutDTO.setAddressId(address.getAddressId());
            addressListOutDTO.setContent(address.getContent());
            addressListOutDTO.setReceiverMobile(address.getReceiverMobile());
            addressListOutDTO.setReceiverName(address.getReceiverName());
            addressListOutDTO.setTag(address.getTag());
            return  addressListOutDTO;
        }).collect(Collectors.toList());
        return  addressListOutDTOS;
    }


}
