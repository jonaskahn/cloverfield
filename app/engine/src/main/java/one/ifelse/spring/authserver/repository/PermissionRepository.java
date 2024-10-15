package one.ifelse.spring.authserver.repository;

import one.ifelse.spring.authserver.entity.Permission;
import one.ifelse.spring.authserver.facility.EntityStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {

    @Query(nativeQuery = true, value = """
            SELECT p.id, p.code, p.name, p.status
            FROM permissions p
            JOIN group_roles gr ON p.id = gr.permission_id
            JOIN groups g ON gr.group_id = g.id
            JOIN users u ON u.group_id = g.id
            WHERE u.id = :userId
            AND g.path <@ (SELECT path FROM groups WHERE id = u.group_id)
            AND p.status = :status
            UNION
            
            SELECT p.id, p.code, p.name, p.status
            FROM permissions p
            JOIN user_roles ur ON p.id = ur.permission_id
            WHERE ur.user_id = :userId
            AND p.status = :status
            """)
    Collection<Permission> getPermissionByUserIdAndStatus(Long userId, Integer status);

    default Collection<Permission> getActivatedPermissionsByUserIdAndStatus(Long userId) {
        return getPermissionByUserIdAndStatus(userId, EntityStatus.ACTIVATED.getCode());
    }
}