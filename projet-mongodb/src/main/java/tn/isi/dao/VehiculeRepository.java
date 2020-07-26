package tn.isi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import tn.isi.entities.Vehicule;

public interface VehiculeRepository extends MongoRepository<Vehicule, String>, QueryDslPredicateExecutor<Vehicule> {

}
