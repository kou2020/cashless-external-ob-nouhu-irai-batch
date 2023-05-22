package com.nttdata.cashless.service.impl;

import com.nttdata.cashless.service.CheckService;
import org.springframework.stereotype.Service;

@Service
public class CheckServiceImpl implements CheckService {
    @Override
    public void TestCommonServiceFunction() {
        System.out.println("共同ServiceFunction。。。。。。。。。。。");
    }
}
