package com.stockmanager.fst.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SicuretyConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		http.csrf().disable();
		  http.authorizeRequests().antMatchers("/").fullyAuthenticated().and
		 ().httpBasic(); 
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("yassir").password("{noop}yaya123").roles("CHEF");
		auth.inMemoryAuthentication().withUser("nidal").password("{noop}nidal123").roles("STUF");
		auth.inMemoryAuthentication().withUser("ahmed").password("{noop}ahmed123").roles("COMPTABLE");
	}
}
