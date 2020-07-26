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

import tn.isi.dao.Type_vehRepository;
import tn.isi.entities.QType_veh;
import tn.isi.entities.Type_veh;

import com.querydsl.core.types.dsl.BooleanExpression;

@RestController
@RequestMapping( "/Type_veh" )
public class Type_vehController {
    private Type_vehRepository rep;

    public Type_vehController( Type_vehRepository rep ) {
        super();
        this.rep = rep;
    }

    @GetMapping( )
    public List<Type_veh> getAll() {
        return this.rep.findAll();
    }

    @PutMapping
    public Type_veh insert( @RequestBody Type_veh type_veh ) {
        return this.rep.insert( type_veh );
    }

    @PostMapping
    public Type_veh update( @RequestBody Type_veh type_veh ) {
        return this.rep.save( type_veh ); // upsert
    }

    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable( "id" ) String id ) {
        this.rep.delete( id );
        // QType_veh q = new QType_veh( "1" );
        // BooleanExpression e = q.code_type.eq( id );
        // Type_veh elt = this.type_vehRepository.findOne( e );
        // System.out.println( elt );
        // this.type_vehRepository.delete( elt );
    }

    @GetMapping( "/{id}" )
    public Type_veh getById( @PathVariable( "id" ) String id ) {
        QType_veh qType_veh = new QType_veh( "1" );
        BooleanExpression filter = qType_veh.code_type.eq( id );
        return this.rep.findOne( filter );
    }

    @GetMapping( "/tarif/{t}" )
    public List<Type_veh> getByTarif( @PathVariable( "t" ) float tarif ) {
        // List<Type_veh> list_type_veh =
        // this.type_vehRepository.findByTarifLessThan( tarif );
        // return list_type_veh;

        QType_veh qType_veh = new QType_veh( "1" );
        BooleanExpression filter = qType_veh.tarif.lt( tarif );
        return (List<Type_veh>) this.rep.findAll( filter );
    }

    @GetMapping( "/tarif/{min}/{max}" )
    public List<Type_veh> getByTarif2( @PathVariable( "min" ) float min, @PathVariable( "max" ) float max ) {
        QType_veh qType_veh = new QType_veh( "1" );
        BooleanExpression filter1 = qType_veh.tarif.lt( max );
        BooleanExpression filter2 = qType_veh.tarif.gt( min );
        return (List<Type_veh>) this.rep.findAll( filter1.and( filter2 ) );
    }
}
