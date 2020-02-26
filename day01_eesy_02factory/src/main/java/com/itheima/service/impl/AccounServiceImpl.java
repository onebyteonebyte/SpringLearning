package com.itheima.service.impl;

import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;
import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDaoImpl;

public class AccounServiceImpl implements IAccountService {

    //private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");
    @Override
    public void saveAccount() {
        accountDao.saveAccount();

    }
}
