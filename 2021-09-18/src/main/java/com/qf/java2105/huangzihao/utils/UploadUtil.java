package com.qf.java2105.huangzihao.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.util.UUID;

/**
 * 文件上传工具类
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/12.
 */
public class UploadUtil {

    /**
     * 上传文件
     * @param request 获得上传文件
     * @param uploadName 前台传入的名字
     * @param destPath 目标路径
     * @return
     */
    public static String upload(HttpServletRequest request,String uploadName,String destPath) {
        try {
            //上传文件
            Part requestPart = request.getPart(uploadName);
            //上传文件名
            String fileName = requestPart.getSubmittedFileName();
            //判断上传文件名
            if (null == fileName || "".equals(fileName)) {
                return "";
            }
            
            //获取UUID与上传文件名拼接的新文件名
            fileName = getUUID().concat(getExtName(fileName));
            
            String path = request.getServletContext().getRealPath(destPath);
            
            //上传的文件对象
            File uploadFile = new File(path,fileName);
            if (!uploadFile.getParentFile().exists()) {
                uploadFile.getParentFile().mkdirs();
            }
            //上传文件
            requestPart.write(uploadFile.getPath());
            return destPath + fileName;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return 获取UUID
     */
    private static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 获取扩展名
     * @param fileName 文件名
     * @return 扩展名
     */
    private static String getExtName(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }
    
}
