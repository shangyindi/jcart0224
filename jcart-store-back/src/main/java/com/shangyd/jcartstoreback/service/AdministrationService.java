package com.shangyd.jcartstoreback.service;

import com.github.pagehelper.Page;
import com.shangyd.jcartstoreback.dto.in.AdministrationUploadInDTO;
import com.shangyd.jcartstoreback.dto.out.AdministrationShowOutDTO;
import com.shangyd.jcartstoreback.po.Administrator;

public interface AdministrationService {
    Administrator getByUsername(String username);

    Page<Administrator> getSearch(Integer pageNum);

    void delete(Integer administratorId);

    Integer createAdministrator(Administrator administrator);

    AdministrationShowOutDTO getByAdministrationId(Integer administrationId);

    void upload(AdministrationUploadInDTO administrationUploadInDTO);
}
