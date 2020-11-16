package com.hcl.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {

	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.jdbcAuthentication().dataSource(dataSource())
				.usersByUsernameQuery("select username,password,enabled from users where username=?")
				.authoritiesByUsernameQuery(
						"select u.username, ur.user_role from USERS u, USERS_ROLES ur where u.user_id = ur.userid and u.username = ?");*/
		
		 auth.inMemoryAuthentication().withUser("revathi").password("reva").
		  roles("USER");
		  auth.inMemoryAuthentication().withUser("revathi").password("reva1").
		 roles("ADMIN");
		

	}

	public void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/Success").access("hasRole('ROLE_USER')")
		.antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
		.and().formLogin().loginPage("/loginPage")
				// .defaultSuccessUrl("/Success")
				.successHandler(new CustomHandler()).failureUrl("/loginPage?error")

				.and().logout().logoutSuccessUrl("/loginPage?logout").and().exceptionHandling()
				.accessDeniedPage("/403");

	}

	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3307/mysql");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("root");
		return driverManagerDataSource;
	}

}
