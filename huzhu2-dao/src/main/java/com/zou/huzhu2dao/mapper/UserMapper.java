package com.zou.huzhu2dao.mapper;

import com.zou.huzhu2entity.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 15:22
 * Project:  huzhu
 * Description:
 **/
@Repository
public interface UserMapper extends BaseMapper<User>{


    void singIn(User user);

    User findByUsernameAndPassword(User user);

    void updateUserInfo(User user);
}
