package tn.ksoftwares.hexagonal.persistence.mapper;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import nl.jqno.equalsverifier.EqualsVerifier;
import tn.ksoftwares.hexagonal.persistence.entity.UserEntity;
import tn.ksoftwares.hexagonal.domain.model.pojo.User;
import tn.ksoftwares.hexagonal.domain.model.utils.Email;
import tn.ksoftwares.hexagonal.domain.model.utils.Name;
import tn.ksoftwares.hexagonal.domain.model.utils.Password;
import tn.ksoftwares.hexagonal.domain.model.utils.Username;
import tn.ksoftwares.hexagonal.persistence.config.TestConfiguration;

@SpringBootTest
@ContextConfiguration(classes = TestConfiguration.class)
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testToEntity() {
        // when
        User user = new User(
                UUID.randomUUID(),
                new Name("Khaldoun"),
                new Name("middlename"),
                new Name("CHTOUROU"),
                new Email("tchtourou21@gmail.com"),
                new Username("goldenfingers98"),
                new Password("Qwerty*123"));
        // expected
        UserEntity expectedUserEntity = new UserEntity(
                user.getId(),
                "Khaldoun",
                "middlename",
                "CHTOUROU",
                "tchtourou21@gmail.com",
                "goldenfingers98",
                "Qwerty*123");
        // then
        UserEntity actualUserEntity = userMapper.toEntity(user);
        assertEquals(actualUserEntity, expectedUserEntity, "Mapped entity should be equal to the expected one.");
    }

    @Test
    void testToDto() {
        // when
        UserEntity userEntity = new UserEntity(
                UUID.randomUUID(),
                "Khaldoun",
                "middlename",
                "CHTOUROU",
                "tchtourou21@gmail.com",
                "goldenfingers98",
                "Qwerty*123");
        // expected
        User expectedUser = new User(
                userEntity.getId(),
                new Name("Khaldoun"),
                new Name("middlename"),
                new Name("CHTOUROU"),
                new Email("tchtourou21@gmail.com"),
                new Username("goldenfingers98"),
                new Password("Qwerty*123"));
        // then
        User actualUser = userMapper.toDto(userEntity);
        assertEquals(expectedUser, actualUser, "Mapped dto should be equal to the expected one");
    }

    @Test
    void testNullMapping() {
        assertNull(userMapper.toDto(null), "Null mapping should return a null object.");
        assertNull(userMapper.toEntity(null), "Null mapping should return a null object.");
    }

    @Test
    void testEqualsHashCodeContract() {
        EqualsVerifier.forClass(UserEntity.class).verify();
    }

}
