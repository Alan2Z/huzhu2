package com.zou.huzhu2web.controller;

import com.zou.huzhu2biz.service.UserService;
import com.zou.huzhu2common.exception.UserException;
import com.zou.huzhu2common.utils.ErrorCode;
import com.zou.huzhu2common.utils.JwtUtils;
import com.zou.huzhu2common.utils.MD5Utils;
import com.zou.huzhu2common.utils.Response;
import com.zou.huzhu2entity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 15:49
 * Project:  huzhu
 * Description:登陆控制器
 **/
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("token")
    public Response getToken(@RequestBody User user){
        try {
            user.setPassword(MD5Utils.encryption(user.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new UserException(ErrorCode.SYSTEM_ERROR);
        }
        User login = userService.findByUsernameAndPassword(user);
        HashMap<String, Object> map = new HashMap<>();
        if (null != login){
            String token = JwtUtils.sign(login.getId(), 60L * 1000L * 120L);//1 分钟
            map.put("loginId",login.getId());
            map.put("token",token);
            map.put("userInfo",login);
            return Response.success(map);
        }else {
            throw new UserException(ErrorCode.USER_NOT_FOUND);
        }
    }


}