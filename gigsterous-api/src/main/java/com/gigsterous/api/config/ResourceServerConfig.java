package com.gigsterous.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig {
	// moving @EnableResourceServer to a separate config class makes it easier
	// to test mvc layer without security
}