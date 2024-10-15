package one.ifelse.spring.authserver.facility.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import one.ifelse.spring.authserver.facility.EntityStatus;

import java.util.Optional;

@Converter(autoApply = true)
public class EntityStatusConverter implements AttributeConverter<EntityStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(EntityStatus status) {
        return Optional.ofNullable(status).map(EntityStatus::getCode).orElse(null);
    }

    @Override
    public EntityStatus convertToEntityAttribute(Integer code) {
        return EntityStatus.of(code);
    }
}
