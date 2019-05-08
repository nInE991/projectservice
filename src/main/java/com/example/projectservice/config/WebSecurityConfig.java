package com.example.projectservice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.inject.Inject;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Inject
	DataSource dataSource;

	@Bean
	public static PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(12);
	}

	@Override
	public void configure(final HttpSecurity httpSecurity) throws Exception{
		httpSecurity.csrf().disable()
				.authorizeRequests()
				.antMatchers("/", "/service", "/tracking", "/contact", "/pricelist", "/js/**", "/css/**", "/image/**", "/open-iconic.font/**").permitAll()
				.antMatchers(HttpMethod.POST, "/track").permitAll()
				.antMatchers("/admin/**").access("hasRole('ROLE_Admin')")
				.antMatchers("/director/**").access("hasRole('ROLE_Director')")
				.antMatchers("/manager/**").access("hasRole('ROLE_Manager')")
				.antMatchers("/employees/**").access("hasRole('ROLE_Employees')")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login").usernameParameter("username").passwordParameter("password")
				.defaultSuccessUrl("/hello")
				.permitAll()
				.and()
				.logout().logoutUrl("/logout").deleteCookies()
				.invalidateHttpSession(true).logoutSuccessUrl("/")
				.permitAll()
				.and().exceptionHandling().accessDeniedPage("/accessDeny");


	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password,enable from users where username=?")
				.authoritiesByUsernameQuery("select username, role from users where username=?");
	}
}
