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

import tn.isi.dao.AdministrateurRepository;
import tn.isi.entities.Administrateur;

@RestController
@RequestMapping( "/Administrateur" )
public class AdministrateurController {
    private AdministrateurRepository rep;

    public AdministrateurController( AdministrateurRepository rep ) {
        super();
        this.rep = rep;
    }

    @GetMapping( )
    public List<Administrateur> getAll() {
        return this.rep.findAll();
    }

    @PutMapping
    public Administrateur insert( @RequestBody Administrateur administrateur ) {
        return this.rep.insert( administrateur );
    }

    @PostMapping
    public Administrateur update( @RequestBody Administrateur administrateur ) {
        return this.rep.save( administrateur ); // upsert
    }

    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable( "id" ) String id ) {
        this.rep.delete( id );
    }

    @GetMapping( "/{id}" )
    public Administrateur getById( @PathVariable( "id" ) String id ) {
        return this.rep.findOne( id );
    }
}
