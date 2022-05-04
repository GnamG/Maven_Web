package com.fc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.List;

@Configuration
// 开启Swagger自动装置
@EnableSwagger2WebMvc
public class SwaggerConfig {
    // 装配Swagger的Bean对象：Docket
    @Bean
    public Docket docket_Meraki(){
        // 创建对象,使用Swagger作为文档类型
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo_Meraki())
                .groupName("Meraki")
                .globalOperationParameters(token())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fc"))
                .paths(PathSelectors.ant("/user/**"))
                .build();
    }
    // 设置全局参数
    private List<Parameter> token() {
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        ArrayList<Parameter> parameters = new ArrayList<>();
        // 参数名
        parameterBuilder.name("Authorization")
                .description("jwt令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .defaultValue("issue token")
                .scalarExample("header.payload.signature")
                .required(true);

        parameters.add(parameterBuilder.build());
        return parameters;
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

}
