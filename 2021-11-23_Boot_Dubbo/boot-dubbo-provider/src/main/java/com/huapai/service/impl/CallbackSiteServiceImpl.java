package com.huapai.service.impl;

import com.huapai.api.SiteService;
import com.huapai.api.SiteServiceListener;
import com.huapai.entity.Site;
import org.apache.dubbo.config.annotation.Argument;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/23.
 */
@Service(version = "callback", methods = {
        @Method(name = "siteName", arguments = {@Argument(index = 2, callback = true)})
},callbacks = 3)
public class CallbackSiteServiceImpl implements SiteService {
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
        return null;
    }

    @Override
    public String siteName(String name, String key, SiteServiceListener siteServiceListener) {
        siteServiceListener.changed("provider data");
        return "callback: " + name;
    }
}
