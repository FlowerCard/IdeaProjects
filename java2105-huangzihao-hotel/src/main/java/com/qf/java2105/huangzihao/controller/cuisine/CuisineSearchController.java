package com.qf.java2105.huangzihao.controller.cuisine;

import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.service.ICuisineService;
import com.qf.java2105.huangzihao.service.impl.CuisineServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 菜系查询控制器
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/12.
 */
@WebServlet("/cuisine/search")
public class CuisineSearchController extends HttpServlet {
    
    private ICuisineService cuisineService = new CuisineServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cuisineName = request.getParameter("keyword");
        ResultVO resultVO = cuisineService.queryByName(cuisineName);
        request.setAttribute("keyword",cuisineName == null ? "" : cuisineName.trim());
        request.setAttribute("cuisines",resultVO.getData());
        request.getRequestDispatcher(request.getContextPath() + "/backend/detail/foodtype/foodtype-list.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}