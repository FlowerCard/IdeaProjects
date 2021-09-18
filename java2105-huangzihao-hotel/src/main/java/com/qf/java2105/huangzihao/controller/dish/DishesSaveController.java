package com.qf.java2105.huangzihao.controller.dish;

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
 * 菜品保存控制器
 * 增加流数据配置
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/12.
 */
@WebServlet("/dish/save")
@MultipartConfig
public class DishesSaveController extends HttpServlet {
    
    private IDishesService dishesService = new DishesServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultVO resultVO = null;
        try {
            
            //上传文件
            String path = UploadUtil.upload(request,"imageUrl","/image/dishes/");
            
            //获得全部数据封装成集合
            Map<String, String[]> parameterMap = request.getParameterMap();
            Dishes dishes = new Dishes();
            //把map中数据封装到实体中，前提条件，map的key必须和实体的属性名一致
            BeanUtils.populate(dishes,parameterMap);
            //把图片路径放入实体
            dishes.setDishesImg(path);
            resultVO = dishesService.save(dishes);
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