package edu.mc2.sms;

import static edu.mc2.sms.common.ApplicationConstants.ROLE_ADMIN;
import static edu.mc2.sms.common.ApplicationConstants.ROLE_STAFF;
import static edu.mc2.sms.common.ApplicationConstants.ROLE_STUDENT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
			.antMatchers("/public/**")
				.permitAll()
			.antMatchers("/student/**")
				.hasAuthority(ROLE_STUDENT)
			.antMatchers("/staff/**")
				.hasAuthority(ROLE_STAFF)
			.antMatchers("/**","/staff/**")
				.hasAuthority(ROLE_ADMIN)
			.anyRequest().authenticated().and()
            .httpBasic();
        
        http.csrf().disable();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth
    	.userDetailsService(userDetailsService)
    	.passwordEncoder(new BCryptPasswordEncoder());
    }
	
}
