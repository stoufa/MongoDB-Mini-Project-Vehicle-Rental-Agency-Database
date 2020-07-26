package tn.isi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import tn.isi.entities.Type_veh;

public interface Type_vehRepository extends MongoRepository<Type_veh, String>, QueryDslPredicateExecutor<Type_veh> {

    // List<Type_veh> findByTarifLessThan( float t );

}
