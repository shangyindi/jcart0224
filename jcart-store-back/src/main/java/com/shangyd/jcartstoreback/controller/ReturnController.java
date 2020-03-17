package com.shangyd.jcartstoreback.controller;

import com.shangyd.jcartstoreback.dto.in.ReturnApplyInDTO;
import com.shangyd.jcartstoreback.eunm.ReturnStatus;
import com.shangyd.jcartstoreback.po.Return;
import com.shangyd.jcartstoreback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/return")
@CrossOrigin
public class ReturnController {

    @Autowired
    private ReturnService returnService;

    @PostMapping("/apply")
    public Integer apply(@RequestBody ReturnApplyInDTO returnApplyInDTO, @RequestAttribute Integer customerId){
        Return returned = new Return();
        returned.setAction(returnApplyInDTO.getReason());
        returned.setComment(returnApplyInDTO.getComment());
        returned.setCustomerName(returnApplyInDTO.getCustomerName());
        returned.setEmail(returnApplyInDTO.getEmail());
        returned.setMobile(returnApplyInDTO.getMobile());
        returned.setProductCode(returnApplyInDTO.getProductCode());
        returned.setOpened(returnApplyInDTO.getOpened());
        returned.setQuantity(returnApplyInDTO.getQuantity());
        returned.setCustomerId(customerId);
        returned.setOrderId(returnApplyInDTO.getOrderId());
        returned.setStatus((byte) ReturnStatus.pending.ordinal());
        returned.setReason(returnApplyInDTO.getReason());
        returned.setProductName(returnApplyInDTO.getProductName());
        returned.setOrderTime(new Date(returnApplyInDTO.getOrderTime()));
        Date date = new Date();
        returned.setCreateTime(date);
        returned.setUpdateTime(date);
        returnService.create(returned);
        Integer returnId = returned.getReturnId();
        return returnId;
    }

}
