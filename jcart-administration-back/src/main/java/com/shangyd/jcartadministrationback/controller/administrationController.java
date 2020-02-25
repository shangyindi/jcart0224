package com.shangyd.jcartadministrationback.controller;

import com.shangyd.jcartadministrationback.dto.in.AdministrationRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administration")
public class administrationController {

    @PostMapping("/login")
    public String login(@RequestBody AdministrationRequestDTO administrationRequestDTO){
        System.out.println(administrationRequestDTO.getUsername());
        System.out.println(administrationRequestDTO.getPassword());
        return null;
    }

}
