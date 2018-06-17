package com.rhuangal.springreactiveexample.business;

import com.rhuangal.springreactiveexample.domain.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    Flux<Product> dummy();

    Flux<Product> findAll();

    Flux<Product> findByName(String name);

    Flux<Product> findByName(Mono<String> name);

    Mono<Product> findByNameAndImageUrl(Mono<String> name, String imageUrl);

    Mono<Product> findByNameAndImageUrl(String name, String imageUrl);
}
