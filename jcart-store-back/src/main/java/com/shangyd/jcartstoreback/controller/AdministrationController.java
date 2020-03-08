package com.shangyd.jcartstoreback.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.github.pagehelper.Page;
import com.shangyd.jcartstoreback.constant.ClientExceptionConstant;
import com.shangyd.jcartstoreback.dto.in.AdministrationCreateInDTO;
import com.shangyd.jcartstoreback.dto.in.AdministrationLoginInDTO;
import com.shangyd.jcartstoreback.dto.in.AdministrationResetPwdInDTO;
import com.shangyd.jcartstoreback.dto.in.AdministrationUploadInDTO;
import com.shangyd.jcartstoreback.dto.out.AdministrationListOutDTO;
import com.shangyd.jcartstoreback.dto.out.AdministrationLoginOutDTO;
import com.shangyd.jcartstoreback.dto.out.AdministrationShowOutDTO;
import com.shangyd.jcartstoreback.dto.out.PageOutDTO;
import com.shangyd.jcartstoreback.exception.ClientException;
import com.shangyd.jcartstoreback.po.Administrator;
import com.shangyd.jcartstoreback.service.AdministrationService;
import com.shangyd.jcartstoreback.util.JWTUtil;
import com.shangyd.jcartstoreback.service.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/administrator")
@CrossOrigin
public class AdministrationController {

    @Autowired
    private AdministrationService administrationService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/create")
    public Integer create(@RequestBody AdministrationCreateInDTO administrationCreateInDTO){
        Administrator administrator = new Administrator();
        administrator.setRealName(administrationCreateInDTO.getRealName());
        administrator.setUsername(administrationCreateInDTO.getUsername());
        administrator.setAvatarUrl(administrationCreateInDTO.getAvatarUrl());
        administrator.setCreateTime(administrationCreateInDTO.getCreateTime());
        administrator.setEmail(administrationCreateInDTO.getEmail());
        administrator.setStatus(administrationCreateInDTO.getStatus());
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, administrationCreateInDTO.getPassword().toCharArray());
        administrator.setEncryptedPassword(bcryptHashString);
        Integer administratorId = administrationService.createAdministrator(administrator);
        return administratorId;
    }
    /**
     *
     * @param administrationId
     * @return
     */
    @GetMapping("/getByAdministrationId")
    public AdministrationShowOutDTO getByAdministrationId(@RequestAttribute("administrationId") Integer administrationId){
        AdministrationShowOutDTO administrationShowOutDTO = administrationService.getByAdministrationId(administrationId);
        return administrationShowOutDTO;
    }

    /**
     *
     * @param administrationResetPwdInDTO
     * @return
     */
    @PostMapping("/resetPwd")
    public AdministrationShowOutDTO resetAdministration(@RequestBody AdministrationResetPwdInDTO administrationResetPwdInDTO){
        return null;
    }

    /***
     *
     * @param administrationUploadInDTO
     */
    @PostMapping("/upload")
    public void uploadAdministration(@RequestBody AdministrationUploadInDTO administrationUploadInDTO){
        administrationService.upload(administrationUploadInDTO);
    }

    /**
     *
     * @param pageNum
     * @return
     */
    @GetMapping("/search")
    public PageOutDTO<AdministrationListOutDTO> getList(@RequestParam(defaultValue = "1",required = false) Integer pageNum){
        Page<Administrator> page = administrationService.getSearch(pageNum);
        List<AdministrationListOutDTO> administrationListOutDTOS = page.stream().map(administrator -> {
            AdministrationListOutDTO administrationListOutDTO = new AdministrationListOutDTO();
            administrationListOutDTO.setEmail(administrator.getEmail());
            administrationListOutDTO.setStatus(administrator.getStatus());
            administrationListOutDTO.setCreateTime(administrator.getCreateTime());
            administrationListOutDTO.setRealName(administrator.getRealName());
            administrationListOutDTO.setUsername(administrator.getUsername());
            administrationListOutDTO.setAdministratorId(administrator.getAdministratorId());
            return administrationListOutDTO;
        }).collect(Collectors.toList());
        PageOutDTO<AdministrationListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setList(administrationListOutDTOS);
        return  pageOutDTO;
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer administratorId){
        administrationService.delete(administratorId);
    }
}
