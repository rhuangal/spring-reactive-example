package com.rhuangal.springreactiveexample;

import com.rhuangal.springreactiveexample.domain.Product;
import com.rhuangal.springreactiveexample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class SpringReactiveExampleApplication implements CommandLineRunner {

	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// save list Customers
		productRepository.saveAll(Arrays.asList(new Product(new Long(1), "LAPICERO", new BigDecimal(4.00),"COLOR AZUL", "/lapicero"),
				new Product(new Long(2), "TEMPERA", new BigDecimal(1.00),"COLOR AZUL", "/tempera"),
				new Product(new Long(3), "CARTULINA", new BigDecimal(2.30),"COLOR AZUL", "/catulina"),
				new Product(new Long(4), "PLUMON", new BigDecimal(6.00),"COLOR AZUL", "/plumon")
				)
		).subscribe(System.out::println);
	}
}
