package com.shangyd.jcartadministrationback.service;

import com.github.pagehelper.Page;
import com.shangyd.jcartadministrationback.dto.in.AdministrationCreateInDTO;
import com.shangyd.jcartadministrationback.dto.in.AdministrationUploadInDTO;
import com.shangyd.jcartadministrationback.dto.out.AdministrationShowOutDTO;
import com.shangyd.jcartadministrationback.po.Administrator;

public interface AdministrationService {
    Administrator getByUsername(String username);

    Page<Administrator> getSearch(Integer pageNum);

    void delete(Integer administratorId);

    Integer createAdministrator(Administrator administrator);

    AdministrationShowOutDTO getByAdministrationId(Integer administrationId);

    void upload(AdministrationUploadInDTO administrationUploadInDTO);
}
