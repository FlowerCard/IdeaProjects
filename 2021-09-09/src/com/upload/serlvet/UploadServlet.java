package com.upload.serlvet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/9.
 */
@WebServlet("/upload")
//添加一个MultipartConfig配置
@MultipartConfig
public class UploadServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决上传的文件名是中文的问题
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        //这个就是上传的文件对象封装的Part对象
        Part uploadFile = request.getPart("myFile");

        //获取文件名
        String fileName = uploadFile.getSubmittedFileName();
        //要求文件名必须唯一，最好不要中文
        fileName = fileName.substring((fileName.lastIndexOf("."))); //获取扩展名
        
        //使用UUID给上传的文件重新命名
        fileName = UUID.randomUUID().toString().replace("-","").concat(fileName);
        
        //获取上传路径
        String realPath = getServletContext().getRealPath("/files/");
        
        //创建文件对象
        File destFile = new File(realPath,fileName);
        //如果不存在就创建
        if (!destFile.getParentFile().exists()) {
            destFile.getParentFile().mkdir();
        }
        //写出去
        uploadFile.write(realPath + fileName);
        response.getWriter().write("上传成功");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}