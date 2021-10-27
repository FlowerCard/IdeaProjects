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
 * Created on 2021/10/27.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
    public Docket getDocket(){
        
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("Swagger文档定义练习")
                .description("此文档是为了练习Swagger")
                .version("V 1.0.0")
                .contact(new Contact("HuaPai","","HuaPai@odcn.live"));
        apiInfoBuilder.termsOfServiceUrl("https://github.com/FlowerCard");

        ApiInfo apiInfo = apiInfoBuilder.build();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.huapai.controller"))
                .paths(PathSelectors.any())
                .build();
        
    }
    
}
