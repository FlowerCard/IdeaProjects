package com.huapai.site.controlloer;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/3.
 */
@RestController
@RequestMapping("/site")
@RefreshScope
public class MySiteController {
    
    @GetMapping("/show")
    public String show(String name) {
        return "hello: " + name;
    }
    
}
