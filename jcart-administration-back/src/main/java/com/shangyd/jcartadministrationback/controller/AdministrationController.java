package com.shangyd.jcartadministrationback.controller;

import com.shangyd.jcartadministrationback.dto.in.AdministrationCreateInDTO;
import com.shangyd.jcartadministrationback.dto.in.AdministrationLoginInDTO;
import com.shangyd.jcartadministrationback.dto.in.AdministrationResetPwdInDTO;
import com.shangyd.jcartadministrationback.dto.in.AdministrationUploadInDTO;
import com.shangyd.jcartadministrationback.dto.out.AdministrationListOutDTO;
import com.shangyd.jcartadministrationback.dto.out.AdministrationShowOutDTO;
import com.shangyd.jcartadministrationback.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administration")
public class AdministrationController {

    /**
     *
..../*-am administrationCreateInDTO
     * @return
     */
    @PostMapping("/create")
    public Integer create(@RequestBody AdministrationCreateInDTO administrationCreateInDTO){
        return null;
    }
    /**
     * 用户登录
     * @param administratorLoginInDTO
     * @return
     */
    @GetMapping("/login")
    public String login(AdministrationLoginInDTO administratorLoginInDTO){
        return null;
    }

    /**
     *
     * @param administrationId
     * @return
     */
    @GetMapping("/getByadministrationId")
    public AdministrationShowOutDTO getByadministrationId(@RequestParam("administrationId") Integer administrationId){
        return null;
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

    }

    /**
     *
     * @param pageNum
     * @return
     */
    @GetMapping("/getlist")
    public PageOutDTO<AdministrationListOutDTO> getList(@RequestParam Integer pageNum){
        return  null;
    }

}
