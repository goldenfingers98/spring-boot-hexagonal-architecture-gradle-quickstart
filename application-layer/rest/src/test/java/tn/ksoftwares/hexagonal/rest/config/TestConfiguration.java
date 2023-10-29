package tn.ksoftwares.hexagonal.rest.config;

import org.mockito.Mockito;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import tn.ksoftwares.hexagonal.domain.core.ports.api.UserService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "tn.ksoftwares.hexagonal.rest.controller.implementation")
public class TestConfiguration {

    @Bean
    public UserService getUserService() {
        return Mockito.mock(UserService.class);
    }

    @Bean
    public Logger getLogger() {
        return Mockito.mock(Logger.class);
    }
    
}
