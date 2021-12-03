package com.huapai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/3.
 */
@RestController
@RequestMapping("/site")
public class MySiteConsumerController {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping("/show")
    public String show(String name) {
        String url = "http://my-provider-nacos/site/show?name=" + name;
        return restTemplate.getForObject(url, String.class);
    }
    
}
