package com.example.clientservice.connector;

import com.example.clientservice.model.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
// @RibbonClient(name = "book-service", configuration = RibbonConfiguration.class)
// @RibbonClient(name = "book-service")
public class RestTemplateConnector {
    private final RestTemplate restTemplate;

    @Value("${book-service.url}/${book-service.rest}")
    private String url;

    public RestTemplateConnector(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Book> data() {
        return List.of(restTemplate.getForObject(url, Book[].class));
    }

    public String getInfoFromBookService() {
        return restTemplate.getForObject("http://book-service/", String.class);
    }

    // @LoadBalanced
    // public RestTemplate getRestTemplate() {
    //     return new RestTemplate();
    // }
}
