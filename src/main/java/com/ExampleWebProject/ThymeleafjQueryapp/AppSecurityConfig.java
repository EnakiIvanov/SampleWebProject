package com.ExampleWebProject.ThymeleafjQueryapp;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/*
 * Spring boot security tutorial: https://www.baeldung.com/java-config-spring-security
 * https://spring.io/guides/gs/securing-web/
 */
@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	 @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) 
	      throws Exception {
		 	auth.jdbcAuthentication()
		 	.dataSource(dataSource)
		 	.passwordEncoder(passwordEncoder())
		 	.usersByUsernameQuery("select username, password, enabled from users where username = ?")
		 	.authoritiesByUsernameQuery("select username, role from users where username = ?");
	    }
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	      .authorizeRequests()
	      .antMatchers("/students/addNew").hasAnyRole("USER", "ADMIN")
	      .antMatchers("/students/update").hasAnyRole("USER", "ADMIN")
	      .antMatchers("/students/delete/**").hasAnyRole("USER", "ADMIN")
	      .antMatchers("/students/getOne/**").hasAnyRole("USER", "ADMIN")
	      .antMatchers("/admin/**").hasRole("ADMIN")
	      .and()
	      .formLogin()
	      .loginPage("/login")
	      .permitAll()
	      .defaultSuccessUrl("/home", true)
	      .failureUrl("/login?error=true")
	      .and()
	      .logout()
	      .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	      .logoutSuccessUrl("/home")
	      .deleteCookies("JSESSIONID")
	      .invalidateHttpSession(true);	      

	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

}
