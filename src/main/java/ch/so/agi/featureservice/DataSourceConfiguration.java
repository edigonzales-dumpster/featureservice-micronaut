package ch.so.agi.featureservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.sql.DataSource;

import ch.so.agi.featureservice.AppConfiguration.Datasource;
import io.micronaut.context.annotation.Bean;

@Singleton
public class DataSourceConfiguration {

    @Inject
    AppConfiguration config;

    @Bean
    public Map<String, DataSource> getDataSources() {
        Map<String, DataSource> datasources = new HashMap<String, DataSource>();

        List<Datasource> configDatasources = config.getDatasources();
        for (Datasource configDatasource : configDatasources) {
            String dsId = configDatasource.getId();
            String dsUrl = configDatasource.getUrl() + "?ApplicationName=sogis-featureservice";
            String dsUser = configDatasource.getUser();
            String dsPassword = configDatasource.getPassword();

            System.out.println(dsId + " " + dsUrl);

            org.apache.tomcat.jdbc.pool.DataSource datasource = new org.apache.tomcat.jdbc.pool.DataSource();            
            datasource.setName(dsId);
            datasource.setMaxActive(10);
            datasource.setMinIdle(2);
            datasource.setMaxIdle(10);            
            datasource.setInitialSize(2);
            
            datasources.put(dsId, datasource);
        }

        return datasources;
    }
}
