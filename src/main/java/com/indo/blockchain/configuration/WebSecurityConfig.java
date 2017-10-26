package com.indo.blockchain.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.indo.blockchain.repository.IAccountDao;
import com.indo.blockchain.service.AuthenticationService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	AuthenticationService authenticationService;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	IAccountDao accountDao;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authenticationService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.csrf().disable();
		http.httpBasic().and().authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS,"**").permitAll()
        .antMatchers("/categorie/all").permitAll()
        .antMatchers("/country/all").permitAll()
        .antMatchers("/blockchain/*").anonymous() // FOR TEST
        .antMatchers("/project/paginable/all").permitAll()
        .antMatchers("/project/all/categorie/*").anonymous()
        .antMatchers("/project/all/name/*").anonymous()
		.antMatchers("/login/*").anonymous()
		.antMatchers("/user/player/create").anonymous()
		.anyRequest().authenticated();
		//http.authorizeRequests().anyRequest().anonymous();
	}

	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return new AuthenticationService();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
