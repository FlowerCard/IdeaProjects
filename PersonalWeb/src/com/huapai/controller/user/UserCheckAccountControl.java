package com.huapai.controller.user;

import com.alibaba.fastjson.JSON;
import com.huapai.common.ResultVO;
import com.huapai.services.IUserServices;
import com.huapai.services.impl.UserServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/7.
 */
@WebServlet("/user/exist")
public class UserCheckAccountControl extends HttpServlet {
    
    private IUserServices userServices = new UserServicesImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String useraccountValue = request.getParameter("useraccountValue");
        ResultVO resultVO = userServices.existAccount(useraccountValue);
        if (resultVO.getSuccess()) {
            response.getWriter().write(JSON.toJSONString(resultVO));
            return;
        } else {
            response.getWriter().write(JSON.toJSONString(resultVO));
            return;
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}