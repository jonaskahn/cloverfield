package one.ifelse.spring.authserver.facility;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

@RequiredArgsConstructor
public enum Sex {
    UNKNOWN(0, "Unknown"),
    MALE(1, "Male"),
    FEMALE(2, "Female");

    private final static Map<Integer, Sex> values = Arrays.stream(Sex.values())
            .collect(Collectors.toMap(Sex::getCode, identity()));

    @Getter(onMethod_ = {@JsonValue})
    private final int code;
    private final String description;

    public static Sex of(int code) {
        return values.get(code);
    }
}
