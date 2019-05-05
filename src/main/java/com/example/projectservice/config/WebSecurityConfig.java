/*package com.example.projectservice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(final HttpSecurity httpSecurity) throws Exception{
		httpSecurity
				.authorizeRequests()
				.antMatchers("/", "/service","/tracking","/contact","/pricelist").permitAll()
				.and().authorizeRequests()
				.antMatchers(HttpMethod.GET,"/track**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.successForwardUrl("/admin")
				.permitAll()
				.and()
				.logout()
				.permitAll();

	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager();
	}
}*/
