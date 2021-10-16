package com.huapai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/16.
 * Swagger配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Swagger 会帮助我们自动生成接口文档
     * 1：配置生成的文档信息
     * 2：配置生成规则
     * 
     * Docket封装接口文档信息
     */
    @Bean
    public Docket getDocket(){
        //创建封面信息对象
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("《HuaPai后台系统》 接口说明")
                .description("此文档详细说明了HuaPai后台系统后端接口说明")
                .version("V 1.1.0")
                .contact( new Contact("HuaPai","", "HuaPai@odcn.live") );

        ApiInfo apiInfo = apiInfoBuilder.build();

        // 指定接口文档风格
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                 //指定生成的文档中的封面信息：文档标题、版本、作者
                .apiInfo(apiInfo)
                .select()
                // API扫描
                .apis(RequestHandlerSelectors.basePackage("com.huapai.controller"))
                // 路径指定
                .paths(PathSelectors.any())
                .build();
                    
        return docket;
    }
    
}
