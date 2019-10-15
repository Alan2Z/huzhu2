package com.zou.huzhu2biz.service.impl;

import com.zou.huzhu2biz.service.UserService;
import com.zou.huzhu2common.exception.UserException;
import com.zou.huzhu2common.utils.DateUtils;
import com.zou.huzhu2common.utils.GParameter;
import com.zou.huzhu2common.utils.IdGen;
import com.zou.huzhu2common.utils.MD5Utils;
import com.zou.huzhu2dao.mapper.UserMapper;
import com.zou.huzhu2entity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 15:21
 * Project:  huzhu
 * Description:
 **/
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public void singIn(User user) throws NoSuchAlgorithmException {
        user.setId(IdGen.UUID());
        user.setPassword(MD5Utils.encryption(user.getPassword()));
        user.setCreateTime(DateUtils.getNow());
        user.setUserImg(GParameter.defaultHeadImg);
        userMapper.singIn(user);
    }

    @Override
    public User findByUsernameAndPassword(User user) throws UserException {
        return userMapper.findByUsernameAndPassword(user);
    }

    @Override
    public void updateUserInfo(User user) {
        userMapper.updateUserInfo(user);
    }
}
