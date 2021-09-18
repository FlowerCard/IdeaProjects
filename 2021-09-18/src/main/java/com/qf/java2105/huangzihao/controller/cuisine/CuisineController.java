package com.qf.java2105.huangzihao.controller.cuisine;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.qf.java2105.huangzihao.constant.MessageConstant;
import com.qf.java2105.huangzihao.constant.ResponseMessageConstant;
import com.qf.java2105.huangzihao.controller.BaseController;
import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.factory.BeanFacotry;
import com.qf.java2105.huangzihao.pojo.Cuisine;
import com.qf.java2105.huangzihao.service.ICuisineService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/13.
 */
@WebServlet("/cuisine")
@MultipartConfig
public class CuisineController extends BaseController {
    
    private ICuisineService cuisineService = (ICuisineService) BeanFacotry.getBean("cuisineService");
    
    public String queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //从session中获取菜系
        List<Cuisine> cuisineList = (List<Cuisine>) session.getAttribute("cuisines");
        if (cuisineList == null || cuisineList.size() == 0) {
            //session中没有菜系列表 查询菜系列表
            ResultVO resultVO = cuisineService.queryByName("");
            session.setAttribute("cuisineList",resultVO.getData());
            return JSON.toJSONString(resultVO);
        }
        return JSON.toJSONString(ResultVO.ok(MessageConstant.HAS_DATA));
    }

    /**
     * 搜索
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cuisineName = request.getParameter("keyword");
        ResultVO resultVO = cuisineService.queryByName(cuisineName);
        request.setAttribute("keyword",cuisineName == null ? "" : cuisineName.trim());
        request.setAttribute("cuisines",resultVO.getData());
        return ResponseMessageConstant.PREFIX_FORWARD + request.getContextPath() + "/backend/detail/foodtype/foodtype-list.jsp";
    }

    /**
     * 判断菜系名称是否存在
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String exitisName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cuisineName = request.getParameter("cuisineName");
        ResultVO resultVO = cuisineService.existsCuisineName(cuisineName);
        return JSON.toJSONString(resultVO);
    }
    
    public String save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultVO resultVO = ResultVO.error(MessageConstant.DELETE_FAIL);
        try {
            String cuisineName = request.getParameter("name");
            if (!StringUtils.isEmpty(cuisineName)) {
                Cuisine cuisine = new Cuisine(null,cuisineName,new Date(),new Date(),1);
                resultVO = cuisineService.save(cuisine);
            }
            if (resultVO.getSuccess()) {
                //成功就去菜系列表页
                return ResponseMessageConstant.PREFIX_FORWARD + request.getContextPath() + "/cuisine?method=search";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "<script>alert(" + resultVO.getMessage() + ");</script>";
    }

    /**
     * 更新界面
     * 更新页上的
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String updateui(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String typeId = request.getParameter("typeId");
        //判断传过的ID是否为空
        if (!StringUtils.isEmpty(typeId)) {
            ResultVO<Cuisine> cuisineResultVO = cuisineService.queryById(Integer.valueOf(typeId));
            request.setAttribute("cuisines",cuisineResultVO.getData());
        }
        return ResponseMessageConstant.PREFIX_FORWARD + request.getContextPath() + "/backend/detail/foodtype/foodtype-update.jsp";
    }

    /**
     * 更新菜系
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            return ResponseMessageConstant.PREFIX_FORWARD + request.getContextPath() + "/cuisine?method=search";
        } else {
            return ResponseMessageConstant.PREFIX_FORWARD + request.getContextPath() + "/cuisine?method=updateui";
        }
    }

    /**
     * 删除菜系
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultVO resultVO = ResultVO.error(MessageConstant.DELETE_FAIL);
        try {
            String typeId = request.getParameter("typeId");
            if (!StringUtils.isEmpty(typeId)) {
                //ID不为空就删除对应ID的记录
                resultVO =  cuisineService.deleteById(Integer.valueOf(typeId));
            }
            if (resultVO.getSuccess()) {
                return ResponseMessageConstant.PREFIX_FORWARD + request.getContextPath() + "/cuisine?method=search";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "<script>alert('" + resultVO.getMessage() + "');</script>";
    }

}