package com.shangyd.jcartstoreback.controller;

import com.github.pagehelper.Page;
import com.shangyd.jcartstoreback.dto.in.ReturnApplyInDTO;
import com.shangyd.jcartstoreback.dto.out.PageOutDTO;
import com.shangyd.jcartstoreback.dto.out.ReturnListOutDTO;
import com.shangyd.jcartstoreback.dto.out.ReturnShowOutDTO;
import com.shangyd.jcartstoreback.eunm.ReturnStatus;
import com.shangyd.jcartstoreback.po.Return;
import com.shangyd.jcartstoreback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/getList")
    public PageOutDTO<ReturnListOutDTO> getList(@RequestAttribute Integer customerId, @RequestParam(required = false, defaultValue = "1") Integer pageNum){
        Page<Return> page = returnService.getPageByCustomerId(customerId,pageNum);
        List<ReturnListOutDTO> returnListOutDTOS = page.stream().map(aReturn -> {
            ReturnListOutDTO returnListOutDTO = new ReturnListOutDTO();
            returnListOutDTO.setCustomerId(aReturn.getCustomerId());
            returnListOutDTO.setCreateTime(aReturn.getCreateTime().getTime());
            returnListOutDTO.setCustomerName(aReturn.getCustomerName());
            returnListOutDTO.setReturnId(aReturn.getReturnId());
            returnListOutDTO.setOrderId(aReturn.getOrderId());
            returnListOutDTO.setStatus(aReturn.getStatus());
            return returnListOutDTO;
        }).collect(Collectors.toList());
        PageOutDTO<ReturnListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(returnListOutDTOS);
        return pageOutDTO;
    }

    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam("returnId") Integer returnId){
        Return aReturn = returnService.getById(returnId);
        ReturnShowOutDTO showOutDTO = new ReturnShowOutDTO();
        showOutDTO.setAction(aReturn.getAction());
        showOutDTO.setComment(aReturn.getComment());
        showOutDTO.setCreateTimestamp(aReturn.getCreateTime().getTime());
        showOutDTO.setUpdateTimestamp(aReturn.getUpdateTime().getTime());
        showOutDTO.setOrderTimestamp(aReturn.getOrderTime().getTime());
        showOutDTO.setOpened(aReturn.getOpened());
        showOutDTO.setReason(aReturn.getReason());
        showOutDTO.setReturnId(aReturn.getReturnId());
        showOutDTO.setCustomerName(aReturn.getCustomerName());
        showOutDTO.setEmail(aReturn.getEmail());
        showOutDTO.setQuantity(aReturn.getQuantity());
        showOutDTO.setProductName(aReturn.getProductName());
        showOutDTO.setOrderId(aReturn.getOrderId());
        showOutDTO.setProductCode(aReturn.getProductCode());
        showOutDTO.setStatus(aReturn.getStatus());
        showOutDTO.setMobile(aReturn.getMobile());
        return showOutDTO;
    }
}
