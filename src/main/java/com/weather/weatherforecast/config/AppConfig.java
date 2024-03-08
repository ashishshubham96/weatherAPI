package com.weather.weatherforecast.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

	@Bean
	public UserDetailsService userDetailService() {
		UserDetails user = User.builder().username("Admin").password(passwordEncoder().encode("Admin@123")).roles("ADMIN").build();
		UserDetails user2 = User.builder().username("ServiceUser").password(passwordEncoder().encode("ServiceUser@123")).roles("USER").build();
		
		return new InMemoryUserDetailsManager(user, user2);
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	
		return new BCryptPasswordEncoder();
	}
}
