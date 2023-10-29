package tn.ksoftwares.hexagonal.persistence.adapter;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import tn.ksoftwares.hexagonal.domain.core.ports.spi.UserPersistence;
import tn.ksoftwares.hexagonal.domain.model.exception.DomainConstraintViolationException;
import tn.ksoftwares.hexagonal.domain.model.exception.EmailAlreadyUsedException;
import tn.ksoftwares.hexagonal.domain.model.exception.UserNameAlreadyUsedException;
import tn.ksoftwares.hexagonal.domain.model.pojo.User;
import tn.ksoftwares.hexagonal.persistence.entity.UserEntity;
import tn.ksoftwares.hexagonal.persistence.entity.constraint.UserConstraint;
import tn.ksoftwares.hexagonal.persistence.mapper.UserMapper;
import tn.ksoftwares.hexagonal.persistence.repository.UserRepository;

public class UserPersistenceImpl implements UserPersistence {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public void add(User user)
            throws EmailAlreadyUsedException, UserNameAlreadyUsedException, DomainConstraintViolationException {
        UserEntity entity = mapper.toEntity(user);
        try {
            userRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            if (e.getCause() instanceof ConstraintViolationException) {
                String constaintName = ((ConstraintViolationException) e.getCause()).getConstraintName();
                UserConstraint constraint = UserConstraint.getConstraintByName(constaintName.toUpperCase());
                if (constraint == UserConstraint.UNIQUE_EMAIL) {
                    throw new EmailAlreadyUsedException();
                } else if (constraint == UserConstraint.UNIQUE_USERNAME) {
                    throw new UserNameAlreadyUsedException();
                }
            }
            throw e;
        }
    }

}
