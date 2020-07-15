package com.learning.SecurityDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	/*
	 * Used for Custom Authentication
	 * 
	 * Authentication Object wraps around the Credentials and Principal(User) 
	 * 
	 * There is a Authentication Provider Manager, which can provide among
	 * multiple types of Authentication Providers
	 * It can also check with each Provider whether it supports that type
	 * of authentication or not, using supports() method in Authentication Provider
	 * 
	 * As all services need a similar operation, to get user from DB or anywhere else
	 * there is a common method to do so:
	 * UserDetailsService --> loadUserByUserName() returns UserDetails
	 * which has all information related to User
	 * 
	 * Flow:
	 * Filter -> AuthenticationProviderManager ->(Search) AuthenticationProvider -> UserDetailsService
	 */
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
//	For in Memory Authentication
	
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//			.withUser("admin")
//			.password("admin")
//			.roles("ADMIN")
//			.and()
//			.withUser("user")
//			.password("user")
//			.roles("USER");
//	}
	
	/*
	 * Used for Custom Authorization
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/*
		 * Uses Wildcards
		 * ** for all
		 * Order should be most restrictive to least
		 * To provide no authetication for css and js files
		 * .antMatchers("/","static/css","static/js")
		 */
		http.authorizeRequests()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/user").hasAnyRole("USER", "ADMIN")
			.antMatchers("/").permitAll()
			.and().formLogin();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		
	}
}
