package one.ifelse.spring.authserver.security.user;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import one.ifelse.spring.authserver.facility.EntityStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SecureUserDetails implements UserDetails {

    private final SecureUser user;

    public static SecureUserDetails of(SecureUser user) {
        return new SecureUserDetails(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        if (user.getExpiredDate() == null) {
            return true;
        }
        return Instant.now().isBefore(user.getExpiredDate());
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.isLocked();
    }

    @Override
    public boolean isEnabled() {
        return Objects.equals(user.getStatus(), EntityStatus.ACTIVATED);
    }
}
