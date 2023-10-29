package tn.ksoftwares.hexagonal.persistence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tn.ksoftwares.hexagonal.persistence.mapper.UserMapper;
import tn.ksoftwares.hexagonal.persistence.mapper.impl.UserMapperImpl;

@Configuration
public class TestConfiguration {
    
    @Bean
    public UserMapper getUserMapper() {
        return new UserMapperImpl();
    }
    
}
