//package com.example.multipleDatasources.configs;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import jakarta.persistence.EntityManagerFactory;
//import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        basePackages = {"com.example.demo.repositories.primary"},
//        entityManagerFactoryRef = "primaryEntityManagerFactory",
//        transactionManagerRef = "primaryJpaTransactionManager"
//)
//public class PrimaryDatasourceConfig {
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.hikari.primary")
//    public HikariConfig primaryHikariConfig() {
//        return new HikariConfig();
//    }
//
//    @Primary
//    @Bean(name = "primaryDataSource")
//    public DataSource primaryDataSource() {
//        return new LazyConnectionDataSourceProxy(new HikariDataSource(primaryHikariConfig()));
//    }
//
//    @Bean(name = "primaryEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
//            @Qualifier("primaryDatasource") DataSource primaryDatasource) {
//        return new LocalContainerEntityManagerFactoryBean() {{
//            setDataSource(primaryDatasource);
//            setPackagesToScan("com.example.demo.models.primary");
//            setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//            setJpaPropertyMap(jpaProperties());
//            setPersistenceUnitName("hikari");
//        }};
//    }
//
//    private Map<String, Object> jpaProperties() {
//        Map<String, Object> props = new HashMap<>();
//        props.put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
//        props.put("hibernate.physical_naming_strategy", CamelCaseToUnderscoresNamingStrategy.class.getName());
//        return props;
//    }
//
//    @Primary
//    @Bean(name = "primaryJpaTransactionManager")
//    public PlatformTransactionManager primaryJpaTransactionManager(
//            @Qualifier("primaryEntityManagerFactory") EntityManagerFactory primaryEntityManagerFactory
//    ) {
//        return new JpaTransactionManager(primaryEntityManagerFactory);
//    }
//
//}
