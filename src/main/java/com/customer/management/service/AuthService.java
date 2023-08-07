package com.customer.management.service;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

    private final String AUTH_API_URL = "https://qa2.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp";

    public String authenticateAndGetToken(String loginId, String password) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "{\"login_id\":\"" + loginId + "\",\"password\":\"" + password + "\"}";
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
