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

import tn.isi.dao.VehiculeRepository;
import tn.isi.entities.QVehicule;
import tn.isi.entities.Vehicule;

import com.querydsl.core.types.dsl.BooleanExpression;

@RestController
@RequestMapping( "/Vehicule" )
public class VehiculeController {
    private VehiculeRepository rep;

    public VehiculeController( VehiculeRepository rep ) {
        super();
        this.rep = rep;
    }

    @GetMapping( )
    public List<Vehicule> getAll() {
        return this.rep.findAll();
    }

    @PutMapping
    public Vehicule insert( @RequestBody Vehicule vehicule ) {
        return this.rep.insert( vehicule );
    }

    @PostMapping
    public Vehicule update( @RequestBody Vehicule vehicule ) {
        return this.rep.save( vehicule ); // upsert
    }

    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable( "id" ) String id ) {
        this.rep.delete( id );
    }

    @GetMapping( "/{id}" )
    public Vehicule getById( @PathVariable( "id" ) String id ) {
        return this.rep.findOne( id );
    }

    @GetMapping( "/places/{min}/{max}" )
    public List<Vehicule> getByPlaces( @PathVariable( "min" ) int min, @PathVariable( "max" ) int max ) {
        QVehicule q = new QVehicule( "1" );
        BooleanExpression filter1 = q.nombre_places.lt( max );
        BooleanExpression filter2 = q.nombre_places.gt( min );
        return (List<Vehicule>) this.rep.findAll( filter1.and( filter2 ) );
    }

    /*
     * @GetMapping( "/top-5" ) public List<Vehicule> getTop5() { QReservation
     * q=new QReservation( "1" ); //q.list_matricule_veh. //this.rep. }
     */
}
