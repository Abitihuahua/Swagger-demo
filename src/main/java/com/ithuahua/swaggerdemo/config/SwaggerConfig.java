package com.ithuahua.swaggerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2  //开启swagger2
public class SwaggerConfig {
//    配置swagger的docket的bean实例
    @Bean
    public Docket docket1(Environment environment){
        //设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev","test");
        //通过监听变量来获取是否监听到生产的环境变量
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("huahua")
                .enable(flag)//是否启动swagger,如果为否则不能在浏览器中访问
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ithuahua.swaggerdemo.controller"))
                //.paths(PathSelectors.ant("/huahua/**"))
                .build();
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("huaoba");
    }

    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("XXXXX");
    }

    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("华云翔",
                "https://www.bilibili.com/",
                "798002384@qq.com");
        return new ApiInfo("第一次尝试swagger",
                "Api文档",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
