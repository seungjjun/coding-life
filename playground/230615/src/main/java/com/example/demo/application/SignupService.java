package com.example.demo.application;

import com.example.demo.exceptions.UserAlreadyExistsException;
import com.example.demo.infrastructor.UserDetailsDao;
import com.example.demo.utils.AccessTokenGenerator;
import io.hypersistence.tsid.TSID;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SignupService {
    private final UserDetailsDao userDetailsDao;
    private final PasswordEncoder passwordEncoder;
    private final AccessTokenGenerator accessTokenGenerator;

    public SignupService(UserDetailsDao userDetailsDao,
                         PasswordEncoder passwordEncoder,
                         AccessTokenGenerator accessTokenGenerator) {
        this.userDetailsDao = userDetailsDao;
        this.passwordEncoder = passwordEncoder;
        this.accessTokenGenerator = accessTokenGenerator;
    }

    public String signup(String username, String password) {
        if (userDetailsDao.existsByUsername(username)) {
            throw new UserAlreadyExistsException();
        }

        String id = TSID.Factory.getTsid().toString();
        String encodedPassword = passwordEncoder.encode(password);
        String accessToken = accessTokenGenerator.generate(id);

        userDetailsDao.addUser(id, username, encodedPassword);
        userDetailsDao.addAccessToken(id, accessToken);

        return accessToken;
    }
}
