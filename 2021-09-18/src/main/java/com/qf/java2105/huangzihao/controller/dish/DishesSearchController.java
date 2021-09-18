package com.qf.java2105.huangzihao.controller.dish;

import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.pojo.Dishes;
import com.qf.java2105.huangzihao.service.IDishesService;
import com.qf.java2105.huangzihao.service.impl.DishesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 菜品搜索控制器
 * 默认无参数搜索全部
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/12.
 */
@WebServlet("/dish/search")
public class DishesSearchController extends HttpServlet {
    
    private IDishesService dishesService = new DishesServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dishName = request.getParameter("keyword");
        ResultVO<List<Dishes>> listResultVO = dishesService.queryByName(dishName);
        
        request.setAttribute("keyword",dishName == null ? "" : dishName.trim());
        request.setAttribute("dishes",listResultVO.getData());
        String context = request.getContextPath();
        request.getRequestDispatcher(request.getContextPath() + "/backend/detail/food/food-list.jsp").forward(request,response);
        
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}