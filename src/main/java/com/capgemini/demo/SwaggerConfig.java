package com.capgemini.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import com.google.common.base.Predicates;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		final Contact contact = new Contact("demo APIs", "demo.com", "demo@capgemini.com");
		final ApiInfo info = new ApiInfoBuilder().title("demo APIs ")
				.description("APIs for demo").version("1.0.0")
				.termsOfServiceUrl("http://www.capgemini.com").contact(contact).license("License")
				.licenseUrl("http://www.opensource.org/licenses/mit-license.php").build();
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(info).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex("/.*")).paths(Predicates.not(PathSelectors.regex("/error"))).build()
				.pathMapping("/").genericModelSubstitutes(ResponseEntity.class).useDefaultResponseMessages(false);
	}

}