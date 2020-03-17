package com.shangyd.jcartstoreback.dao;

import com.github.pagehelper.Page;
import com.shangyd.jcartstoreback.po.Return;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnMapper {
    int deleteByPrimaryKey(Integer returnId);

    int insert(Return record);

    void insertSelective(Return record);

    Return selectByPrimaryKey(Integer returnId);

    int updateByPrimaryKeySelective(Return record);

    int updateByPrimaryKey(Return record);

    Page<Return> getPageByCustomerId(Integer customerId);
}