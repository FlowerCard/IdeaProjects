package com.qf.java2105.huangzihao.controller.user;

import com.alibaba.fastjson.JSON;
import com.qf.java2105.huangzihao.constant.MessageConstant;
import com.qf.java2105.huangzihao.constant.ResponseMessageConstant;
import com.qf.java2105.huangzihao.controller.BaseController;
import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.factory.BeanFacotry;
import com.qf.java2105.huangzihao.pojo.User;
import com.qf.java2105.huangzihao.service.IUserService;
import com.qf.java2105.huangzihao.utils.MD5Utils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 用户管理层模块
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/14.
 */
@WebServlet("/user")
public class UserController extends BaseController {
    
    private IUserService userService = (IUserService) BeanFacotry.getBean("userService");

    /**
     * 登录
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String inputVcode = request.getParameter("inputVcode");
        String vCode = (String) request.getSession().getAttribute("vCode");
        String destroy = request.getParameter("destroy");

        if (null != destroy && 1 == Integer.parseInt(destroy)) {
            request.getSession().removeAttribute("loginUser");
        }

        if (null == inputVcode || "".equals(inputVcode.trim()) || null == username || "".equals(username.trim())
                || null == password || "".equals(password.trim())) {
            // 如果传过来是空值，则回到登录页
            return ResponseMessageConstant.PREFIX_REDIRECT + request.getContextPath() + "/front/login.jsp";
        }

        if (!inputVcode.equalsIgnoreCase(vCode)) {
            // 如果验证不正确，则回到登录页
            return ResponseMessageConstant.PREFIX_REDIRECT + request.getContextPath() + "/front/login.jsp";
        }

        ResultVO<User> resultVO = userService.login(username, password);
        if (resultVO.getSuccess()) {
            User user = resultVO.getData();
            request.getSession().setAttribute("loginUser",user);
            return ResponseMessageConstant.PREFIX_REDIRECT + request.getContextPath() + "/front/index.jsp";
        } else {
            return ResponseMessageConstant.PREFIX_REDIRECT + request.getContextPath() + "/front/login.jsp";
        }
    }

    /**
     * 注册
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nickname = request.getParameter("nickname");

        if (null == nickname || "".equals(nickname.trim()) || null == username || "".equals(username.trim())
                || null == password || "".equals(password.trim())) {
            // 如果传过来是空值，则回到注册页
            return ResponseMessageConstant.PREFIX_REDIRECT + request.getContextPath() + "/front/register.jsp";
        }
        
        User user = new User();
        user.setUsername(username);
        user.setNickname(nickname);
        password = MD5Utils.md5(password);
        user.setPassword(password);
        ResultVO<String> register = userService.register(user);
        if (register.getSuccess()) {
            return ResponseMessageConstant.PREFIX_REDIRECT + request.getContextPath() + "/front/login.jsp";
        } else {
            return ResponseMessageConstant.PREFIX_REDIRECT + request.getContextPath() + "/front/register.jsp";
        }

    }

    /**
     * 查询用户
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("keyword");
        ResultVO<List<User>> resultVO = userService.search(username);

        request.setAttribute("keyword",username == null ? "" : username.trim());
        request.setAttribute("userList",resultVO.getData());
        return ResponseMessageConstant.PREFIX_FORWARD + request.getContextPath() + "/backend/detail/user/user-list.jsp";
    }

    /**
     * 用户更新界面
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String updateui(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultVO resultVO = ResultVO.error(MessageConstant.QUERY_FAIL);
        try {
            String userId = request.getParameter("userId");
            ResultVO<User> updateui = userService.updateui(Integer.valueOf(userId));
            request.setAttribute("userInfo",updateui.getData());
            return ResponseMessageConstant.PREFIX_FORWARD + request.getContextPath() + "/backend/detail/user/user-update.jsp";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "<script>alert('" + resultVO.getMessage() + "');</script>";
    }

    /**
     * 更新用户
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultVO resultVO = ResultVO.error(MessageConstant.UPDATE_FAIL);
        try {
            //获取前台传过来的所有参数
            Map<String, String[]> parameterMap = request.getParameterMap();
            User user = new User();
            BeanUtils.populate(user,parameterMap);
            resultVO = userService.update(user);
            if (resultVO.getSuccess()) {
                return ResponseMessageConstant.PREFIX_REDIRECT + request.getContextPath() + "/user?method=search";
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
            String userId = request.getParameter("userId");
            resultVO = userService.deleteById(Integer.valueOf(userId));
            if (resultVO.getSuccess()) {
                return ResponseMessageConstant.PREFIX_REDIRECT + request.getContextPath() + "/user?method=search";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //失败
        return "<script>alert('" + resultVO.getMessage() + "');</script>";
    }

    /**
     * 名字是否存在
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String exitisName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usernameVal = request.getParameter("usernameVal");
        ResultVO<String> resultVO = userService.exitisName(usernameVal);
        return JSON.toJSONString(resultVO);
    }
    
}
