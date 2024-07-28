package kr.co.springboot_was_base.config.datasource.postgresql;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "spring.datasource.postgresql")
public class PostgresqlProperties {
    private String url;
    private String driverClassName;
    private String userName;
    private String password;
}
