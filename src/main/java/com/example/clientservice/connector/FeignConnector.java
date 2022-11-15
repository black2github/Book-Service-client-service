package com.example.clientservice.connector;

import com.example.clientservice.config.FeignConfig;
import com.example.clientservice.model.Book;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(
        name = "book-service",
        // url = "${book-service.url}",
        configuration = FeignConfig.class
)
@RibbonClient(name = "book-service")
@Component
public interface FeignConnector {
    @GetMapping("${book-service.feign}")
    List<Book> getAllBooksList();

    @RequestMapping("/")
    String getInfoFromBookService();
}
