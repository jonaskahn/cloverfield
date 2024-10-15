package one.ifelse.spring.authserver.facility;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

@RequiredArgsConstructor
public enum Language {
    VIETNAMESE(1, "vi", "Vietnamese"),
    ENGLISH(2, "en", "English"),
    JAPANESE(3, "ja", "Japanese"),
    GERMAN(4, "de", "German");

    private static final Map<Integer, Language> values = Arrays.stream(Language.values())
            .collect(Collectors.toMap(Language::getCode, identity()));

    @Getter(onMethod_ = {@JsonValue})
    private final int code;
    @Getter
    private final String name;
    @Getter
    private final String description;

    public static Language of(int code) {
        return values.get(code);
    }
}
