package com.dalaoyang.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//指定test、dev环境可用。对应application-test.yml、application-dev.yml
//@Profile({"test","dev"})
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("人员管理")
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.emp.manage.demo.controller"))
                .apis(RequestHandlerSelectors.basePackage("com.dalaoyang.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口")
                .description("人员相关api文档")
                .version("1.0")
                .build();
    }
}
