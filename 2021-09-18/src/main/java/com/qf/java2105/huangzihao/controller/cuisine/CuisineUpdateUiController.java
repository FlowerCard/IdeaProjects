package com.qf.java2105.huangzihao.controller.cuisine;

import com.alibaba.druid.util.StringUtils;
import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.pojo.Cuisine;
import com.qf.java2105.huangzihao.service.ICuisineService;
import com.qf.java2105.huangzihao.service.impl.CuisineServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 菜系更新界面控制器
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/12.
 */
@WebServlet("/cuisine/updateui")
public class CuisineUpdateUiController extends HttpServlet {

    private ICuisineService cuisineService = new CuisineServiceImpl();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String typeId = request.getParameter("typeId");
        //判断传过的ID是否为空
        if (!StringUtils.isEmpty(typeId)) {
            ResultVO<Cuisine> cuisineResultVO = cuisineService.queryById(Integer.valueOf(typeId));
            request.setAttribute("cuisines",cuisineResultVO.getData());
        }
        request.getRequestDispatcher(request.getContextPath() + "/backend/detail/foodtype/foodtype-update.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}