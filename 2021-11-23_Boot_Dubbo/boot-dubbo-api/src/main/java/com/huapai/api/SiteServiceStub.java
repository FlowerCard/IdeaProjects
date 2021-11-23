package com.huapai.api;

import com.huapai.entity.Site;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/23.
 */
public class SiteServiceStub implements SiteService{
    
    private final SiteService siteService;
    
    public SiteServiceStub(SiteService siteService) {
        this.siteService = siteService;
    }
    
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
        try {
            return siteService.siteName(name    );
        } catch (Exception e) {
            return "stub: " + name;
        }
    }
}
