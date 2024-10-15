package one.ifelse.spring.authserver.configurer;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EntityScan(basePackages = "one.ifelse.spring.authserver.entity")
@EnableJpaRepositories(basePackages = "one.ifelse.spring.authserver.repository")
@EnableRedisRepositories
class DatabaseConfigurer {
}
