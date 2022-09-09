package com.dhee.service;

import java.util.List;

import com.dhee.dao.UserDao;
import com.dhee.entity.UserEntity;

public class UserService {

    private UserDao userDao = new UserDao();

    public UserEntity login(UserEntity userEntity) {
        List<UserEntity> list = userDao.select();
        for (UserEntity user : list) {//遍历list集合
            //			比较user.getUserName()和userEntity.getUserName()是否相等
//			equalsIgnoreCase() 方法的作用和语法与 equals() 方法完全相同，唯一不同的是 equalsIgnoreCase() 比较
            if (user.getUserName().equalsIgnoreCase(
                    userEntity.getUserName().trim())
                    && user.getPassword().equalsIgnoreCase(
                    userEntity.getPassword().trim())
            )
                return user;

        }
        return null;
    }

    public int registe(UserEntity userEntity) {
        List<UserEntity> list = userDao.select();
        for (UserEntity user : list) {
//			比较user.getUserName()和userEntity.getUserName()是否相等
//			equalsIgnoreCase() 方法的作用和语法与 equals() 方法完全相同，唯一不同的是 equalsIgnoreCase() 比较时不区分大小写。
            if (user.getUserName().equalsIgnoreCase(
                    userEntity.getUserName().trim())) {
                return 0;
            }
        }
        return userDao.insert(userEntity);
    }

}