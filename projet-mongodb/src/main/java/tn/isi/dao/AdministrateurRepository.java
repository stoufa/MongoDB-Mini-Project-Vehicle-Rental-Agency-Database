package tn.isi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import tn.isi.entities.Administrateur;

public interface AdministrateurRepository extends MongoRepository<Administrateur, String>,
        QueryDslPredicateExecutor<Administrateur> {

}
