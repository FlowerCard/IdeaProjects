package com.huapai.dao;

import com.huapai.pojo.Table;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/22.
 */
public interface TableDao {

    /**
     * 通过ID查询
     * @param id ID
     * @return
     */
    Table queryById(@Param("id")Integer id);

    /**
     * 查询所有
     * @return
     */
    List<Table> queryAll();

    /**
     * 插入餐桌
     * @param table 餐桌对象
     * @return
     */
    Integer insertTable(Table table);

    /**
     * 修改餐桌
     * @param id id
     * @param name  名字
     * @param status 状态
     * @param time 时间
     * @return
     */
    Integer updateTableById(@Param("id")Integer id, @Param("name")String name, @Param("status")Integer status,
                            @Param("time")Date time);
    
}
