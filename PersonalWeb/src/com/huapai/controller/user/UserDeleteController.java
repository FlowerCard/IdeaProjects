package com.huapai.controller.user;

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
 * Created on 2021/9/6.
 */
@WebServlet("/user/deleteUser")
public class UserDeleteController extends HttpServlet {
    
    private IUserServices userServices = new UserServicesImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String del = request.getParameter("delid");
        System.out.println(del);
        ResultVO resultVO = userServices.removeUserById(del);
        if (resultVO.getSuccess()) {
//            request.getRequestDispatcher("../pages/user/list.jsp").forward(request,response);
            resultVO = userServices.userList();
            request.getSession().setAttribute("users",resultVO.getData());
            response.sendRedirect(request.getContextPath() + "/pages/user/list.jsp");
        } else {
            request.getRequestDispatcher("../pages/user/list.jsp").forward(request,response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}