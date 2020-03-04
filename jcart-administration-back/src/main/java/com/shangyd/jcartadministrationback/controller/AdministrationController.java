package com.shangyd.jcartadministrationback.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.shangyd.jcartadministrationback.constant.ClientExceptionConstant;
import com.shangyd.jcartadministrationback.dto.in.AdministrationCreateInDTO;
import com.shangyd.jcartadministrationback.dto.in.AdministrationLoginInDTO;
import com.shangyd.jcartadministrationback.dto.in.AdministrationResetPwdInDTO;
import com.shangyd.jcartadministrationback.dto.in.AdministrationUploadInDTO;
import com.shangyd.jcartadministrationback.dto.out.AdministrationListOutDTO;
import com.shangyd.jcartadministrationback.dto.out.AdministrationLoginOutDTO;
import com.shangyd.jcartadministrationback.dto.out.AdministrationShowOutDTO;
import com.shangyd.jcartadministrationback.dto.out.PageOutDTO;
import com.shangyd.jcartadministrationback.exception.ClientException;
import com.shangyd.jcartadministrationback.po.Administrator;
import com.shangyd.jcartadministrationback.service.AdministrationService;
import com.shangyd.jcartadministrationback.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrator")
public class AdministrationController {

    @Autowired
    private AdministrationService administrationService;

    @Autowired
    private  JWTUtil jwtUtil;

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
    public AdministrationLoginOutDTO login(AdministrationLoginInDTO administratorLoginInDTO) throws ClientException {
        Administrator administrator = administrationService.getByUsername(administratorLoginInDTO.getUsername());
        if (administrator == null){
            throw new ClientException(ClientExceptionConstant.ADMINISTRATOR_USERNAME_NOT_EXIST_ERRCODE, ClientExceptionConstant.ADMINISTRATOR_USERNAME_NOT_EXIST_ERRMSG);
        }
        String encPwdDB = administrator.getEncryptedPassword();
        BCrypt.Result result = BCrypt.verifyer().verify(administratorLoginInDTO.getPassword().toCharArray(), encPwdDB);

        if (result.verified) {
            AdministrationLoginOutDTO administrationLoginOutDTO = jwtUtil.issueToken(administrator);
            return administrationLoginOutDTO;
        }else {
            throw new ClientException(ClientExceptionConstant.ADNINISTRATOR_PASSWORD_INVALID_ERRCODE, ClientExceptionConstant.ADNINISTRATOR_PASSWORD_INVALID_ERRMSG);
        }
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
