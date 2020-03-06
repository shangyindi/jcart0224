package com.shangyd.jcartadministrationback.service;

import com.github.pagehelper.Page;
import com.shangyd.jcartadministrationback.dto.in.AdministrationCreateInDTO;
import com.shangyd.jcartadministrationback.po.Administrator;

public interface AdministrationService {
    Administrator getByUsername(String username);

    Page<Administrator> getSearch(Integer pageNum);

    void delete(Integer administratorId);

    Integer createAdministrator(Administrator administrator);
}
