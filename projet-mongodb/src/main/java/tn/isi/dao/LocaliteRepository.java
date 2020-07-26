package tn.isi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import tn.isi.entities.Localite;

public interface LocaliteRepository extends MongoRepository<Localite, String>, QueryDslPredicateExecutor<Localite> {

}
