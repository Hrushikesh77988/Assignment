package com.example.MindBowserChallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.MindBowserChallenge.dao.ManagerRepository;

@SpringBootApplication
@EnableJpaRepositories("com.example.MindBowserChallenge.dao")

@ComponentScan(basePackages={"com.example.MindBowserChallenge.data","com.example.MindBowserChallenge.controller","com.example.MindBowserChallenge.dao"})

public class MindBowserChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MindBowserChallengeApplication.class, args);
	}

	
	
	 @Configuration
	    public class WebConfig implements WebMvcConfigurer {      
	        @Override
	        public void addResourceHandlers(ResourceHandlerRegistry registry) {
	            registry.addResourceHandler("/**")
	            .addResourceLocations("classpath:/static/","classpath:/image/")
	            .setCachePeriod(0);
	        }
	    }
		
}
