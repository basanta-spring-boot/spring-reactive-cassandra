package com.basant.spring.boot.cassandra.api.repository;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import com.basant.spring.boot.cassandra.api.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveCassandraRepository<Customer, Integer> {

	@AllowFiltering
	Flux<Customer> findByAgeLessThan(int age);

	
	Flux<Customer> findAllByOrderByIdAsc();

	@AllowFiltering
	Mono<Customer> findByFirstname(String firstname);
}
