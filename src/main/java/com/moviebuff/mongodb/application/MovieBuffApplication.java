/**
 * 
 */
package com.moviebuff.mongodb.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.moviebuff.mongodb.application.config.JwtFilter;

/**
 * @author Balamurugan M
 * 
 * MovieBuffApplication SpringBoot Application Startup.
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MovieBuffApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MovieBuffApplication.class, args);
	}
	
	/**
	 * @return
	 */
	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/secure/*");

		return registrationBean;
	}

}
