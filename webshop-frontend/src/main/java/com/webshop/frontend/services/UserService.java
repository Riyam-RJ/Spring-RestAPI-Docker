package com.webshop.frontend.services;

import com.webshop.frontend.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class UserService {

    @Value("${backend.url}")
    private String BASE_URL;

    private final RestTemplate restTemplate;

    public User saveUser(User user) {

        ResponseEntity<User> response = restTemplate.
                postForEntity(BASE_URL + "users/sign-up", user, User.class);

        return response.getBody();
    }

}
