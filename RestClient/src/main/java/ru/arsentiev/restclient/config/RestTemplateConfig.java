package ru.arsentiev.restclient.config;

import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        // Настраиваем HTTP-клиент
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(100); // Максимальное количество соединений
        connectionManager.setDefaultMaxPerRoute(20); // Максимальное количество соединений на маршрут

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(
                HttpClients.custom()
                        .setConnectionManager(connectionManager)
                        .build()
        );

        // Устанавливаем таймауты
        requestFactory.setConnectTimeout(5000); // Таймаут подключения в миллисекундах
        requestFactory.setReadTimeout(5000); // Таймаут чтения данных в миллисекундах

        return new RestTemplate(requestFactory);
    }
}

