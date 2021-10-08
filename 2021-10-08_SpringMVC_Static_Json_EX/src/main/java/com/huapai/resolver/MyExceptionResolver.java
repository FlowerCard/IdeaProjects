package com.huapai.resolver;

import com.huapai.exception.MyArithmeticException;
import com.huapai.exception.MyFormattingException;
import com.huapai.exception.MyIndexOutOfBoundsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/8.
 * 异常解析器
 */
@Controller
@SessionAttributes({"msg"})
public class MyExceptionResolver implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        // 分析异常对象的类型，执行对应的异常处理操作
        if (e instanceof MyArithmeticException) {
            System.err.println("算术运算异常");
            modelAndView.addObject("msg","算术运算异常");
            modelAndView.setViewName("redirect:/arithmetic.jsp");
        } else if (e instanceof MyFormattingException) {
            System.err.println("格式化异常");
            modelAndView.addObject("msg","格式化异常");
            modelAndView.setViewName("redirect:/formattion.jsp");
        } else if (e instanceof MyIndexOutOfBoundsException) {
            System.err.println("索引越界异常");
            modelAndView.addObject("msg","索引越界异常");
            modelAndView.setViewName("redirect:/outbounds.jsp");
        }
        return modelAndView;
    }
}
