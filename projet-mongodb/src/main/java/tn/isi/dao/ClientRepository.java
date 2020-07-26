package tn.isi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import tn.isi.entities.Client;

public interface ClientRepository extends MongoRepository<Client, String>, QueryDslPredicateExecutor<Client> {

}
