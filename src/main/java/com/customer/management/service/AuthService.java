package com.customer.management.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

    private final String AUTH_API_URL = "https://qa2.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp";
    private final String LOGIN_ID = "test@sunbasedata.com";
    private final String PASSWORD = "Test@123";

    public String authenticateAndGetToken() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "{\"login_id\":\"" + LOGIN_ID + "\",\"password\":\"" + PASSWORD + "\"}";
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(AUTH_API_URL, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            // Parse the response to extract the token
            String responseBody = response.getBody(); // This should be the token
            return responseBody;
        } else {
            // Handle authentication failure
            return null;
        }
    }
}


