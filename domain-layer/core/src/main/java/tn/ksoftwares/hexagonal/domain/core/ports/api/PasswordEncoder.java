package tn.ksoftwares.hexagonal.domain.core.ports.api;

public interface PasswordEncoder {
    String encode(CharSequence rawPassword);
}
