package tn.ksoftwares.hexagonal.domain.core.ports.api;


import tn.ksoftwares.hexagonal.domain.model.exception.DomainConstraintViolationException;
import tn.ksoftwares.hexagonal.domain.model.exception.EmailAlreadyUsedException;
import tn.ksoftwares.hexagonal.domain.model.exception.MalformedFieldException;
import tn.ksoftwares.hexagonal.domain.model.exception.UserNameAlreadyUsedException;
import tn.ksoftwares.hexagonal.domain.model.pojo.User;

public interface UserService {
    
    void saveUser(User user) throws EmailAlreadyUsedException, UserNameAlreadyUsedException, DomainConstraintViolationException, MalformedFieldException;

}
