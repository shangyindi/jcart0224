package com.shangyd.jcartadministrationback.service;

import com.github.pagehelper.Page;
import com.shangyd.jcartadministrationback.dto.out.ReturnListOutDTO;
import com.shangyd.jcartadministrationback.po.Return;

public interface ReturnService {
    Page<Return> search(Integer pageNum);
}
