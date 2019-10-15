package com.zou.huzhu2common.utils;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/9/1 14:11
 * Project:  huzhu
 * Description:
 **/
@Data
public class FileUploadEntity {

    private String parentPath; // 中间目录
    private String fileType; // 父级目录名称
    private MultipartFile file;
}
