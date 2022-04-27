package com.wygplay.config;

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
 * @author wyg
 * @date 2022/4/26 21:23
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wygplay"))
                .paths(PathSelectors.any())
                .build()
                .groupName("user")
                .enable(true);
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Swagger3 api 文档")
                .description("文档描述信息")
                .contact(new Contact("wygplay", "#", "xyz@qq.com"))
                .version("1.0")
                .build();
    }
}
