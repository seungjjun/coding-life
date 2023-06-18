package com.example.demo.application;

import com.example.demo.infrastructor.UserDetailsDao;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LogoutService {
    private final UserDetailsDao userDetailsDao;

    public LogoutService(UserDetailsDao userDetailsDao) {
        this.userDetailsDao = userDetailsDao;
    }

    public void logout(String accessToken) {
        userDetailsDao.removeAccessToken(accessToken);
    }
}
