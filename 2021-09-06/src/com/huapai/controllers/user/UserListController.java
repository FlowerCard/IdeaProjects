package com.huapai.controllers.user;

import com.huapai.common.ResultVO;
import com.huapai.pojo.User;
import com.huapai.services.IUserServices;
import com.huapai.services.impl.UserServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/6.
 */
@WebServlet("/user/list")
public class UserListController extends HttpServlet {
    
    private IUserServices userServices = new UserServicesImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultVO resultVO = null;
        try {
            resultVO = userServices.userList();
            request.setAttribute("users",resultVO.getData());
            request.getRequestDispatcher("../pages/user/list.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("查询失败");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}