package one.ifelse.spring.authserver.service.security;

import com.naharoo.commons.mapstruct.MappingFacade;
import lombok.RequiredArgsConstructor;
import one.ifelse.spring.authserver.entity.Permission;
import one.ifelse.spring.authserver.repository.PermissionRepository;
import one.ifelse.spring.authserver.repository.UserRepository;
import one.ifelse.spring.authserver.security.user.SecureUserDetails;
import one.ifelse.spring.authserver.security.user.SecureUserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecureUserDetailsServiceUseCase implements SecureUserDetailsService {
    
    private final UserRepository userRepository;

    private final PermissionRepository permissionRepository;

    private final MappingFacade mappingFacade;

    @Override
    public SecureUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsernameOrEmail(username, username).orElseThrow(() -> new UsernameNotFoundException(STR."User [ \{username} ] not found"));
        var permissions = permissionRepository.getActivatedPermissionsByUserIdAndStatus(user.getId()).stream().map(Permission::getCode).toList();
        var secureUser = mappingFacade.map(user, SecureUserDto.class);
        secureUser.setAuthorities(permissions);
        return SecureUserDetails.of(secureUser);
    }
}
