package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    public void saveAccount() {
        accountDao.saveAccount();

    }
}
