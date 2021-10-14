package com.huapai.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huapai.entity.GoodsType;
import com.huapai.entity.ResultVO;
import com.huapai.service.IGoodsTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/12.
 */
@Controller
@RequestMapping("/goodsType")
public class GoodsTypeController {
    
    @Resource
    private IGoodsTypeService goodsTypeService;
    
    @GetMapping("/allType")
    @ResponseBody
    public ResultVO searchAll(Integer page,Integer limit){
        List<GoodsType> goodsTypeList = goodsTypeService.searchAll();
        PageHelper.startPage(page, limit);
        PageInfo<GoodsType> pageInfo = new PageInfo<>(goodsTypeList);
        ResultVO resultVO = new ResultVO();
        if (goodsTypeList.size() != 0) {
            resultVO.setCode(0);
            resultVO.setData(pageInfo.getList());
            resultVO.setCount((int) pageInfo.getTotal());
        }
        return resultVO;
    }
    
    @GetMapping("/getType")
    @ResponseBody
    public GoodsType searchType(Integer id){
        return goodsTypeService.searchById(id);
    }

    @GetMapping("/addType/{typeId}")
    @ResponseBody
    public Boolean existTypeId(@PathVariable Integer typeId){
        return goodsTypeService.existTypeId(typeId);
    }
    
    @RequestMapping("/addType")
    public String addGoodsType(GoodsType goodsType){
        goodsTypeService.addGoodsType(goodsType);
        return "redirect:/type/goodsTypeList.jsp";
    }
    
    @RequestMapping("/modifyType")
    public String modifyGoodsType(GoodsType goodsType){
        goodsTypeService.modifyGoodsType(goodsType);
        return "redirect:/type/goodsTypeList.jsp";
    }
    
    @RequestMapping("/deleteType")
    @ResponseBody
    public ResultVO deleteGoodsType(Integer id){
        Boolean flag = goodsTypeService.removeGoodsType(id);
        ResultVO resultVO = new ResultVO();
        if (flag) {
            resultVO.setCode(0);
        }
        return resultVO;
    }
    
}
