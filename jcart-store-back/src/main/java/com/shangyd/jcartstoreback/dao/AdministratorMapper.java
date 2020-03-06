package com.shangyd.jcartstoreback.dao;

import com.github.pagehelper.Page;
import com.shangyd.jcartstoreback.po.Administrator;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorMapper {
    int deleteByPrimaryKey(Integer administratorId);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    Administrator selectByPrimaryKey(Integer administratorId);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);

    Administrator getByUsername(String username);

    Page<Administrator> getSearch();
}