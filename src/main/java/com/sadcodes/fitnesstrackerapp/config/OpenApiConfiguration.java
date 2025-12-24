package com.sadcodes.fitnesstrackerapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customConfiguration() {
        return new OpenAPI()
                .info(new Info()
                        .title("Fitness Tracking API")
                        .contact(new Contact()
                                .name("Saddab")
                                .url("https://github.com/SaddabCodes/Fitness-Tracker-App")
                        )
                );
    }
}
