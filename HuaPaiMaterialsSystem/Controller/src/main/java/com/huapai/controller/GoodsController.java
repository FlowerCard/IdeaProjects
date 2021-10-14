package com.huapai.controller;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huapai.entity.Goods;
import com.huapai.entity.ResultVO;
import com.huapai.entity.User;
import com.huapai.service.IGoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/12.
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    //
    
    @Resource
    private IGoodsService goodsService;
    
    @GetMapping("/allGoods/{goodsName}")
    @ResponseBody
    public ResultVO searchAll(Integer page, Integer limit,@PathVariable String goodsName){
        List<Goods> goodsList = new ArrayList<>();
        if ("undefined".equals(goodsName)) {
            goodsName = null;
        }
        if (StringUtils.isEmpty(goodsName)) {
            goodsList = goodsService.queryAll();
        } else {
            goodsList = goodsService.queryByName(goodsName);
        }
        PageHelper.startPage(page,limit);
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
        ResultVO resultVO = new ResultVO();
        if (goodsList.size() != 0) {
            resultVO.setCode(0);
            resultVO.setData(pageInfo.getList());
            resultVO.setCount((int) pageInfo.getTotal());
        }
        return resultVO;
    }
    
    @RequestMapping("/getGoods")
    @ResponseBody
    public Goods getGoods(Integer id){
        return goodsService.queryById(id);
    }

    @GetMapping("/addGoods/{goodsId}")
    @ResponseBody
    public Boolean existTypeId(@PathVariable Integer goodsId){
        return goodsService.existGoodsId(goodsId);
    }
    
    @RequestMapping("/addGoods")
    public String addGoods(Goods goods){
        goodsService.addGoods(goods);
        return "redirect:/goods/goodsList.jsp";
    }
    
    @RequestMapping("/modifyGoods")
    public String modifyGoods(Goods goods){
        goodsService.modifyGoods(goods);
        return "redirect:/goods/goodsList.jsp";
    }
    
    @RequestMapping("/deleteGoods")
    @ResponseBody
    public ResultVO deleteGoods(Integer id){
        goodsService.removeGoods(id);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        return resultVO;
    }
    
    @RequestMapping("/outGoods")
    public String outGoods(Integer id, Integer outNum, HttpSession session){
        User userInfo = (User) session.getAttribute("userInfo");
        goodsService.outGoods(id,outNum, userInfo.getId());
        return "redirect:/goods/goodsList.jsp";
    }
    
    @RequestMapping("/inGoods")
    public String inGoods(Integer id,Integer inNum, HttpSession session){
        User userInfo = (User) session.getAttribute("userInfo");
        goodsService.inGoods(id,inNum,userInfo.getId());
        return "redirect:/goods/goodsList.jsp";
    }
    
}
