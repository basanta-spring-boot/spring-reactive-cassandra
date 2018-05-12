package com.basant.spring.boot.cassandra.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.basant.spring.boot.cassandra.api.model.Customer;
import com.basant.spring.boot.cassandra.api.repository.CustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class SpringReactiveCassandraApplication {
	
	
	@Autowired
	private CustomerRepository repository;

	@GetMapping("/getCustomersFilterByAge/{age}")
	public Flux<Customer> getCustomersFilterByAge(@PathVariable int age) {
		return repository.findByAgeLessThan(age);
	}

	@GetMapping("/getCustomersOrderById")
	public Flux<Customer> getCustomersOrderById() {
		return repository.findAllByOrderByIdAsc();
	}

	@GetMapping("/getCustomerByName/{name}")
	public Mono<Customer> getCustomerByName(@PathVariable String name) {
		return repository.findByFirstname(name);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveCassandraApplication.class, args);
	}
}
