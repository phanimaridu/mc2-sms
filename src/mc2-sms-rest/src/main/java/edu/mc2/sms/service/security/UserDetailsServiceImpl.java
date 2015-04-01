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

import edu.mc2.sms.dao.UserDAO;
import edu.mc2.sms.model.User;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		User user = userDAO.find(userName); //our own User model class
		
		if(user!=null){
			
			String password = user.getPassword();
			//additional information on the security object
			boolean enabled = user.isActive();
			boolean accountNonExpired = user.isActive();
			boolean credentialsNonExpired = user.isActive();
			boolean accountNonLocked = user.isActive();
			
			//Let's populate user roles
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for(String role : user.getRoles()){
				authorities.add(new SimpleGrantedAuthority(role));
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
