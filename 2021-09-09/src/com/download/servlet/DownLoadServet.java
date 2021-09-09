package com.download.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/9.
 */
@WebServlet("/download")
public class DownLoadServet extends HttpServlet {

    private ServletOutputStream out;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到文件名
        String filename = request.getParameter("filename");
        
        //找到真实路径
        String realPath = getServletContext().getRealPath("/files/" + filename);
        
        //设置响应头
        //告知浏览器以附件的形式去打开文件
        //response.setHeader("content-disposition", "attachment;filename="+ 下载文件的名字 );
        response.setHeader("content-disposition", "attachment;filename="+ URLEncoder.encode(filename,"UTF-8"));
        
        //边读边写
        InputStream in = new FileInputStream(realPath);
        ServletOutputStream out = response.getOutputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = in.read(bytes)) != -1) {
            out.write(bytes,0,len);
            out.flush();
        }
        out.close();
        in.close();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}