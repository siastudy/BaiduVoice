package com.baidu.reco.service.impl;

import com.baidu.reco.bean.User;
import com.baidu.reco.dao.UserDao;
import com.baidu.reco.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User getUserById(int userId) {

        return this.userDao.selectByPrimaryKey(userId);
    }
}
