package com.fc.congfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class Swagger3Config {
    // 装配Swagger的Bean对象:Docket
    // 装配Swagger的Bean对象：Docket
    @Bean
    public Docket docket_Meraki(){
        // 创建对象,使用Swagger作为文档类型
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo_Meraki())
                .groupName("Meraki")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fc"))
                .paths(PathSelectors.ant("/user/**"))
                .build()
                // 安全环境
                .securityContexts(securityContexts())
                .securitySchemes(securitySchemes());
    }
    // 全局配置授权信息
    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(getSecurityContext());
        return securityContexts;
    }
    // 安全环境设置
    private SecurityContext getSecurityContext() {
        List<SecurityReference> references = new ArrayList<>();
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "参数的描述：Token");
        AuthorizationScope[] scopes = new AuthorizationScope[1];

        scopes[0] = authorizationScope;

        references.add(new SecurityReference("taken",scopes));
        return SecurityContext.builder().securityReferences(references).build();
    }

    // 设置授权信息
    private List<SecurityScheme> securitySchemes() {
        ApiKey key = new ApiKey("token", "token", "header");
        return Collections.singletonList(key);
    }

    @Bean
    public Docket docket_NIXL(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo_newL())
                .groupName("NewL")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fc"))
                .paths(PathSelectors.ant("/user/**"))
                .build();
    }



    private ApiInfo apiInfo_Meraki() {
        return new ApiInfoBuilder()
                .title("Meraki的")
                .version("3.1")
                .description("用户模块相关的内容")
                .contact(new Contact("Meraki","https://github.com/GnamG","635702657@qq.com"))
                .license("Apache License, Version 2.0")
                .termsOfServiceUrl("https://swagger.io")
                .build();
    }

    private ApiInfo apiInfo_newL(){
        return new ApiInfoBuilder()
                .title("newL的代码")
                .version("2.0")
                .description("登录相关的内容")
                .contact(new Contact("newL","https://github.com/NIXL27",""))
                .license("Apache License, Version 2.0")
                .termsOfServiceUrl("https://swagger.io")
                .build();
    }
}
