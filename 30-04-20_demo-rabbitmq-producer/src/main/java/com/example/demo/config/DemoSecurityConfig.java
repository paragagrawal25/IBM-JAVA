package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter
{

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception 
		{
			UserBuilder users = User.withDefaultPasswordEncoder();
			
			auth.inMemoryAuthentication()
			.withUser(users.username("admin").password("admin123").roles("ADMIN"));
				
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception 
		{
			http.authorizeRequests()
				.antMatchers("/accounts").hasAnyRole("ADMIN")
				.and()
				.formLogin().permitAll();
				//.and()
				//.logout().permitAll();
		}
}
