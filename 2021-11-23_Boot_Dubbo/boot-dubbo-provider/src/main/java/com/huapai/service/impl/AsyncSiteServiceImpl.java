package com.huapai.service.impl;

import com.huapai.api.SiteService;
import com.huapai.entity.Site;
import org.apache.dubbo.config.annotation.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/23.
 */
@Service(version = "async")
public class AsyncSiteServiceImpl implements SiteService {
    /**
     * 通过ID获取工地
     *
     * @param id 工地id
     * @return 工地对象
     */
    @Override
    public Site getSiteById(Long id) {
        return null;
    }

    /**
     * 工地名称
     *
     * @param name 名称
     * @return 工地名称
     */
    @Override
    public String siteName(String name) {
        return "async: " + name;
    }

    @Override
    public CompletableFuture<String> siteNameAsync(String name) {
        System.out.println("异步调用： " + name);
        return CompletableFuture.supplyAsync(() -> {
            return siteName(name);
        });
    }
}
