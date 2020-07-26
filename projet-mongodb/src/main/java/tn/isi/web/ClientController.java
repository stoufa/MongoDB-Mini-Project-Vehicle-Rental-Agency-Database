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

import tn.isi.dao.ClientRepository;
import tn.isi.entities.Client;

@RestController
@RequestMapping( "/Client" )
public class ClientController {
    private ClientRepository rep;

    public ClientController( ClientRepository rep ) {
        super();
        this.rep = rep;
    }

    @GetMapping( )
    public List<Client> getAll() {
        return this.rep.findAll();
    }

    @PutMapping
    public Client insert( @RequestBody Client client ) {
        return this.rep.insert( client );
    }

    @PostMapping
    public Client update( @RequestBody Client client ) {
        return this.rep.save( client ); // upsert
    }

    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable( "id" ) String id ) {
        this.rep.delete( id );
    }

    @GetMapping( "/{id}" )
    public Client getById( @PathVariable( "id" ) String id ) {
        return this.rep.findOne( id );
    }

    /*
     * @GetMapping( "/top-5" ) public List<Client> getTop5() { // }
     */
}
