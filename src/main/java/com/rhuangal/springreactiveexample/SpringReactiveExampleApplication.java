package com.rhuangal.springreactiveexample;

import com.rhuangal.springreactiveexample.domain.Product;
import com.rhuangal.springreactiveexample.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class SpringReactiveExampleApplication implements CommandLineRunner {

	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	    /* Save data for test */
		productRepository.saveAll(Arrays.asList(new Product(Long.valueOf("1"), "LAPICERO", BigDecimal.valueOf(4.00),"STABILO COLOR AZUL", "/lapicero"),
				new Product(Long.valueOf("2"), "TEMPERA", BigDecimal.valueOf(3.00),"COLOR ROJO", "/tempera"),
				new Product(Long.valueOf("3"), "CARTULINA", BigDecimal.valueOf(2.30),"COLOR AMARILLO", "/catulina"),
				new Product(Long.valueOf("4"), "PLUMON", BigDecimal.valueOf(6.00),"STABILO COLOR VERDE", "/plumon")
				)
		).log();
	}
}
