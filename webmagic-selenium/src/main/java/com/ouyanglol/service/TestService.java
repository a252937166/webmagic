package com.ouyanglol.service;

import com.ouyanglol.dao.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Package: com.ouyanglol.service
 *
 * @Author: Ouyang
 * @Date: 2018/2/2
 */
@Service
public class TestService {
    @Autowired
    TestMapper testMapper;

    public void test() {
        System.out.println(testMapper.selectByPrimaryKey(1).getText());
    }
}
