package one.ifelse.spring.authserver.security.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface SecureUserDetailsService extends UserDetailsService {

    SecureUserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
