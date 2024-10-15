package one.ifelse.spring.authserver.service.security;


import com.naharoo.commons.mapstruct.UnidirectionalMapper;
import one.ifelse.spring.authserver.entity.User;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = org.mapstruct.ReportingPolicy.IGNORE,
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE
)
public interface SecureUserDtoFromUserEntityMapper extends UnidirectionalMapper<User, SecureUserDto> {
}
