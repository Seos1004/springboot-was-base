package kr.co.springboot_was_base.config.open_api;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class OpenAPIConfig {
    private final OpenAPIProperties openAPIProperties;

    @Bean
    public GroupedOpenApi allApi() {
        return GroupedOpenApi.builder()
                .group("all")
                .pathsToMatch("/**")
                .build();
    }


    @Bean
    public GroupedOpenApi sampleApi() {
        return GroupedOpenApi.builder()
                .group("sample")
                .pathsToMatch("/sample/**")
                .build();
    }

    @Bean
    public GroupedOpenApi redisApi() {
        return GroupedOpenApi.builder()
                .group("redis")
                .pathsToMatch("/redis/**")
                .build();
    }


    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(openAPIProperties.getTitle())
                        .version(openAPIProperties.getVersion())
                        .description(openAPIProperties.getDescription())
                ).servers(openAPIProperties.getServers());
    }
}

