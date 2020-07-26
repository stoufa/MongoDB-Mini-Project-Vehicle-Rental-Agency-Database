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

import tn.isi.dao.LocaliteRepository;
import tn.isi.entities.Localite;
import tn.isi.entities.QLocalite;

import com.querydsl.core.types.dsl.BooleanExpression;

@RestController
@RequestMapping( "/Localite" )
public class LocaliteController {
    private LocaliteRepository rep;

    public LocaliteController( LocaliteRepository rep ) {
        super();
        this.rep = rep;
    }

    @GetMapping( )
    public List<Localite> getAll() {
        return this.rep.findAll();
    }

    @PutMapping
    public Localite insert( @RequestBody Localite localite ) {
        return this.rep.insert( localite );
    }

    @PostMapping
    public Localite update( @RequestBody Localite localite ) {
        return this.rep.save( localite ); // upsert
    }

    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable( "id" ) String id ) {
        System.out.println( "id:" + id );
        this.rep.delete( id );
    }

    @GetMapping( "/{id}" )
    public Localite getById( @PathVariable( "id" ) String id ) {
        QLocalite qLocalite = new QLocalite( "1" );
        BooleanExpression filter = qLocalite.code_local.eq( id );
        return this.rep.findOne( filter );
    }

    @GetMapping( "/nom/{nom}" )
    public List<Localite> getByNomLocalite( @PathVariable( "nom" ) String nom ) {
        QLocalite qLocalite = new QLocalite( "1" );
        BooleanExpression filter = qLocalite.nom_local.like( "%" + nom + "%" );
        return (List<Localite>) this.rep.findAll( filter );
    }
}
