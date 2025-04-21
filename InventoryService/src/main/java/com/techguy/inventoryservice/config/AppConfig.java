package com.techguy.inventoryservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ashiq
 * @createdOn 02/03/25 4:13 pm
 * @project AtxEcom
 **/
@Configuration
public class AppConfig
{

    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
}
