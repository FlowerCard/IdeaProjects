package com.huapai.dubbo.provider.service.impl;

import com.huapai.api.SiteService;
import com.huapai.entity.Site;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.protocol.rest.support.ContentType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/23.
 */
@Service(version = "rest", protocol = "protocol1")
@Path("site")
public class RestSiteServerImpl implements SiteService {
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
    @GET
    @Path("name")
    @Produces({ContentType.APPLICATION_JSON_UTF_8,ContentType.TEXT_PLAIN_UTF_8})
    public String siteName(String name) {
        return "rest: " + name;
    }
}
