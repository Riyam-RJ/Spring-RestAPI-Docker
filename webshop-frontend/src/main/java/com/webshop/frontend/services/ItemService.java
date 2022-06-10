package com.webshop.frontend.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webshop.frontend.dto.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ItemService {

    @Value("${backend.url}")
    private String BASE_URL;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public List<Item> findAllItems() {

        ResponseEntity<Map<String, Object>> responseEntity = restTemplate.exchange(
                BASE_URL + "items",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Map<String, Object>>() {
                }
        );

        if (responseEntity.getBody().get("STATUS").equals("SUCCESS")) {

            @SuppressWarnings("unchecked")
            List<Item> itemList = (List<Item>) responseEntity.getBody().get("DATA");

            return itemList;
        }

        return null;
    }

}
