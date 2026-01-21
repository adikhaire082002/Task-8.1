package com.jdbctemplate.SpringTask81.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;

import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "User Management API",
                version = "1.0",
                description = "API for managing User data"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Local Server"
                )
        }
)
@SecurityScheme(
        name = "basicAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
public class OpenApiConfig {
}