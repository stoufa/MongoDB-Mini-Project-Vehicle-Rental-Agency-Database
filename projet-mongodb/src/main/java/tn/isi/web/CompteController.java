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

import tn.isi.dao.CompteRepository;
import tn.isi.entities.Compte;
import tn.isi.entities.QCompte;

import com.querydsl.core.types.dsl.BooleanExpression;

@RestController
@RequestMapping( "/Compte" )
public class CompteController {
    private CompteRepository rep;

    public CompteController( CompteRepository rep ) {
        super();
        this.rep = rep;
    }

    @GetMapping( )
    public List<Compte> getAll() {
        return this.rep.findAll();
    }

    @PutMapping
    public Compte insert( @RequestBody Compte compte ) {
        return this.rep.insert( compte );
    }

    @PostMapping
    public Compte update( @RequestBody Compte compte ) {
        return this.rep.save( compte ); // upsert
    }

    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable( "id" ) String id ) {
        this.rep.delete( id );
    }

    @GetMapping( "/{id}" )
    public Compte getById( @PathVariable( "id" ) String id ) {
        return this.rep.findOne( id );
    }

    @GetMapping( "/pwd-len/{max}" )
    public List<Compte> getByPwdLen( @PathVariable( "max" ) int max ) {
        QCompte q = new QCompte( "1" );
        BooleanExpression filter = q.mot_de_passe_compte.length().lt( max );
        return (List<Compte>) this.rep.findAll( filter );
    }
}
