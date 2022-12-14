package com.pm;

import com.pm.config.CmsProperties;
import com.pm.config.JwtProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@MapperScan("com.pm.dao")
@EnableConfigurationProperties({JwtProperties.class, CmsProperties.class})
public class PMApplication {

    public static void main(String[] args) {
        SpringApplication.run(PMApplication.class, args);
    }

}
