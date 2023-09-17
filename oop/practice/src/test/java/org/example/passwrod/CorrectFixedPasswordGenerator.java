package org.example.passwrod;

import org.example.password.PasswordGenerator;

public class CorrectFixedPasswordGenerator implements PasswordGenerator {
    @Override
    public String generatePassword() {
        return "password";
    }
}
