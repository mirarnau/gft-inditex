package com.gft_inditex.product_pricing_server.infraestructure.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${bezkoder.openapi.dev-url}")
    private String devUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        final Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Product Pricing Server URL in Development environment");

        final Info info = new Info()
                .title("INDITEX Product Pricing API")
                .version("1.0")
                .description("API to get the applicable price for a product in a given timestamp");

        return new OpenAPI().info(info).servers(List.of(devServer));
    }

}