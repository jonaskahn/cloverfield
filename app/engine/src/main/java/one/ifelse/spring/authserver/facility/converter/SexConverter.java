package one.ifelse.spring.authserver.facility.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import one.ifelse.spring.authserver.facility.Sex;

import java.util.Optional;

@Converter(autoApply = true)
public class SexConverter implements AttributeConverter<Sex, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Sex sex) {
        return Optional.ofNullable(sex).map(Sex::getCode).orElse(null);
    }

    @Override
    public Sex convertToEntityAttribute(Integer code) {
        return Sex.of(code);
    }
}
