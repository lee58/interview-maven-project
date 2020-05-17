package com.interview.config.interviewMaven;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author 大都督
 * @create 2020/4/3
 */
@Configuration // xml InterviewDataSourceConfig.xml
@MapperScan(basePackages = "com.interview.interviewMaven.mapper", sqlSessionTemplateRef = "interviewMavenSqlSessionTemplate")
public class InterviewMavenDataSourceConfig {


    @Bean("interviewMavenDataSource")
    public DataSource interviewMavenDataSource(InterviewMavenConfig interviewMavenConfig) throws SQLException {
        // 创建xaDataSource
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl(interviewMavenConfig.getUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword(interviewMavenConfig.getPassword());
        mysqlXADataSource.setUser(interviewMavenConfig.getUserName());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);

        // 注册到全局事务
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName(interviewMavenConfig.getUniqueResourceName());
        atomikosDataSourceBean.setMinPoolSize(interviewMavenConfig.getMinPoolSize());
        atomikosDataSourceBean.setMaxPoolSize(interviewMavenConfig.getMaxPoolSize());
        atomikosDataSourceBean.setMaxLifetime(interviewMavenConfig.getMaxLifetime());
        atomikosDataSourceBean.setBorrowConnectionTimeout(interviewMavenConfig.getBorrowConnectionTimeout());
        atomikosDataSourceBean.setLoginTimeout(interviewMavenConfig.getLoginTimeout());
        atomikosDataSourceBean.setMaintenanceInterval(interviewMavenConfig.getMaintenanceInterval());
        atomikosDataSourceBean.setMaxIdleTime(interviewMavenConfig.getMaxIdleTime());
        atomikosDataSourceBean.setTestQuery(interviewMavenConfig.getTestQuery());
        return atomikosDataSourceBean;
    }

    /**
     * 创建SqlSessionFactory
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean("interviewMavenSqlSessionFactory")
    public SqlSessionFactory interviewMavenSqlSessionFactory(@Qualifier("interviewMavenDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        SqlSessionFactory object = sqlSessionFactoryBean.getObject();
        return object;
    }

//    @Bean("interviewMavenTransactionManager")
//    public DataSourceTransactionManager interviewMavenDataSourceTransactionManager(@Qualifier("interviewMavenDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
    /**
     * 创建SqlSessionTemplate
     * @param sqlSessionFactory
     * @return
     */
    @Bean("interviewMavenSqlSessionTemplate")
    public SqlSessionTemplate interviewMavenSqlSessionTemplate(@Qualifier("interviewMavenSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
