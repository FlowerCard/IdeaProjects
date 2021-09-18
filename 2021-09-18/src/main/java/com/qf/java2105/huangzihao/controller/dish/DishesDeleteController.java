package com.qf.java2105.huangzihao.controller.dish;

import com.alibaba.druid.util.StringUtils;
import com.qf.java2105.huangzihao.constant.MessageConstant;
import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.service.IDishesService;
import com.qf.java2105.huangzihao.service.impl.DishesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 菜品删除控制器
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/12.
 */
@WebServlet("/dish/delete")
public class DishesDeleteController extends HttpServlet {
    
    private IDishesService dishesService = new DishesServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultVO resultVO = ResultVO.error(MessageConstant.DELETE_FAIL);
        try {
            String dishesId = request.getParameter("dishesId");
            if (!StringUtils.isEmpty(dishesId)) {
                resultVO = dishesService.deleteById(Integer.valueOf(dishesId));
            }
            if (resultVO.getSuccess()) {
                response.sendRedirect(request.getContextPath() + "/dish/search");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().write("<script>alert(" + resultVO.getMessage() + ");</script>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}