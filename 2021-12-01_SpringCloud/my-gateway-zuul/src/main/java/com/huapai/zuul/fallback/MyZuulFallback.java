package com.huapai.zuul.fallback;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/2.
 * zuul实现熔断
 */
@Component
public class MyZuulFallback implements FallbackProvider {

    /**
     * 指定哪些服务做错误回调（熔断）
     * @return
     */
    @Override
    public String getRoute() {
        // 对指定的服务器进行错误回调
//        return "MY-USER-PROVIDER";
        // 对所有的服务器进行错误回调
        return null;
    }

    /**
     * 具体怎么回调 --- 封装响应信息
     * @param route
     * @param cause
     * @return
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            // 状态码
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.toString();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                /*
                    code
                    message
                    data
                 */
                Map<String,Object> map = new HashMap<>();
                map.put("code",1000);
                map.put("message","fallback");
                map.put("data",null);
                // map ---> json
                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writeValueAsString(map);
                // 把字符串写进输入流
                ByteArrayInputStream inputStream = new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8));
                return inputStream;
            }

            /**
             * 响应消息头
             * @return
             */
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                return httpHeaders;
            }
        };
    }
}
