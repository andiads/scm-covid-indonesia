package com.nusacamp.app.service;

import com.nusacamp.app.entity.User;
import com.nusacamp.app.entity.UserType;
import com.nusacamp.app.entity.VUsersRegistered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

//	@Autowired
//	private UserService userService;
	
	@Autowired
	private ViewUsersService viewUsersService;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		VUsersRegistered user = viewUsersService.findUserByMail(userName);
		if (user == null) {
			throw new UsernameNotFoundException(userName);
		}
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(user.getUserType()));
		
		return new org.springframework.security.core.userdetails.User (
				user.getMail(),
				user.getPassword(),
				grantedAuthorities
		);
	}
}
		/*List<GrantedAuthority> auths = getUserAuthority(user.getUserTypes());
		return buildUserForAuthentication(user, auths);
	}

	private List<GrantedAuthority> getUserAuthority(Set<UserType> userTypes){
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for (UserType userType : userTypes) {
			roles.add(new SimpleGrantedAuthority(userType.getTypeName()));
		}
		List<GrantedAuthority> grantedAuths = new ArrayList<>(roles);
		return grantedAuths;
		
	}
	
	private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> auths) {
		return new org.springframework.security.core.userdetails.User(user.getMail(), user.getPassword(), true, true, true, true, auths);
	}
}*/
