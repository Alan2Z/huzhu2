package com.zou.huzhu2biz.service;

import com.zou.huzhu2entity.entity.User;

import java.security.NoSuchAlgorithmException;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 15:17
 * Project:  huzhu
 * Description:
 **/
public interface UserService extends BaseService<User>{

    void singIn(User user) throws NoSuchAlgorithmException;

    User findByUsernameAndPassword(User user);

    void updateUserInfo(User user);
}
