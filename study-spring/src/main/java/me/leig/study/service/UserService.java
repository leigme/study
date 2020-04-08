package me.leig.study.service;

import me.leig.study.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @title: UserService
 * @description:
 * @author: leig
 * @create: 2020-04-08 22:29
 **/
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void insertUser() {
        userDao.insert();
        System.out.println("插入完成");
        int i = 10 / 0;
    }

}
