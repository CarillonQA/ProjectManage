package com.pm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pm.controller"))
                .paths(PathSelectors.any())
                .build();
    }

//    public ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("通辽市人民检察院网站接口文档")
//                .description("该项目中所有返回参数皆是由ResponseEntity封装后的参数；\n" +
//                        "\n" +
//                        "项目在设计上默认顶层-检察院-部门，不考虑第四级组织；\n" +
//                        "\n" +
//                        "在密级设计上采用写死的密级设定（部门，检察院，公开）；\n" +
//                        "\n" +
//                        "异常皆由LzException处理后返回。")
//                .version("1.0")
//                .build();
//    }

}
