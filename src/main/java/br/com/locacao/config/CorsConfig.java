package br.com.locacao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Lê o domínio do frontend via variável de ambiente
                String frontendUrl = System.getenv("FRONTEND_URLS");

                // Domínio padrão para desenvolvimento local
                if (frontendUrl == null || frontendUrl.isBlank()) {
                    frontendUrl = "http://localhost:3000";
                }

                System.out.println("CORS permitido para: " + frontendUrl);

                registry.addMapping("/**")
                    .allowedOrigins(frontendUrl)
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowedHeaders("*")
                    .allowCredentials(true);
            }
        };
    }
}
