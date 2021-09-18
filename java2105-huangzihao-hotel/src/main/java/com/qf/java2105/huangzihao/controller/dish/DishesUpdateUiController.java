package com.qf.java2105.huangzihao.controller.dish;

import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.pojo.Dishes;
import com.qf.java2105.huangzihao.service.ICuisineService;
import com.qf.java2105.huangzihao.service.IDishesService;
import com.qf.java2105.huangzihao.service.impl.CuisineServiceImpl;
import com.qf.java2105.huangzihao.service.impl.DishesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 菜品更新UI控制器
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/12.
 */
@WebServlet("/dish/updateui")
public class DishesUpdateUiController extends HttpServlet {
    
    private ICuisineService cuisineService = new CuisineServiceImpl();
    private IDishesService dishesService = new DishesServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultVO resultVO = cuisineService.queryByName("");
        request.setAttribute("cuisines",resultVO.getData());

        String dishId = request.getParameter("dishId");
        ResultVO<Dishes> dishesResultVO = dishesService.queryById(Integer.valueOf(dishId));
        request.setAttribute("dishes",dishesResultVO.getData());

        request.getRequestDispatcher(request.getContextPath() + "/backend/detail/food/food-update.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}