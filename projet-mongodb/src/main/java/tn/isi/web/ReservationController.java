package tn.isi.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.isi.dao.ReservationRepository;
import tn.isi.entities.QReservation;
import tn.isi.entities.Reservation;

import com.querydsl.core.types.dsl.BooleanExpression;

@RestController
@RequestMapping( "/Reservation" )
public class ReservationController {
    private ReservationRepository rep;

    public ReservationController( ReservationRepository rep ) {
        super();
        this.rep = rep;
    }

    @GetMapping( )
    public List<Reservation> getAll() {
        return this.rep.findAll();
    }

    @PutMapping
    public Reservation insert( @RequestBody Reservation reservation ) {
        return this.rep.insert( reservation );
    }

    @PostMapping
    public Reservation update( @RequestBody Reservation reservation ) {
        return this.rep.save( reservation ); // upsert
    }

    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable( "id" ) String id ) {
        this.rep.delete( id );
    }

    @GetMapping( "/{id}" )
    public Reservation getById( @PathVariable( "id" ) String id ) {
        return this.rep.findOne( id );
    }

    @GetMapping( "/acc" )
    public List<Reservation> getAcc() {
        QReservation q = new QReservation( "1" );
        BooleanExpression b = q.etat_res.eq( "acc" );
        return (List<Reservation>) this.rep.findAll( b );
    }

    @GetMapping( "/att" )
    public List<Reservation> getAtt() {
        QReservation q = new QReservation( "1" );
        BooleanExpression b = q.etat_res.eq( "att" );
        return (List<Reservation>) this.rep.findAll( b );
    }

    @GetMapping( "/ref" )
    public List<Reservation> getRef() {
        QReservation q = new QReservation( "1" );
        BooleanExpression b = q.etat_res.eq( "ref" );
        return (List<Reservation>) this.rep.findAll( b );
    }
}
