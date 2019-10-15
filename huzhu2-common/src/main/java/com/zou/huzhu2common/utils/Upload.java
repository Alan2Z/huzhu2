package com.zou.huzhu2common.utils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.zou.huzhu2common.exception.UserException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/9/1 13:38
 * Project:  huzhu
 * Description: 文件上传工具
 **/
public class Upload {

    /**
     * 上传文件
     * @param serverPath
     * @param path
     * @return
     */
    public static String upload(Client client, MultipartFile file, String serverPath, String path){
        // 文件名称生成策略（UUID uuid = UUID.randomUUID()）
        String str = "";
        for(int i=0 ;i <5; i++){
            int n = (int)(Math.random()*90)+10;
            str += n;
        }
        // 获取文件的扩展名
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        // 文件名
        String fileName = System.nanoTime() + str + "." + extension;
        //相对路径
        String relaPath = path + fileName;

        String a = serverPath + path.substring(0, path.lastIndexOf("/"));
        File file2 = new File(a);
        if(!file2.exists()){
            boolean mkdirs = file2.mkdirs();
        }

        // 另一台tomcat的URL（真实路径）
        String realPath = serverPath + relaPath;
        // 设置请求路径
        WebResource resource = client.resource(realPath);

        // 发送开始post get put（基于put提交）
        try {
            resource.put(String.class, file.getBytes());
            return realPath;
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserException(ErrorCode.IMAGE_UPLOAD_FAILED);
//            return "";
        }
    }

    /**
     * 删除文件
     * @param filePath
     * @return
     */
    public static String delete(String filePath){
        try {
            Client client = new Client();
            WebResource resource = client.resource(filePath);
            resource.delete();
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "system error";
        }
    }
}
