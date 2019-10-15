package com.zou.huzhu2web.controller;

import com.sun.jersey.api.client.Client;
import com.zou.huzhu2common.exception.UserException;
import com.zou.huzhu2common.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/9/1 14:07
 * Project:  huzhu
 * Description:
 **/
@RestController
@RequestMapping("util")
public class UtilsController {


    @PostMapping(value = "deleteServerImg", produces = "text/html;charset=UTF-8")
    public String deleteServerImg(@RequestBody String imgUrl){
        if (StringUtils.isBlank(imgUrl))
            return "data error";
        return Upload.delete(imgUrl);
    }

    // 页面指定路径上传
    @PostMapping(value = "uploadByPath", produces = "application/json;charset=UTF-8")
    public Response uploadByPath(FileUploadEntity fileUploadEntity){

        try {
            // 判断文件夹是否存在是否创建
            String filePath = "/usr/local/tomcat/webapps/upload/"+ GParameter.project+"/"+fileUploadEntity.getParentPath()+"/"+fileUploadEntity.getFileType()+"/"+ DateUtils.getNow("yyyyMMdd");

            File _file = new File(filePath);
            if (!_file.exists())
                _file.mkdirs();

            Client client = new Client();
            String uploadInfo ="";
            if (StringUtils.isBlank(fileUploadEntity.getFileType())){
                uploadInfo = Upload.upload(client, fileUploadEntity.getFile(), GParameter.serverPath, GParameter.project+"/"+fileUploadEntity.getParentPath()+"/images/"+ DateUtils.getNow("yyyyMMdd")+"/");
            }else {
                uploadInfo = Upload.upload(client, fileUploadEntity.getFile(), GParameter.serverPath, GParameter.project+"/"+fileUploadEntity.getParentPath()+"/"+fileUploadEntity.getFileType()+"/"+ DateUtils.getNow("yyyyMMdd")+"/");
            }

            if ("".equals(uploadInfo)){
                return Response.error(ErrorCode.IMAGE_UPLOAD_FAILED);
            }else {
                return Response.success(uploadInfo);
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new UserException(ErrorCode.IMAGE_UPLOAD_FAILED);
        }

    }
}
