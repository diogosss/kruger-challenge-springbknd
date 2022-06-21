/*
* Coded by Diego Salazar for the Kruger CHallenge
* */

package com.kruger.salazardiego.inventariovac.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kruger.salazardiego.inventariovac.web.controller"))
                .build().apiInfo(getApiInfo());
    }


    private ApiInfo apiEndoPointInfo(){
        return new ApiInfoBuilder().title("Krugger Challenge Api")
                .description("Aplicación para llevar un registro del inventario del estado de\n" +
                        "vacunación de los empleados")
                .license("Apache 2.0")
                .version("1.0.0")
                .build();
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Krugger Challenge Api",
                "Aplicación para llevar un registro del inventario del estado de vacunación de los empleados",
                "1.0.0",
                "https://jcodepoint.com/",
                new Contact("Diego Salazar", "https://github.com/diogosss", "diegosalazarandlun@protonmail.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }

}
