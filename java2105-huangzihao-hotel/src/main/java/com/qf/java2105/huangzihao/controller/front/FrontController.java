package com.qf.java2105.huangzihao.controller.front;

import com.alibaba.druid.util.StringUtils;
import com.qf.java2105.huangzihao.constant.ResponseMessageConstant;
import com.qf.java2105.huangzihao.controller.BaseController;
import com.qf.java2105.huangzihao.entity.PageBean;
import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.factory.BeanFacotry;
import com.qf.java2105.huangzihao.pojo.Dishes;
import com.qf.java2105.huangzihao.service.IDishesService;
import com.qf.java2105.huangzihao.service.IFrontService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 分页查询业务层模块
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/14.
 */
@WebServlet("/front")
public class FrontController extends BaseController {
    
    private IFrontService frontService = (IFrontService) BeanFacotry.getBean("frontService");
    private IDishesService dishesService = (IDishesService) BeanFacotry.getBean("dishesService");

    /**
     * 前台显示菜品
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer currentPage = 1;
        Integer cuisineId = 0;
        String currentPageStr = request.getParameter("currentPage");
        String cuisineIdStr = request.getParameter("cuisineId");
        String dishesName = request.getParameter("dishesName");
        if (!StringUtils.isEmpty(currentPageStr)) {
            currentPage = Integer.valueOf(currentPageStr);
        }
        if (!StringUtils.isEmpty(cuisineIdStr)) {
            cuisineId = Integer.valueOf(cuisineIdStr);   
        }
        if (StringUtils.isEmpty(dishesName)) {
            dishesName = "%%";
        } else {
            dishesName = "%" + dishesName + "%";
        }
        ResultVO<PageBean<Dishes>> pageBeanResultVO = frontService.queryByPage(currentPage, 6, cuisineId, dishesName);
        request.setAttribute("pageBean",pageBeanResultVO.getData());
        request.setAttribute("cuisineId",cuisineId);
        request.setAttribute("dishesName",dishesName.replaceAll("%",""));
        
        return ResponseMessageConstant.PREFIX_FORWARD + request.getContextPath() + "/front/detail/caidan.jsp";
    }

    /**
     * 前台显示菜品详情
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String dishesDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dishesId = request.getParameter("dishesId");
        ResultVO<Dishes> dishesResultVO = dishesService.queryById(Integer.valueOf(dishesId));
        request.setAttribute("dishesDetail",dishesResultVO.getData());
        return ResponseMessageConstant.PREFIX_FORWARD + request.getContextPath() + "/front/detail/caixiangxi.jsp";
    }
    
}
