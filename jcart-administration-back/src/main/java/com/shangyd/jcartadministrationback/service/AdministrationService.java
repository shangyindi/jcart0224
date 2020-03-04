package com.shangyd.jcartadministrationback.service;

import com.shangyd.jcartadministrationback.po.Administrator;

public interface AdministrationService {
    Administrator getByUsername(String username);
}
