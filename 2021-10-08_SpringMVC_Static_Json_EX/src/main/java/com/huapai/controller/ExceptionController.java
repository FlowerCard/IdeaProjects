package com.huapai.controller;

import com.alibaba.fastjson.JSONObject;
import com.huapai.exception.MyArithmeticException;
import com.huapai.exception.MyFormattingException;
import com.huapai.exception.MyIndexOutOfBoundsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/8.
 */
@RestController
@RequestMapping("ex")
public class ExceptionController {
    
    @RequestMapping("ex01")
    public String ex01(Integer num){
        System.out.println("ExceptionController ===> ex01 ===> num ===> " + num);
        try {
            if (num == 0) {
                throw new MyArithmeticException("算术运算异常");
            } else if (num == 1) {
                throw new MyFormattingException("格式化异常");
            } else if (num == 2) {
                throw new MyIndexOutOfBoundsException("索引越界异常");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }
    
    @RequestMapping("ex02")
    public String ex02(Integer num){
        System.out.println("ExceptionController ===> ex01 ===> num ===> " + num);
        try {
            if (num == 0) {
                throw new MyArithmeticException("算术运算异常");
            } else if (num == 1) {
                throw new MyFormattingException("格式化异常");
            } else if (num == 2) {
                throw new MyIndexOutOfBoundsException("索引越界异常");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "success";
    }
    
    @RequestMapping("/ex03")
    public void ex03(Integer num){
        System.out.println("ExceptionController ===> ex01 ===> num ===> " + num);
        if (num == 0) {
            throw new MyArithmeticException("算术运算异常");
        } else if (num == 1) {
            throw new MyFormattingException("格式化异常");
        } else if (num == 2) {
            throw new MyIndexOutOfBoundsException("索引越界异常");
        }
    }
    
}
