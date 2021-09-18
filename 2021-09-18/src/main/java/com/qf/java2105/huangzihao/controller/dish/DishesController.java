package com.qf.java2105.huangzihao.controller.dish;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.qf.java2105.huangzihao.constant.MessageConstant;
import com.qf.java2105.huangzihao.constant.ResponseMessageConstant;
import com.qf.java2105.huangzihao.controller.BaseController;
import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.factory.BeanFacotry;
import com.qf.java2105.huangzihao.pojo.Dishes;
import com.qf.java2105.huangzihao.service.ICuisineService;
import com.qf.java2105.huangzihao.service.IDishesService;
import com.qf.java2105.huangzihao.utils.UploadUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/13.
 */
@WebServlet("/dish")
@MultipartConfig
public class DishesController extends BaseController {

    private ICuisineService cuisineService = (ICuisineService) BeanFacotry.getBean("cuisineService");
    private IDishesService dishesService = (IDishesService) BeanFacotry.getBean("dishesService");

    /**
     * 查询菜品
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dishName = request.getParameter("keyword");
        ResultVO<List<Dishes>> listResultVO = dishesService.queryByName(dishName);

        //回显搜索的数据
        request.setAttribute("keyword",dishName == null ? "" : dishName.trim());
        request.setAttribute("dishes",listResultVO.getData());
        return ResponseMessageConstant.PREFIX_FORWARD + request.getContextPath() + "/backend/detail/food/food-list.jsp";
    }

    /**
     * 判断菜品名词是否存在
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String exitisName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dishesName = request.getParameter("dishesName");
        ResultVO resultVO = dishesService.existsDishesName(dishesName);
        return JSON.toJSONString(resultVO);
    }

    /**
     * 新增菜品界面
     * 把菜系回显在下拉框中
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String saveui(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //把菜系列表查询出来
        ResultVO resultVO = cuisineService.queryByName("");
        request.setAttribute("cuisines",resultVO.getData());
        return ResponseMessageConstant.PREFIX_FORWARD + request.getContextPath() + "/backend/detail/food/food-save.jsp";
    }

    /**
     * 新增菜品
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultVO resultVO = ResultVO.error(MessageConstant.SAVE_FAIL);
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
                return ResponseMessageConstant.PREFIX_REDIRECT + request.getContextPath() + "/dish?method=search";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //失败
        return "<script>alert('" + resultVO.getMessage() + "');</script>";
    }

    /**
     * 更新菜品页面
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String updateui(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //把菜系列表查询出来
        ResultVO resultVO = cuisineService.queryByName("");
        request.setAttribute("cuisines",resultVO.getData());

        //获取需要更新的菜品ID
        String dishId = request.getParameter("dishId");
        ResultVO<Dishes> dishesResultVO = dishesService.queryById(Integer.valueOf(dishId));
        request.setAttribute("dishes",dishesResultVO.getData());

        return ResponseMessageConstant.PREFIX_FORWARD + request.getContextPath() + "/backend/detail/food/food-update.jsp";
    }

    /**
     * 更新菜品
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                return ResponseMessageConstant.PREFIX_REDIRECT + request.getContextPath() + "/dish?method=search";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //失败
        return "<script>alert('" + resultVO.getMessage() + "');</script>";
    }
    
    public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultVO resultVO = ResultVO.error(MessageConstant.DELETE_FAIL);
        try {
            String dishesId = request.getParameter("dishesId");
            if (!StringUtils.isEmpty(dishesId)) {
                resultVO = dishesService.deleteById(Integer.valueOf(dishesId));
            }
            if (resultVO.getSuccess()) {
                return ResponseMessageConstant.PREFIX_REDIRECT + request.getContextPath() + "/dish?method=search";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "<script>alert('" + resultVO.getMessage() + "');</script>";
    }
    
}
