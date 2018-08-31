package com.foo.service.transaction.impl;

import com.foo.dao.user.UserDao;
import com.foo.domain.user.User;
import com.foo.service.transaction.TxOtherUserService;
import com.foo.service.transaction.TxUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author jiangwang3
 * @date 2018/8/10.
 */
@Service
public class TxUserServiceImpl implements TxUserService{

    @Resource
    private UserDao userDao;

    @Resource
    private TxOtherUserService txOtherUserService;

    @Transactional
    public void insert(String name){
        User user = new User();
        user.setName(name);

        userDao.insertEntry(user);

        txOtherUserService.insert(name);

//        throw new RuntimeException();
    }

    @Override
    @Transactional
    public int update(User user) {
        userDao.updateById(user);
        return txOtherUserService.update(user);
    }
}
