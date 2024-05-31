//package com.nguyenminh.doan1.configuration;
//
//import org.springframework.context.annotation.Configuration;
//
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//public class CorsConfig {
//    public static class WebConfig implements WebMvcConfigurer {
//        @Override
//        public void addCorsMappings(CorsRegistry registry) {
//            registry.addMapping("/**")
//                    .allowedOriginPatterns("*") // Use allowedOriginPatterns instead of allowedOrigins
//                    .allowedMethods("GET", "POST", "PUT", "DELETE")
//                    .allowedHeaders("*")
//                    .exposedHeaders("Access-Control-Allow-Origin")
//                    .allowCredentials(true)
//                    .maxAge(3600);
//        }
//    }
//}