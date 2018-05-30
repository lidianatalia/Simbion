package com.simbion;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/files/*").permitAll()
			.antMatchers("/").permitAll()
			.antMatchers("/home").permitAll()
			.antMatchers("/register").permitAll()
			.antMatchers("/register-individual").permitAll()
			.antMatchers("/register-yayasan").permitAll()
			.antMatchers("/register/submit").permitAll()
			.antMatchers("/register/submit/**").permitAll()
			.antMatchers("/viewall-pengumuman").permitAll()
			.antMatchers("/view-pengumuman/**").permitAll()
			.antMatchers("/view-detail-skema/**").permitAll()
			.antMatchers("/tempat-wawancara/**").hasRole("ADMIN")
			.antMatchers("/viewall-tempat-wawancara").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login").permitAll()
			.and()
			.logout().permitAll();
		http.exceptionHandling().accessDeniedPage("/403");
	}
	
	@Override
	public void configure (WebSecurity web) throws Exception{
		web
			.ignoring()
			.antMatchers(".resources/**","/static/**", "/css/**", "/js/**", "/images/**");
	}
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(NoOpPasswordEncoder.getInstance()) //password decoder problem
		.usersByUsernameQuery("SELECT username, password, '1' as enabled FROM pengguna where username=?")
		.authoritiesByUsernameQuery("SELECT username, \r\n" + 
				"CASE WHEN username in (SELECT username FROM mahasiswa) then 'ROLE_MAHASISWA' \r\n" + 
				"WHEN username in (SELECT username FROM donatur) then 'ROLE_DONATUR' \r\n" + 
				"WHEN username in (SELECT username FROM admin) then 'ROLE_ADMIN' \r\n" + 
				"ELSE '' END AS role\r\n" + 
				"FROM pengguna WHERE username=?");
	}
	
}