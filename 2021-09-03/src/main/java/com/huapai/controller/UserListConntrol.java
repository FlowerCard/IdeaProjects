package com.huapai.controller;

import com.huapai.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/3.
 */
@WebServlet("/user/list")
public class UserListConntrol extends HttpServlet {

    private static final long serialVersionUID = -4274837384110951169L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        
        response.getWriter().write(
                loginUser.getId() + "<br>" +
                loginUser.getUseraccount() + "<br>" +
                loginUser.getUsername() + "<br>" +
                loginUser.getPassword() + "<br>" +
                loginUser.getRealname() + "<br>" +
                loginUser.getIdcode() + "<br>" +
                loginUser.getCreateTime() + "<br>" +
                loginUser.getModifiedTime() + "<br>" +
                loginUser.getStatus() + "<br>" +
                loginUser.getIsdelete()
        );
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}