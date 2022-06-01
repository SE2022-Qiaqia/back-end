package com.whu.se2022.qiaqia.coursesystem.config;
import io.swagger.annotations.ApiOperation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket platformApi() {

        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
//                .forCodeGeneration(true)
                .select()
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.any())
                .build();
    }

    private List<SecurityScheme> securitySchemes(){
        List<SecurityScheme> schemes = new ArrayList<>();
        schemes.add(HttpAuthenticationScheme.JWT_BEARER_BUILDER.name("Authorization").build());
        return schemes;
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts=new ArrayList<>();
        securityContexts.add(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .operationSelector(operationContext -> !operationContext.requestMappingPattern().equals("/login/login") && !operationContext.requestMappingPattern().equals("/login/register"))
                        .build());
        return securityContexts;
    }

    List<SecurityReference> defaultAuth() {
        List<SecurityReference> references = new ArrayList<>();
        references.add(new SecurityReference("Authorization", new AuthorizationScope[0]));
        return references;
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("qiaqia选课系统")
                .description("©2022 Copyright. Powered By qiaqia group.")
                // .termsOfServiceUrl("")
                .contact(new Contact("qiaqia", "", "3298520845@qq.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE").version("2.0").build();
    }

}
