package tn.ksoftwares.hexagonal.persistence.mapper;

import tn.ksoftwares.hexagonal.persistence.entity.UserEntity;
import tn.ksoftwares.hexagonal.domain.model.pojo.User;

public interface UserMapper {
    
    User toDto(UserEntity entity);
    UserEntity toEntity(User dto);
    
}
