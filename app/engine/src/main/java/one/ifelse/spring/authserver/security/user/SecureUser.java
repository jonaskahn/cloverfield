package one.ifelse.spring.authserver.security.user;

import one.ifelse.spring.authserver.facility.EntityStatus;

import java.time.Instant;
import java.util.Collection;

public interface SecureUser {

    String getUsername();

    String getPassword();

    Instant getExpiredDate();

    boolean isLocked();

    EntityStatus getStatus();

    Collection<String> getAuthorities();
}
