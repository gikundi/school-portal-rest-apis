

package co.ke.codemity.school.portalapis.configuration;

import co.ke.codemity.school.portalapis.entities.kyeni.KyeniStudents;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@EnableJpaRepositories(basePackages = "co.ke.codemity.school.portalapis.repository.kyeni",
        entityManagerFactoryRef = "kyeniEntityManagerFactory",
        transactionManagerRef= "kyeniTransactionManager"
)
public class KyeniDataSourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.seconddatasource")
    public DataSourceProperties kyeniDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.seconddatasource.configuration")
    public DataSource kyeniDataSource() {
        return kyeniDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Bean(name = "kyeniEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean kyeniEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(kyeniDataSource())
                .packages(KyeniStudents.class)
                .build();
    }

    @Bean
    public PlatformTransactionManager kyeniTransactionManager(
            final @Qualifier("kyeniEntityManagerFactory") LocalContainerEntityManagerFactoryBean kyeniEntityManagerFactory) {
        return new JpaTransactionManager(kyeniEntityManagerFactory.getObject());
    }

}

