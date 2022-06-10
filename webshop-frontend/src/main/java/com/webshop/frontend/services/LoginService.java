package com.webshop.frontend.services;

import com.webshop.frontend.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class LoginService {

    @Value("${backend.url}")
    private String BASE_URL;

    private final RestTemplate restTemplate;

    public String validateUser(User user) {

        ResponseEntity<String> response = restTemplate.
                postForEntity(BASE_URL + "authenticate", user, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

}
