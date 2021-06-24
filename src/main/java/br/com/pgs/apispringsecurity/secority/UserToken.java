package br.com.pgs.apispringsecurity.secority;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;
@Service
public class UserToken {
	 public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
	      return new User("unico", "unico",
	              Collections.singleton(new SimpleGrantedAuthority("ADMIN")));
	    }
}
