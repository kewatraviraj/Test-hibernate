/**
 * 
 *//*
package org.noxml.hibernate;

import javax.sql.DataSource;

*//**
 * @author Dell
 *
 *//*
@Configuration
public class RepositoryConfig{
    //${jdbc.driverClassName}
    @Value("${jdbc.driverClassName}")     private String driverClassName;
    @Value("${jdbc.url}")                 private String url;
    @Value("${jdbc.username}")             private String username;
    @Value("${jdbc.password}")             private String password;
    
    @Value("${hibernate.dialect}")         private String hibernateDialect;
    @Value("${hibernate.show_sql}")     private String hibernateShowSql;
    @Value("${hibernate.hbm2ddl.auto}") private String hibernateHbm2ddlAuto;
        
    @Bean()    
    public DataSource getDataSource()
    {
        DriverManagerDataSource ds = new DriverManagerDataSource();        
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);        
        return ds;
    }
}
*/