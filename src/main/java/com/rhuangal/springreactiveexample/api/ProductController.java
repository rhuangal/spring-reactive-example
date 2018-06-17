package com.rhuangal.springreactiveexample.api;

import com.rhuangal.springreactiveexample.business.ProductService;
import com.rhuangal.springreactiveexample.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/product")
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/dummy", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Product> dummy() {
        return productService.dummy();
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Product> findAll() {
        return productService.findAll();
    }

}
