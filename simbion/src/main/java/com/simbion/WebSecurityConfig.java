//package com.simbion;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
//	@Override
//	protected void configure (HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests()
//			.antMatchers("/files/*").permitAll()
//			.antMatchers("/index").permitAll()
//			.antMatchers("/register").permitAll()
//			.antMatchers("/register-individual").permitAll()
//			.antMatchers("/register-yayasan").permitAll()
//			.antMatchers("/viewall-pengumuman").permitAll()
//			.antMatchers("/view-pengumuman").permitAll()
//			.antMatchers("/view-pengumuman").permitAll()
//			.antMatchers("/view-detail-skema").permitAll()
//			.anyRequest().authenticated()
//			.and()
//			.formLogin()
//			.loginPage("/login").permitAll()
//			.defaultSuccessUrl("/mhs",true)
//			.and()
//			.logout().permitAll();
//	}
//	
//	@Override
//	public void configure (WebSecurity web) throws Exception{
//		web
//			.ignoring()
//			.antMatchers(".resources/**","/static/**", "/css/**", "/js/**", "/images/**");
//	}
//	
//	@Autowired
//	DataSource dataSource;
//	
//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception
//	{
//		auth.jdbcAuthentication().dataSource(dataSource)
//		.passwordEncoder(NoOpPasswordEncoder.getInstance())
//		.usersByUsernameQuery("SELECT U.username, U.password, '1' as enabled FROM user_account U WHERE U.username =?")
//		.authoritiesByUsernameQuery("select username, role from user_account where username=?");
//	}
//	
//}