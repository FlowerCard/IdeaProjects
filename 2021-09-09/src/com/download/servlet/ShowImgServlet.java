package com.download.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/9.
 */
@WebServlet("/show")
public class ShowImgServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        InputStream in = new FileInputStream(getServletContext().getRealPath("/file/"));
        String realPath = getServletContext().getRealPath("/files/");
        File fileDir = new File(realPath);
        List<String> fileList = new ArrayList<>();
        String[] list = fileDir.list();
        for (String s : list) {
            fileList.add(s);
        }
        request.getSession().setAttribute("files",fileList);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}