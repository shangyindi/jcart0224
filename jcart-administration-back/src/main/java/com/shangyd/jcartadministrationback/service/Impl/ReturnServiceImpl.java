package com.shangyd.jcartadministrationback.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shangyd.jcartadministrationback.dao.ReturnMapper;
import com.shangyd.jcartadministrationback.dto.out.ReturnListOutDTO;
import com.shangyd.jcartadministrationback.po.Return;
import com.shangyd.jcartadministrationback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnServiceImpl implements ReturnService {

    @Autowired
    private ReturnMapper returnMapper;

    @Override
    public Page<Return> search(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<Return> page = returnMapper.search(pageNum);
        return page;
    }
}
