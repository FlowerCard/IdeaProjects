package com.huapai.api;

import com.huapai.entity.Site;

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

    default String siteName(String name, String key, SiteServiceListener siteServiceListener) {
        return null;
    }
    
}
