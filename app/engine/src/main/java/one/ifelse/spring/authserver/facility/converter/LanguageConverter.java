package one.ifelse.spring.authserver.facility.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import one.ifelse.spring.authserver.facility.Language;

import java.util.Optional;

@Converter(autoApply = true)
public class LanguageConverter implements AttributeConverter<Language, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Language language) {
        return Optional.ofNullable(language).map(Language::getCode).orElse(null);
    }

    @Override
    public Language convertToEntityAttribute(Integer code) {
        return Language.of(code);
    }
}
