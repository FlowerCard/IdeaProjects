package com.qf.test0902.servlets;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/2.
 */
@WebServlet("/generateValidateCode")
public class GenerateValidateCodeServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ValidateCode vc = new ValidateCode(200,30,4,10);
        String code = vc.getCode();

        //使用Session存储生成的验证码
        HttpSession session = request.getSession();
        session.setAttribute("code",code);

        //响应给客户端
        vc.write(response.getOutputStream());
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}