package tn.ksoftwares.hexagonal.domain.core.ports.spi;

import tn.ksoftwares.hexagonal.domain.model.exception.DomainConstraintViolationException;
import tn.ksoftwares.hexagonal.domain.model.exception.EmailAlreadyUsedException;
import tn.ksoftwares.hexagonal.domain.model.exception.UserNameAlreadyUsedException;
import tn.ksoftwares.hexagonal.domain.model.pojo.User;

public interface UserPersistence {
    void add(User user) throws EmailAlreadyUsedException, UserNameAlreadyUsedException, DomainConstraintViolationException;
}
