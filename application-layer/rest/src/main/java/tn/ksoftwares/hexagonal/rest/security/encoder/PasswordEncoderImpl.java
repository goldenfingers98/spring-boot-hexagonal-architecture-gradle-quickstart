package tn.ksoftwares.hexagonal.rest.security.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import tn.ksoftwares.hexagonal.domain.core.ports.api.PasswordEncoder;

public class PasswordEncoderImpl extends BCryptPasswordEncoder implements PasswordEncoder {

}
