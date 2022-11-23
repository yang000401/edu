package net.e4net.demo.swagger;
// swagger config 테스트


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.HashSet;
import java.util.Set;

//@Configuration
//@EnableWebMvc
//public class SwaggerConfig {
//
//    private ApiInfo swaggerInfo() {
//        return new ApiInfoBuilder().title("IoT API")
//                .description("IoT API Docs").build();
//    }
//
//    @Bean
//    public Docket swaggerApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .consumes(getConsumeContentTypes())
//                .produces(getProduceContentTypes())
//                .apiInfo(swaggerInfo()).select()
//                .apis(RequestHandlerSelectors.basePackage("com.e4net.demo"))
//                .paths(PathSelectors.any())
//                .build()
//                .useDefaultResponseMessages(false);
//    }
//
//    private Set<String> getConsumeContentTypes() {
//        Set<String> consumes = new HashSet<>();
//        consumes.add("application/json;charset=UTF-8");
//        consumes.add("application/x-www-form-urlencoded");
//        return consumes;
//    }
//
//    private Set<String> getProduceContentTypes() {
//        Set<String> produces = new HashSet<>();
//        produces.add("application/json;charset=UTF-8");
//        return produces;
//    }
//}


//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("net.e4net.demo"))
//                .paths(PathSelectors.any())
//                .build();
//
//    }
//}




//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.*;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .useDefaultResponseMessages(false)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("org.greenbyme.angelhack"))
//                .paths(PathSelectors.ant("/api/**"))
//                .build()
//                .apiInfo(metaData())
//                .securityContexts(Arrays.asList(securityContext()))
//                .securitySchemes(Arrays.asList(apiKey()));
//
//    }
//
//    private ApiInfo metaData() {
//        return new ApiInfoBuilder()
//                .title("GreenByMe REST API")
//                .termsOfServiceUrl("Terms of service")
//                .contact(new Contact("Tae Jeong, Da hun", "https://github.com/GreenByMe/GreenByMe_Server", "xowjd41@naver.com"))
//                .license("Apache License Version 2.0")
//                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
//                .build();
//    }
//
//    private ApiKey apiKey() {
//        return new ApiKey("JWT", "jwt", "header");
//    }
//
//    private SecurityContext securityContext() {
//        return springfox
//                .documentation
//                .spi.service
//                .contexts
//                .SecurityContext
//                .builder()
//                .securityReferences(defaultAuth()).forPaths(PathSelectors.any()).build();
//    }
//
//    List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
//    }
//}
//
//


