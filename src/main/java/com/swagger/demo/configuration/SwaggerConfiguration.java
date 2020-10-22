package com.swagger.demo.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
					.groupName("products")
					.apiInfo(apiInfo())
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.swagger.demo.controller"))
					.paths(PathSelectors.regex("/api/products.*"))
					.build();
	}
	
	private ApiInfo apiInfo() {
        return new ApiInfo("Product-API", "Product API to perform CRUD opertations", "1.0", "Terms of service",
        		// Contact object represents product owner company contact info.
                new Contact("RCRSoftwareLabs", "www.rcrlabs.com", "rcrlabs@email.com"), "License of API", "API license URL", Collections.emptyList());
    }

}
