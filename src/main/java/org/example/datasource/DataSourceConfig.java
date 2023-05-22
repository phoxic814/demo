package org.example.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

//    @Bean(name = "pgDataSource")
//    @Primary
//    public DataSource pgDataSource() {
////        Properties props = new Properties();
////        props.setProperty("stringtype", "unspecified");
//        final HikariConfig hikariConfig = new HikariConfig();
////        hikariConfig.setDataSourceProperties(props);
//        hikariConfig.setDriverClassName(this.classname);
//        hikariConfig.setJdbcUrl(this.url);
//        hikariConfig.setUsername(this.username);
//        hikariConfig.setPassword(this.password);
//        hikariConfig.setMaximumPoolSize(Integer.parseInt(maximumPoolSize));
//        hikariConfig.setMinimumIdle(minimumIdle);
//        /**取得Connection的Timeout時間: 30秒*/
//        hikariConfig.setConnectionTimeout(connectionTimeout);
//        /**閒置的Connection當到達IdleTimeout時則會釋出：3分鐘*/
//        hikariConfig.setIdleTimeout(idleTimeout);
//        /**指這個Connection在Pool的最大存活時間：5分鐘*/
//        hikariConfig.setMaxLifetime(maxLifetime);
//        hikariConfig.setConnectionTestQuery("SELECT 1");
//        hikariConfig.setPoolName("springHikariCP_PG");
//        hikariConfig.setConnectionInitSql(this.getInitSql());
//        hikariConfig.setLeakDetectionThreshold(183000);
//        return new HikariDataSource(hikariConfig);
//    }

    @Bean("MASTER")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("SLAVE")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DataSource dynamicDataSource() {
        Map<Object, Object> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put(DataSourceEnum.MASTER.name(), masterDataSource());
        dataSourceMap.put(DataSourceEnum.SLAVE.name(), slaveDataSource());
        //设置动态数据源
        MultiDataSource dynamicDataSource = new MultiDataSource();
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource());

        return dynamicDataSource;
    }

}
