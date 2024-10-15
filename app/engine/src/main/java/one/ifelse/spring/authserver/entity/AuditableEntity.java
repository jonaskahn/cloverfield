package one.ifelse.spring.authserver.entity;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.Instant;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public abstract class AuditableEntity implements Serializable {

    @Column(name = "created_by")
    @CreatedBy
    protected Long createdBy;

    @Column(name = "created_at")
    @CreatedDate
    protected Instant createdAt;

    @Column(name = "last_modified_by")
    @LastModifiedBy
    protected Long lastModifiedBy;

    @Column(name = "last_modified_at")
    @LastModifiedDate
    protected Instant lastModifiedAt;
}
