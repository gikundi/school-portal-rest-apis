package co.ke.codemity.school.portalapis.configuration;


import co.ke.codemity.school.portalapis.entities.mbiruri.MbiruriStudents;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by Denis Gikundi on 17/10/2020.
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "co.ke.codemity.school.portalapis.repository.mbiruri",
        entityManagerFactoryRef = "mbiruriEntityManagerFactory",
        transactionManagerRef= "mbiruriTransactionManager"
)
public class MbiruriDataSourceConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties mbiruriDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.configuration")
    public DataSource mbiruriDataSource() {
        return mbiruriDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(name = "mbiruriEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mbiruriEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(mbiruriDataSource())
                .packages(MbiruriStudents.class)
                .build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager mbiruriTransactionManager(
            final @Qualifier("mbiruriEntityManagerFactory") LocalContainerEntityManagerFactoryBean mbiruriEntityManagerFactory) {
        return new JpaTransactionManager(mbiruriEntityManagerFactory.getObject());
    }

}
