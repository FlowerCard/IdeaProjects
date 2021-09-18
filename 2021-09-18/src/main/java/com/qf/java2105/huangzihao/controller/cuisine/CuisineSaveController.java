package com.qf.java2105.huangzihao.controller.cuisine;

import com.alibaba.druid.util.StringUtils;
import com.qf.java2105.huangzihao.constant.MessageConstant;
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
import java.util.Date;

/**
 * 菜系保持控制器
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/12.
 */
@WebServlet("/cuisine/save")
public class CuisineSaveController extends HttpServlet {
    
    private ICuisineService cuisineService = new CuisineServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultVO resultVO = ResultVO.error(MessageConstant.DELETE_FAIL);
        try {
            String cuisineName = request.getParameter("name");
            if (!StringUtils.isEmpty(cuisineName)) {
                Cuisine cuisine = new Cuisine(null,cuisineName,new Date(),new Date(),1);
                resultVO = cuisineService.save(cuisine);
            }
            if (resultVO.getSuccess()) {
                //成功就去菜系列表页
                request.getRequestDispatcher(request.getContextPath() + "/cuisine/search").forward(request,response);
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