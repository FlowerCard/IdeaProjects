package com.huapai.work.controllers;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/2.
 */
@WebServlet("/validateCoide")
public class ValidateCoideController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建验证码实例
        ValidateCode vc = new ValidateCode(200,30,6,10);
        //获取生成验证码
        String code = vc.getCode();
        //使用Seesion存储生成的验证码
        HttpSession session = request.getSession();
        session.setAttribute("vcode",code);
        //响应给客户端
        vc.write(response.getOutputStream());

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}