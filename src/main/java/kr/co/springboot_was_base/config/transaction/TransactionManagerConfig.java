package kr.co.springboot_was_base.config.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class TransactionManagerConfig {
    @Bean
    public PlatformTransactionManager postgresqlTransactionManager(DataSource postgresqlDataSource) {
        return new DataSourceTransactionManager(postgresqlDataSource);
    }
    @Bean
    public PlatformTransactionManager oracleTransactionManager(DataSource oracleDataSource) {
        return new DataSourceTransactionManager(oracleDataSource);
    }
}
