package com.petadoption.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        System.out.println("Cors config.....");
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.addAllowedOrigin("*"); // Allow all origins
        corsConfig.addAllowedMethod("*"); // Allow all HTTP methods
        corsConfig.addAllowedHeader("*"); // Allow all headers

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsFilter(source);
    }
}
//package com.petadoption.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//@Configuration
//public class CorsConfig {
//
//    @Bean
//    public CorsFilter corsFilter() {
//        System.out.println("Cors config.....");
//        CorsConfiguration corsConfig = new CorsConfiguration();
//
//        // More specific origins for security
//        corsConfig.addAllowedOrigin("https://qfjc5ws4-3000.use2.devtunnels.ms");
//        corsConfig.addAllowedOrigin("https://725cf48be592.ngrok-free.app");
//        corsConfig.addAllowedOrigin("http://localhost:3000");
//        // Or keep "*" for development: corsConfig.addAllowedOrigin("*");
//
//        corsConfig.addAllowedMethod("*"); // Allow all HTTP methods
//        corsConfig.addAllowedHeader("*"); // Allow all headers
//        corsConfig.setAllowCredentials(true); // Important for auth
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfig);
//
//        return new CorsFilter(source);
//    }
//}