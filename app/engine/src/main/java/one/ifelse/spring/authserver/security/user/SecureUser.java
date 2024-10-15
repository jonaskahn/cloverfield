package one.ifelse.spring.authserver.security.user;

import one.ifelse.spring.authserver.facility.EntityStatus;

import java.time.Instant;

public interface SecureUser {

    String getUsername();

    String getPassword();

    Instant getExpiredDate();

    boolean isLocked();

    EntityStatus getStatus();
}
