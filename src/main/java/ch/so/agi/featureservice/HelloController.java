package ch.so.agi.featureservice;

import javax.inject.Inject;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/hello") 
public class HelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

//    @Inject
//    TeamConfiguration teamConfiguration;
    
//    @Inject
//    AppConfiguration appConfiguration;
    
    // TODO: Klasse auch z.B. für Datasets etc. Dataset sollte einfach verknüpfbar sein du Datasource, d.h.
    // darf nich lange gehen.
    
    
    @Inject
    DataSourceConfiguration dataSourceConfiguration;

    
    @Get 
    @Produces(MediaType.TEXT_PLAIN) 
    public String index() {
        
        dataSourceConfiguration.getDataSources();
        
        
        LOGGER.info(String.valueOf(dataSourceConfiguration.hashCode()));
                
        return "Hello World"; 
    }

}
