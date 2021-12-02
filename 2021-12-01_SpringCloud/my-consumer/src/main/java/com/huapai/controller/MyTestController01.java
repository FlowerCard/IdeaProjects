package com.huapai.controller;

import com.huapai.po.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sun.jndi.toolkit.url.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/1.
 */
@RestController
@RequestMapping("/test01")
public class MyTestController01 {
    
    @Autowired
    private RestTemplate restTemplate;
    
    private String serverName = "MY-USER-PROVIDER";

    @GetMapping("/show")
    @HystrixCommand(fallbackMethod = "hiError")
    public String test01(Long id) {
        String url = "http://" + serverName + "/test01/show?id=" + id;
        return restTemplate.getForObject(url, String.class);
    }
    
    // 预设的结果
    public String hiError(Long id) {
        return "Hello Hystrix";
    }
    
    @GetMapping("/get1")
    public String get1(Long id, String name) {
        String url = "http://" + serverName + "/test01/get1?id={1}&name={2}";
        // 响应消息
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, new Object[]{id,name});
        // 获取响应消息 responseEntity 中的响应体
        return responseEntity.getBody();
    }
    
    @GetMapping("/get2")
    public String get2(Long id, String name) {
        String url = "http://" + serverName + "/test01/get1?id="+id+"&name="+name;
        HashMap<String ,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, map);
        // 响应数据：头  行  体
        return responseEntity.getHeaders() + " \n " +  responseEntity.getStatusCode() + " \n " + responseEntity.getBody();
    }
    
    @GetMapping("/get3")
    public String get3(Long id, String name) throws URISyntaxException {
        String url = "http://" + serverName + "test01/get1?id=" + id + "&name=" + name;
        URI uri = new URI(url);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
        return responseEntity.getBody();
    }
    
    @PostMapping("/post1")
    public String post1(@RequestBody User user) {
        String url = "http://" + serverName + "/test01/post1";
        return restTemplate.postForObject(url, user, String.class);
    }
    
    @PostMapping("post2")
    public String post2(@RequestBody User user, @CookieValue(required = false) String token) {
        String url = "http://" + serverName + "/test01/post1";
        // 封装请求头，携带cookie
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put(HttpHeaders.COOKIE, Arrays.asList("token=" + token));
        // 封装请求信息，请求消息中包含消息体 user 和 消息头 headers
        HttpEntity httpEntity = new HttpEntity(user, httpHeaders);
        return restTemplate.postForObject(url, httpEntity, String.class);
    }
    
}
