package com.itheima.ui;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = (IAccountService)ac.getBean("accountServiceImpl");
//        System.out.println(as);
//
//        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);
//        System.out.println(adao);
        as.saveAccount();
    }
}
