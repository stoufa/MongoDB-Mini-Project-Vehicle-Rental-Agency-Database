package tn.isi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import tn.isi.entities.Compte;

public interface CompteRepository extends MongoRepository<Compte, String>, QueryDslPredicateExecutor<Compte> {

}
