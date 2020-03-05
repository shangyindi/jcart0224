package com.shangyd.jcartadministrationback.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shangyd.jcartadministrationback.dao.AdministratorMapper;
import com.shangyd.jcartadministrationback.po.Administrator;
import com.shangyd.jcartadministrationback.service.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministrationServiceImpl implements AdministrationService {

    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public Administrator getByUsername(String username) {
        return administratorMapper.getByUsername(username);
    }

    @Override
    public Page<Administrator> getSearch(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        return administratorMapper.getSearch();
    }

    @Override
    public void delete(Integer administratorId) {
        administratorMapper.deleteByPrimaryKey(administratorId);
    }
}
