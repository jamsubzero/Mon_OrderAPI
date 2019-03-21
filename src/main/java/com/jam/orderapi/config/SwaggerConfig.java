package com.jam.orderapi.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket orderApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jam.orderapi"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(APIMetaInfo()); 
    }

	private ApiInfo APIMetaInfo() {
		ApiInfo apiInfo = new ApiInfo(
			 "Order API",
			 "Order API for montichard skills test",
			 "1.0",
			 "http://www.jamsubzero.com/TermsOfService",
			 new Contact("Jam2020", "https://www.linkedin.com/in/jose-armin-maningo-jr/", "jamsubzero@gmail.com"),
			 "My License Version 2.0",
			 "https://www.jamsubero.com/license.html",
			 new ArrayList<VendorExtension>()
		);
		return apiInfo;
	}


}
