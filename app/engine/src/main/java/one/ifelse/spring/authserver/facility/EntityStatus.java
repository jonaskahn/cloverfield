package one.ifelse.spring.authserver.facility;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum EntityStatus {
    INACTIVATED(0, "Inactivated"),
    ACTIVATED(1, "Activated"),
    DELETED(9, "Deleted");

    private static final Map<Integer, EntityStatus> values = Arrays.stream(EntityStatus.values())
            .collect(Collectors.toMap(EntityStatus::getCode, Function.identity()));
    
    @Getter(onMethod_ = {@JsonValue})
    private final int code;
    @Getter
    private final String description;

    public static EntityStatus of(int code) {
        return values.get(code);
    }
}
