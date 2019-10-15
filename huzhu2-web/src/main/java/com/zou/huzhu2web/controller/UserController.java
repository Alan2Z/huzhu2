package com.zou.huzhu2web.controller;

import com.zou.huzhu2biz.service.UserMessageService;
import com.zou.huzhu2biz.service.UserService;
import com.zou.huzhu2common.exception.UserException;
import com.zou.huzhu2common.utils.ErrorCode;
import com.zou.huzhu2common.utils.Response;
import com.zou.huzhu2entity.entity.User;
import com.zou.huzhu2entity.entity.UserMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 16:23
 * Project:  huzhu
 * Description:
 **/
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMessageService userMessageService;

    @PostMapping("singIn")
    public Response singIn(@RequestBody User user){
        if (StringUtils.isBlank(user.getUserPhone())
                || StringUtils.isBlank(user.getUserPhone())
                || StringUtils.isBlank(user.getPassword())){
            return Response.error();
        }
        try {
            userService.singIn(user);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new UserException(ErrorCode.SYSTEM_ERROR);
        }
        return Response.success();
    }

    @PostMapping("getUserInfo")
    public Response getUserInfo(@RequestBody User user){
        User u = userService.findById(user);
        return Response.success(u);
    }

    @PostMapping("updateUserInfo")
    public Response updateUserInfo(@RequestBody User user){
        userService.updateUserInfo(user);
        return Response.success();
    }

    @PostMapping("msgList")
    public Response getMyMsgList(@RequestBody User user){
        if (StringUtils.isBlank(user.getId())){
            return Response.error();
        }
        List<UserMessage> msgList = userMessageService.findMsgList(user.getId());
        return Response.success(msgList);
    }

}
