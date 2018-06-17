package com.rhuangal.springreactiveexample.business.impl;

import com.rhuangal.springreactiveexample.business.ProductService;
import com.rhuangal.springreactiveexample.domain.Product;
import com.rhuangal.springreactiveexample.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.Duration;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Flux<Product> dummy() {
        return Flux
                .just(new Product("lapicero punta fina",new BigDecimal(4.00)),
                        new Product("hojas bond 80 gr.", new BigDecimal(12.90)),
                        new Product("cartulina pliego", new BigDecimal(2.90)))
                .concatMap(pro -> Flux.just(pro).delayElements(Duration.ofSeconds(3)))
                .doOnNext(pro -> {
                    log.debug("producto :");
                });
    }

    @Override
    public Flux<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Flux<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Flux<Product> findByName(Mono<String> name) {
        return productRepository.findByName(name);
    }

    @Override
    public Mono<Product> findByNameAndImageUrl(Mono<String> name, String imageUrl) {
        return productRepository.findByNameAndImageUrl(name, imageUrl);
    }

    @Override
    public Mono<Product> findByNameAndImageUrl(String name, String imageUrl) {
        return productRepository.findByNameAndImageUrl(name, imageUrl);
    }
}
