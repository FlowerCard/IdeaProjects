package com.huapai.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
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
    
}
