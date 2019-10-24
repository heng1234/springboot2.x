package com.boot.boot_mult_datasource.mysql.mysql_config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author : kaifa
 * create at:  2019-10-24  17:46
 * @description: 上面代码配置了一个名为mysqldatasource的数据源，
 * 对应application.yml中spring.datasource.druid.mysql前缀配置的数据库。
 * 然后创建了一个名为mysqlSqlSessionFactory的Bean，并且注入了mysqldatasource。
 * 与此同时，还分别定了两个扫描路径PACKAGE和MAPPER_LOCATION，前者为Mysql数据库对应的mapper接口地址，
 * 后者为对应的mapper xml文件路径。  @Primary标志这个Bean如果在多个同类Bean候选时，该Bean优先被考虑。
 * 多数据源配置的时候，必须要有一个主数据源，用@Primary标志该Bean。
 */
@Configuration
@MapperScan(basePackages = MysqlDatasourceConfig.PACKAGE, sqlSessionFactoryRef = "mysqlSqlSessionFactory")
public class MysqlDatasourceConfig {
    //mapper扫描路径
    static final String PACKAGE = "com.boot.boot_mult_datasource.mysql.mapper";
    // mybatis mapper xml扫描路径
    static final String MAPPER_LOCATION = "classpath:mysqlmapper/*.xml";

    @Primary
    @Bean(name = "mysqldatasource")
    @ConfigurationProperties("spring.datasource.druid.mysql")
    public DataSource mysqlDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlTransactionManager")
    @Primary
    public DataSourceTransactionManager mysqlTransactionManager() {
        return new DataSourceTransactionManager(mysqlDataSource());
    }

    @Bean(name = "mysqlSqlSessionFactory")
    @Primary
    public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("mysqldatasource") DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        //如果不使用xml的方式配置mapper，则可以省去下面这行mapper location的配置。
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MysqlDatasourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
