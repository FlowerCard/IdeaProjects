package com.huapai.api;

import com.huapai.entity.Site;

import java.util.concurrent.CompletableFuture;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/23.
 */
public interface SiteService {

    /**
     * 通过ID获取工地
     * @param id 工地id
     * @return 工地对象
     */
    Site getSiteById(Long id);

    /**
     * 工地名称
     * @param name 名称
     * @return 工地名称
     */
    String siteName(String name);

    //回调方法
    default String siteName(String name, String key, SiteServiceListener siteServiceListener) {
        return null;
    }

    //异步调用方法
    default CompletableFuture<String> siteNameAsync(String name) {
        return null;
    }
    
}
