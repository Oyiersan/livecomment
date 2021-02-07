package com.oyiersan.livecomment.config;

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
 * swagger2配置
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    /**
     * 是否开启swagger，正式环境一般是需要关闭的
     */
//    @Value(value = "${swagger.enabled}")
//    Boolean swaggerEnabled;

    @Bean
    public Docket createRestApp() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("livecomment")
                // 是否开启
//                .enable(swaggerEnabled)
                .select()
                // 扫描的路径包
                .apis(RequestHandlerSelectors.basePackage("com.oyiersan.livecomment.controller"))
                // 指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any()).build();
    }

//    @Bean
//    public Docket createRestBasic() {
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("basic")
//                // 是否开启
////                .enable(swaggerEnabled)
//                .select()
//                // 扫描的路径包
//                .apis(RequestHandlerSelectors.basePackage("com.hsh.dy.api.controller.basic"))
//                // 指定路径处理PathSelectors.any()代表所有的路径
//                .paths(PathSelectors.any()).build();
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("直播评论")
                .description("直播评论")
                // 作者信息
                .contact(new Contact("", "", ""))
                .version("1.0.0")
                .build();
    }
}
