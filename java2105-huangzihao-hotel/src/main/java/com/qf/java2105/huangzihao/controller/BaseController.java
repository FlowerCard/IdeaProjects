package com.qf.java2105.huangzihao.controller;

import com.qf.java2105.huangzihao.constant.RequestMethodConstant;
import com.qf.java2105.huangzihao.constant.ResponseMessageConstant;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/13.
 */
public class BaseController extends HttpServlet {

    /**
     * 处理请求
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;
            
            //反射调用方法
            String methodName = request.getParameter(RequestMethodConstant.METHOD);
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            //得到返回值
            Object invoke = method.invoke(this, request, response);
            //   forward:/food?method=search
            //   redirect:/food?method=search

            if (invoke instanceof String) {
                String info = (String) invoke;
                //   redirect:/food?method=search  拿到 : 后面的URL地址
                String url = info.substring(info.indexOf(ResponseMessageConstant.TAG) + 1);
                if (info.startsWith(ResponseMessageConstant.PREFIX_FORWARD)) {
                    request.getRequestDispatcher(url).forward(request,response);
                } else if (info.startsWith(ResponseMessageConstant.PREFIX_REDIRECT)) {
                    response.sendRedirect(url);
                } else {
                    response.getWriter().write(info);
                }
            } else {
                response.getWriter().write("服务器正忙，请稍后再试");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}