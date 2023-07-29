package com.company.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSwagger {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info().title("Api Rest with Swagger").description("Api created with Spring boot"));
    }
}
