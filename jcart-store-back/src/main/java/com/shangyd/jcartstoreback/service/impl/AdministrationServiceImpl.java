package com.shangyd.jcartstoreback.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shangyd.jcartstoreback.dao.AdministratorMapper;
import com.shangyd.jcartstoreback.dto.in.AdministrationUploadInDTO;
import com.shangyd.jcartstoreback.dto.out.AdministrationShowOutDTO;
import com.shangyd.jcartstoreback.po.Administrator;
import com.shangyd.jcartstoreback.service.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Integer createAdministrator(Administrator administrator) {
        Integer administratorId = administratorMapper.insertSelective(administrator);
        return administratorId;
    }

    @Override
    @Transactional
    public AdministrationShowOutDTO getByAdministrationId(Integer administrationId) {
        Administrator administrator = administratorMapper.selectByPrimaryKey(administrationId);
        AdministrationShowOutDTO administrationShowOutDTO = new AdministrationShowOutDTO();
        administrationShowOutDTO.setAvatarUrl(administrator.getAvatarUrl());
        administrationShowOutDTO.setAdministrationId(administrator.getAdministratorId());
        administrationShowOutDTO.setEmail(administrator.getEmail());
        administrationShowOutDTO.setStatus(administrator.getStatus());
        administrationShowOutDTO.setRealName(administrator.getRealName());
        administrationShowOutDTO.setUsername(administrator.getUsername());
        administrationShowOutDTO.setCreateTime(administrator.getCreateTime());
        return administrationShowOutDTO;
    }

    @Override
    @Transactional
    public void upload(AdministrationUploadInDTO administrationUploadInDTO) {
        Administrator administrator = new Administrator();
        administrator.setStatus(administrationUploadInDTO.getStatus());
        administrator.setEmail(administrationUploadInDTO.getEmail());
        administrator.setCreateTime(administrationUploadInDTO.getCreateTime());
        administrator.setRealName(administrationUploadInDTO.getRealName());
        administrator.setUsername(administrationUploadInDTO.getUsername());
        administrator.setAdministratorId(administrationUploadInDTO.getAdministrationId());
        administratorMapper.updateByPrimaryKeySelective(administrator);
    }

}
