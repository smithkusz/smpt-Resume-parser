package com.example.demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import com.example.demo.model.Customer;

@EnableElasticsearchRepositories
public interface CustomerRepository extends ElasticsearchRepository<Customer,String>{

}
