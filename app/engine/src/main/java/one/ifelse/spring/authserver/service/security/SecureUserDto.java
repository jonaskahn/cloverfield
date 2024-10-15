package one.ifelse.spring.authserver.service.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.ifelse.spring.authserver.facility.EntityStatus;
import one.ifelse.spring.authserver.security.user.SecureUser;

import java.time.Instant;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SecureUserDto implements SecureUser {
    private String username;
    private String password;
    private Instant expiredDate;
    private boolean locked;
    private EntityStatus status;
    private Collection<String> authorities;
}