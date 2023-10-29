package tn.ksoftwares.hexagonal.domain.core.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import tn.ksoftwares.hexagonal.domain.core.ports.api.UserService;
import tn.ksoftwares.hexagonal.domain.core.ports.spi.UserPersistence;
import tn.ksoftwares.hexagonal.domain.model.exception.DomainConstraintViolationException;
import tn.ksoftwares.hexagonal.domain.model.exception.EmailAlreadyUsedException;
import tn.ksoftwares.hexagonal.domain.model.exception.UserNameAlreadyUsedException;
import tn.ksoftwares.hexagonal.domain.model.pojo.User;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserPersistence userPersistence;

    @Autowired
    private Logger logger;

    @Override
    public void saveUser(User user) throws EmailAlreadyUsedException, UserNameAlreadyUsedException, DomainConstraintViolationException {
        logger.info("Adding user {}", user);
        userPersistence.add(user);
        logger.info("User added successfully {}", user);
    }
    
}
