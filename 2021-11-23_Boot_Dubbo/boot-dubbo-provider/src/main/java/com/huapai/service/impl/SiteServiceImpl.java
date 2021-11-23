package com.huapai.service.impl;

import com.huapai.api.SiteService;
import com.huapai.entity.Site;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/23.
 */
@Service
public class SiteServiceImpl implements SiteService {
    /**
     * 通过ID获取工地
     *
     * @param id 工地id
     * @return 工地对象
     */
    @Override
    public Site getSiteById(Long id) {
        Site site = new Site();
        site.setId(id);
        return site;
    }

    /**
     * 工地名称
     *
     * @param name 名称
     * @return 工地名称
     */
    @Override
    public String siteName(String name) {
        return null;
    }
}
