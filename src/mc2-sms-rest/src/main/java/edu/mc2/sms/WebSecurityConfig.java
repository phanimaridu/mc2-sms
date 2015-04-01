package edu.mc2.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import edu.mc2.sms.model.Role;


@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
			.antMatchers("/anonymous/**").permitAll()
			.antMatchers("/student/**").hasAuthority(Role.getDBRole(Role.ROLE_STUDENT))
			.antMatchers("/staff/**").hasAuthority(Role.getDBRole(Role.ROLE_STAFF))
			.antMatchers("/**").hasAuthority(Role.getDBRole(Role.ROLE_ADMIN))
			.anyRequest().authenticated().and()
            .httpBasic();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
    	auth
    	.userDetailsService(userDetailsService)
    	.passwordEncoder(new Md5PasswordEncoder());

    	
    	/*
    	
    	.userDetailsService(userDetailsService)
    	.passwordEncoder(new Md5PasswordEncoder());

            .jdbcAuthentication()
            	.dataSource(dataSource)
            	.passwordEncoder(new Md5PasswordEncoder())
            	.usersByUsernameQuery("SELECT user_name,password,active FROM USER WHERE user_name = ?")
            	.authoritiesByUsernameQuery("SELECT uie.user_name,r.name FROM user_in_role uie INNER JOIN "
            			+ "role r ON r.id = uie.role_id WHERE uie.user_name = ?");
        */
        /*
          .inMemoryAuthentication()
        .withUser(Role.ROLE_ADMIN)
             .password("5f4dcc3b5aa765d61d8327deb882cf99")
             .roles(Role.ROLE_ADMIN)
         .and()
         .withUser(Role.ROLE_STAFF)
             .password("5f4dcc3b5aa765d61d8327deb882cf99")
             .roles(Role.ROLE_STAFF)
         .and()
         .withUser(Role.ROLE_STUDENT)
             .password("5f4dcc3b5aa765d61d8327deb882cf99")
             .roles(Role.ROLE_STUDENT)
            .and()
            .passwordEncoder(new Md5PasswordEncoder());
            
              */

         
    }
    
}
