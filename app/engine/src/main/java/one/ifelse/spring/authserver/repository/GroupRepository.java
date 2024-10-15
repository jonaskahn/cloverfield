package one.ifelse.spring.authserver.repository;

import one.ifelse.spring.authserver.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}