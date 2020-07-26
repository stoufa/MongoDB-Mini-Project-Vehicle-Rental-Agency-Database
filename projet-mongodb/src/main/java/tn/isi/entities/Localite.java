package tn.isi.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "Localite" )
public class Localite {

    @Id
    private String code_local;
    private String nom_local;

    public Localite() {
        super();
    }

    public Localite( String nom_local ) {
        super();
        this.nom_local = nom_local;
    }

    public String getCode_local() {
        return code_local;
    }

    public String getNom_local() {
        return nom_local;
    }

}