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
 * 菜系更新控制器
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/12.
 */
@WebServlet("/cuisine/update")
public class CuisineUpdateController extends HttpServlet {
    
    private ICuisineService cuisineService = new CuisineServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cuisineName = request.getParameter("name");
        String cuisineId = request.getParameter("cid");
        //用户ID
        String userId = request.getParameter("uid");

        //修改之前先把原来的数据查出来
        ResultVO<Cuisine> cuisineResultVO = cuisineService.queryById(Integer.valueOf(cuisineId));
        Cuisine data = cuisineResultVO.getData();
        request.setAttribute("cuisines",data);
        //判断前台传过来的菜系名称是否为空，以及判断名字是否和原来的一样
        if (!StringUtils.isEmpty(cuisineName) && !cuisineName.equals(data.getCuisineName())) {
            cuisineService.updateById(Integer.valueOf(cuisineId), cuisineName, Integer.valueOf(userId));
            request.getRequestDispatcher(request.getContextPath() + "/cuisine/search").forward(request,response);
        } else {
            request.getRequestDispatcher(request.getContextPath() + "/cuisine/updateui").forward(request,response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}