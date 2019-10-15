package com.zou.huzhu2dao.mapper;

import com.zou.huzhu2entity.entity.User;
import com.zou.huzhu2entity.entity.UserMessage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 15:36
 * Project:  huzhu
 * Description:
 **/
@Repository
public interface UserMessageMapper extends BaseMapper<UserMessage> {

    List<UserMessage> findMsgList(@Param("createUser") String createUser);

    UserMessage findLastMsg(@Param("sendId")String sendId,@Param("addressId")String addressId);

}
