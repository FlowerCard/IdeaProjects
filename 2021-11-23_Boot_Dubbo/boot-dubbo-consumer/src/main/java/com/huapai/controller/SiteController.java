package com.huapai.controller;

import com.huapai.api.SiteService;
import com.huapai.entity.Site;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/23.
 */
@RestController
@RequestMapping("/site")
public class SiteController {
    
//    @Reference
//    @Reference(id = "siteService", version = "default")
//    @Reference(id = "siteService", version = "async")
    @Reference(id = "siteService", version = "v2")
    private SiteService siteService;
    
    @GetMapping("/get/{id}")
    public Site getSiteById(@PathVariable Long id) {
        return siteService.getSiteById(id);
    }
    
    @GetMapping("/default/{name}")
    public String getSiteNameDefault(@PathVariable String name) {
        return siteService.siteName(name);
    }

    @GetMapping("/async/{name}")
    public String getSiteNameAsync(@PathVariable String name) {
        return siteService.siteName(name);
    }

    @GetMapping("/v2/{name}")
    public String getSiteNameV2(@PathVariable String name) {
        return siteService.siteName(name);
    }
    
}
