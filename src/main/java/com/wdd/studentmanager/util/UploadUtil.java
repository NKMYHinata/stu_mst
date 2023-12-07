package com.wdd.studentmanager.util;

import java.io.File;

/**
 * 处理文件上传的目录
 * 提供获取上传图片存储目录的方法，同时确保该目录存在
 *
 * @Classname UploadUtil
 * @Description 文件上传工具类
 * @Date 2019/6/27 20:06
 * @Created by WDD
 */
public class UploadUtil {
    // 项目根路径(static)下的目录。
    public final static String IMG_PATH_PREFIX = "static/upload/imgs";

    /**
     * 获取图片上传的目录文件对象
     * 如果目录不存在则将被创建
     *
     * @return 图片上传的目录文件对象
     */
    public static File getImgDirFile() {
        // 上传文件的文件夹路径
        String fileDirPath = "src/main/resources/" + IMG_PATH_PREFIX;

        File fileDir = new File(fileDirPath);
        if (!fileDir.exists()) {
            // 递归创建文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }
}
