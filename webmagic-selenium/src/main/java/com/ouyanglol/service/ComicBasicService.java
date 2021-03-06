package com.ouyanglol.service;

import com.ouyanglol.dao.ComicBasicMapper;
import com.ouyanglol.model.ComicBasic;
import com.ouyanglol.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ComicBasicService {
    private final
    ComicBasicMapper comicBasicMapper;

    @Autowired
    public ComicBasicService(ComicBasicMapper comicBasicMapper) {
        this.comicBasicMapper = comicBasicMapper;
    }

    public String getIdByName(String name) {
        ComicBasic comicBasic = new ComicBasic();
        comicBasic.setName(name);
        comicBasic = comicBasicMapper.select(comicBasic);
        //没有就新建
        if (comicBasic==null) {
            comicBasic = new ComicBasic();
            comicBasic.setName(name);
            comicBasic.setId(UUIDUtil.getId());
            comicBasic.setCreateDate(new Date());
            comicBasicMapper.insertSelective(comicBasic);
        }
        return comicBasic.getId();
    }
}
