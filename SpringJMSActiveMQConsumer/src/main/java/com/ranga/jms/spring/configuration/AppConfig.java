package com.ranga.jms.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.ranga.jms.spring")
@Import({MessagingConfiguration.class})
public class AppConfig {
	
	//Put Other Application configuration here.
}
