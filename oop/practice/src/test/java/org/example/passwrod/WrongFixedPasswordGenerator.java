package org.example.passwrod;

import org.example.password.PasswordGenerator;

public class WrongFixedPasswordGenerator implements PasswordGenerator {
    @Override
    public String generatePassword() {
        return "xx";
    }
}
