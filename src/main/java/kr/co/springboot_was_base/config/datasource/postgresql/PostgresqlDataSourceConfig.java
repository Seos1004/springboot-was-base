package kr.co.springboot_was_base.config.datasource.postgresql;

import kr.co.springboot_was_base.config.datasource.DataSourceConfig;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class PostgresqlDataSourceConfig extends DataSourceConfig {

    private final PostgresqlProperties postgresqlProperties;

    @Bean
    public DataSource postgresqlDataSource() {
        return super.createDataSource(
                postgresqlProperties.getUrl(),
                postgresqlProperties.getDriverClassName(),
                postgresqlProperties.getUserName(),
                postgresqlProperties.getPassword());
    }

    @Bean
    public SqlSessionFactory postgresqlSqlSessionFactory() throws Exception {
        return super.createSqlSessionFactory(postgresqlDataSource(), "classpath*:mapper/postgresql/**/*.xml");
    }



}
