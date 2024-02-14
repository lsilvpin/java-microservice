package com.lsilvpin.javamicroservice.helpers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Configures the Swagger Docket bean.
     *
     * @return The configured Docket bean.
     */
    @SuppressWarnings("unchecked")
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis((Predicate<RequestHandler>) RequestHandlerSelectors.basePackage("com.lsilvpin.javamicroservice.controllers"))
            .paths((Predicate<String>) PathSelectors.any())
            .build()
            .apiInfo(apiInfo());
    }

    /**
     * Configures the API information for Swagger.
     *
     * @return The configured API information.
     */
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Java Microservice API")
                .description("API documentation for the Java Microservice project.")
                .version("1.0.0")
                .build();
    }
}
