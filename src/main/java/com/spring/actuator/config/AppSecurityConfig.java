package com.spring.actuator.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable();
		http.csrf().disable();
		http.authorizeRequests()
		    .requestMatchers(EndpointRequest.to("health","info","threaddump")).permitAll()
		    .requestMatchers(EndpointRequest.toAnyEndpoint())
		    .authenticated()
		    .and()
		    .httpBasic();
	}
	
	

}
