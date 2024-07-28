package kr.co.springboot_was_base.config.datasource.oracle;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "spring.datasource.oracle")
public class OracleProperties {
    private String url;
    private String driverClassName;
    private String userName;
    private String password;
}
