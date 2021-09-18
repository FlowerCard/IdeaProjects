package com.qf.java2105.huangzihao.controller.dish;

import com.qf.java2105.huangzihao.constant.MessageConstant;
import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.pojo.Dishes;
import com.qf.java2105.huangzihao.service.IDishesService;
import com.qf.java2105.huangzihao.service.impl.DishesServiceImpl;
import com.qf.java2105.huangzihao.utils.UploadUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 菜品更新控制器
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/12.
 */
@WebServlet("/dish/update")
@MultipartConfig
public class DishesUpdateController extends HttpServlet {
    
    private IDishesService dishesService = new DishesServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultVO resultVO = ResultVO.error(MessageConstant.UPDATE_FAIL);
        try {
            //获取图片路径
            String imageUrl = UploadUtil.upload(request, "imageUrl", "/image/dishes/");
            //获取前台传过来的所有参数
            Map<String, String[]> parameterMap = request.getParameterMap();
            Dishes dishes = new Dishes();
            BeanUtils.populate(dishes,parameterMap);
            //判断图片路径是否为空
            if (null != imageUrl && !"".equals(imageUrl)) {
                //不为空就把新的图片路径放入实体
                dishes.setDishesImg(imageUrl);
            }
            resultVO = dishesService.updateById(dishes);
            if (resultVO.getSuccess()) {
                response.sendRedirect(request.getContextPath() + "/dish/search");
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //失败
        response.getWriter().write("<script>alert(" + resultVO.getMessage() + ");</script>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}