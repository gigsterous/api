package com.gigsterous.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@RestController
@EnableResourceServer
public class App extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
