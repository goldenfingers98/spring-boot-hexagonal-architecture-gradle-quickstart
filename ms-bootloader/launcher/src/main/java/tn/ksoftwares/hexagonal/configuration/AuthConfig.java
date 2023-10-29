package tn.ksoftwares.hexagonal.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.fasterxml.jackson.databind.ObjectMapper;

import tn.ksoftwares.hexagonal.persistence.adapter.UserPersistenceImpl;
import tn.ksoftwares.hexagonal.persistence.mapper.UserMapper;
import tn.ksoftwares.hexagonal.persistence.mapper.impl.UserMapperImpl;
import tn.ksoftwares.hexagonal.rest.security.encoder.PasswordEncoderImpl;
import tn.ksoftwares.hexagonal.domain.core.ports.api.PasswordEncoder;
import tn.ksoftwares.hexagonal.domain.core.ports.api.UserService;
import tn.ksoftwares.hexagonal.domain.core.ports.spi.UserPersistence;
import tn.ksoftwares.hexagonal.domain.core.service.UserServiceImpl;

@Configuration
public class AuthConfig {

    @Bean
    @Scope("prototype")
    public Logger getLogger(final InjectionPoint ip) {
        Class<?> clazz = ip.getMember().getDeclaringClass();
        return LoggerFactory.getLogger(clazz);
    }

    @Bean
    public ObjectMapper getMapper() {
        return new ObjectMapper();
    }

    @Bean
    public UserMapper getUserMapper() {
        return new UserMapperImpl();
    }

    @Bean
    public UserPersistence getUserPersistence() {
        return new UserPersistenceImpl();
    }

    @Bean
    public UserService getUserService() {
        return new UserServiceImpl();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoderImpl();
    }
}