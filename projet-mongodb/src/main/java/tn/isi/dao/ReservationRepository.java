package tn.isi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import tn.isi.entities.Reservation;

public interface ReservationRepository extends MongoRepository<Reservation, String>,
        QueryDslPredicateExecutor<Reservation> {

}
