package com.interview.config.interview;

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
@MapperScan(basePackages = "com.interview.interview.mapper", sqlSessionTemplateRef = "interviewSqlSessionTemplate")
public class InterviewDataSourceConfig {


    /**
     * 将数据源统一交给全绝xa事务管理
     * @return
     */
    @Bean("interviewDataSource")
    public DataSource interviewDataSource(InterviewConfig interviewConfig) throws SQLException {
        // 创建xaDataSource
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl(interviewConfig.getUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword(interviewConfig.getPassword());
        mysqlXADataSource.setUser(interviewConfig.getUserName());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);

        // 注册到全局事务
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName(interviewConfig.getUniqueResourceName());
        atomikosDataSourceBean.setMinPoolSize(interviewConfig.getMinPoolSize());
        atomikosDataSourceBean.setMaxPoolSize(interviewConfig.getMaxPoolSize());
        atomikosDataSourceBean.setMaxLifetime(interviewConfig.getMaxLifetime());
        atomikosDataSourceBean.setBorrowConnectionTimeout(interviewConfig.getBorrowConnectionTimeout());
        atomikosDataSourceBean.setLoginTimeout(interviewConfig.getLoginTimeout());
        atomikosDataSourceBean.setMaintenanceInterval(interviewConfig.getMaintenanceInterval());
        atomikosDataSourceBean.setMaxIdleTime(interviewConfig.getMaxIdleTime());
        atomikosDataSourceBean.setTestQuery(interviewConfig.getTestQuery());
        return atomikosDataSourceBean;
    }

    /**
     * 创建SqlSessionFactory
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean("interviewSqlSessionFactory")
    public SqlSessionFactory interviewSqlSessionFactory(@Qualifier("interviewDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        SqlSessionFactory object = sqlSessionFactoryBean.getObject();
        return object;
    }

//    @Bean("interviewTransactionManager")
//    public DataSourceTransactionManager interviewDataSourceTransactionManager(@Qualifier("interviewDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
    /**
     * 创建SqlSessionTemplate
     * @param sqlSessionFactory
     * @return
     */
    @Bean("interviewSqlSessionTemplate")
    public SqlSessionTemplate interviewSqlSessionTemplate(@Qualifier("interviewSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
