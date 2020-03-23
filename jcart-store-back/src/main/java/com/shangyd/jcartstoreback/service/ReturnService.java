package com.shangyd.jcartstoreback.service;

import com.github.pagehelper.Page;
import com.shangyd.jcartstoreback.po.Return;

public interface ReturnService {
    void create(Return returned);

    Page<Return> getPageByCustomerId(Integer customerId, Integer pageNum);

    Return getById(Integer returnId);
}
