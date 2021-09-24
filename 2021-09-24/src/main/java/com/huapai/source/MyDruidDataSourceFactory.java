package com.huapai.source;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/24.
 */
public class MyDruidDataSourceFactory extends PooledDataSourceFactory {
    public MyDruidDataSourceFactory(){
        this.dataSource = new DruidDataSource();
    }
}
