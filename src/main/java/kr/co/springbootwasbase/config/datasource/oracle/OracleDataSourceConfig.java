package kr.co.springbootwasbase.config.datasource.oracle;

import kr.co.springbootwasbase.config.datasource.DataSourceConfig;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class OracleDataSourceConfig extends DataSourceConfig {

    private final OracleProperties oracleProperties;

    @Bean
    public DataSource oracleDataSource() {
        return super.createDataSource(
                oracleProperties.getUrl(),
                oracleProperties.getDriverClassName(),
                oracleProperties.getUserName(),
                oracleProperties.getPassword());
    }

    @Bean
    public SqlSessionFactory oracleSqlSessionFactory() throws Exception {
        return super.createSqlSessionFactory(oracleDataSource(), "classpath*:mapper/oracle/**/*.xml");
    }

}
