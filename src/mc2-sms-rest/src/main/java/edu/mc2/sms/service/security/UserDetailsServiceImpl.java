package edu.mc2.sms.service.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mc2.sms.jpa.entity.Role;
import edu.mc2.sms.jpa.entity.User;
import edu.mc2.sms.jpa.repository.UserRepository;


@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		User user = repository.findOne(userName); //our own User model class
		
		if(user!=null){
			
			String password = user.getPassword();
			//additional information on the security object
			boolean enabled = user.getActive() == 0 ? false : true;
			boolean accountNonExpired = enabled;
			boolean credentialsNonExpired = enabled;
			boolean accountNonLocked = enabled;
			
			//Let's populate user roles
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for(Role role : user.getRoles()){
				authorities.add(new SimpleGrantedAuthority(role.getName()));
			}
			
			//Now let's create Spring Security User object
			org.springframework.security.core.userdetails.User securityUser = new 
					org.springframework.security.core.userdetails.User(userName, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
			return securityUser;
		}else{
			throw new UsernameNotFoundException("User Not Found !!!");
		}
	}

}
