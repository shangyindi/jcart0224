package com.shangyd.jcartadministrationback.dao;

import com.github.pagehelper.Page;
import com.shangyd.jcartadministrationback.dto.out.ReturnListOutDTO;
import com.shangyd.jcartadministrationback.po.Return;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnMapper {
    int deleteByPrimaryKey(Integer returnId);

    int insert(Return record);

    int insertSelective(Return record);

    Return selectByPrimaryKey(Integer returnId);

    int updateByPrimaryKeySelective(Return record);

    int updateByPrimaryKey(Return record);

    Page<Return> search(Integer pageNum);
}