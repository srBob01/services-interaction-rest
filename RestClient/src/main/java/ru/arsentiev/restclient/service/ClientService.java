package ru.arsentiev.restclient.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ClientService {

    private final RestTemplate restTemplate;
    private final String serverBaseUrl;

    public ClientService(RestTemplate restTemplate, @Value("${server.base-url}") String serverBaseUrl) {
        this.restTemplate = restTemplate;
        this.serverBaseUrl = serverBaseUrl;
    }

    public void fetchDataFromServer() {
        log.info("Sending request to server at: {}", serverBaseUrl);

        // Отправляем синхронный запрос
        String response = restTemplate.getForObject(serverBaseUrl, String.class);
        log.info("Response from server: {}", response);

        log.info("End of interaction");
    }
}
