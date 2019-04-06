package com.team.config;


import org.springframework.beans.factory.annotation.Value;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * create by yifeng
 */
@MapperScan("com.team.mapper")
@SpringBootConfiguration
public class DataSourceConfiguration {


//
//    @Value("${spring.datasource.driver-class-name}")
//    private String jdbcDriver;
//    @Value("${spring.datasource.url}")
//    private String jdbcUrl;
//    @Value("${spring.datasource.username}")
//    private String jdbcUser;
//    @Value("${spring.datasource.password}")
//    private String jdbcPassword;
//
//    @Bean
//    public DataSource createDataSource() throws PropertyVetoException {
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//
//        dataSource.setDriverClass(jdbcDriver);
//        dataSource.setJdbcUrl(jdbcUrl);
//        dataSource.setUser(jdbcUser);
//        dataSource.setPassword(jdbcPassword);
//        // 关闭连接后不自动提交
//        dataSource.setAutoCommitOnClose(false);
//
//        return dataSource;
//    }

}
