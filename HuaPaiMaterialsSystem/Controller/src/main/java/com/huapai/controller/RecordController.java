package com.huapai.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huapai.entity.Record;
import com.huapai.entity.ResultVO;
import com.huapai.service.IRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("record")
public class RecordController {
    
    @Resource
    private IRecordService recordService;
    
    @GetMapping("/getAll")
    @ResponseBody
    public ResultVO getAllRecord(Integer page, Integer limit){
        List<Record> recordList = recordService.queryAll();
        PageHelper.startPage(page,limit);
        PageInfo<Record> pageInfo = new PageInfo<>(recordList);
        ResultVO resultVO = new ResultVO();
        if (recordList.size() != 0) {
            resultVO.setCode(0);
            resultVO.setData(pageInfo.getList());
            resultVO.setCount((int) pageInfo.getTotal());
        }
        return resultVO;
    }

    @RequestMapping("/deleteRecord")
    @ResponseBody
    public ResultVO deleteRecord(Integer id){
        recordService.removeRecord(id);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        return resultVO;
    }
    
}
