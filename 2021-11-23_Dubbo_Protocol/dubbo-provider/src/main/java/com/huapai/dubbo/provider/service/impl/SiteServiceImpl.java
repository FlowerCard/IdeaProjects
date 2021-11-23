package com.huapai.dubbo.provider.service.impl;

import com.huapai.api.SiteService;
import com.huapai.entity.Site;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/23.
 */
@Service(version = "default", protocol = "protocol2")
public class SiteServiceImpl implements SiteService {
    /**
     * 通过id获取工地对象
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
        return "default: " + name;
    }
}
