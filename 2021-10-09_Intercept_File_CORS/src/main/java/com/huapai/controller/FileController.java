package com.huapai.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/9.
 */
@Controller
@RequestMapping("/file")
public class FileController {
    
    @RequestMapping("/upload")
    public String upload(MultipartFile source, HttpSession session) throws IOException {
        //获取源文件名
        String filename = source.getOriginalFilename();
        
        //获取后缀名
        String suffixName = filename.substring(filename.lastIndexOf("."));
        String uuidName = UUID.randomUUID().toString().replace("-","");
        String newFileName = uuidName.concat(suffixName);
        
        //获取文件存储位置
        String realPath = session.getServletContext().getRealPath("/files/");
        File file = new File(realPath + newFileName);
        //判断目录是否存在
        if (!file.getParentFile().exists()) {
            //不存在就创建
            file.getParentFile().mkdirs();
        }
        //存储文件
        source.transferTo(file);
        return "index";
    }
    
    @RequestMapping("/downloadUi")
    public String downloadUi(HttpSession session, HttpServletRequest request){
        String realPath = session.getServletContext().getRealPath("/files/");
        File file = new File(realPath);
        File[] listFiles = file.listFiles();
        List<String> fileList = new ArrayList<>();
        for (File getFile : listFiles) {
            System.out.println(getFile.getName());
            fileList.add(getFile.getName());
        }
        request.setAttribute("fileList",fileList);
        return "forward:/download.jsp";
        
    }
    
    @RequestMapping("/download")
    public String download(String name,HttpSession session, HttpServletResponse response) throws IOException {
        //文件夹位置
        String realPath = session.getServletContext().getRealPath("/files/");
        
        //绝对路径
        String downloadFile = realPath.concat(name);
        
        //设置响应头，告知浏览器要以附件的形式保存内容  filename=浏览器显示的下载名称
        response.setHeader("Content-Disposition","attachment;filename=" + name);

        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(new FileInputStream(downloadFile),outputStream);
        outputStream.close();
        
        return "redirect:downloadUi";
    }
    
}
