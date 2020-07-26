package tn.isi.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "Type_veh" )
public class Type_veh {

    @Id
    private String code_type;
    private String nom_type;
    private float  tarif;

    public Type_veh() {
        super();
    }

    public Type_veh( String nom_type, float tarif ) {
        super();
        this.nom_type = nom_type;
        this.tarif = tarif;
    }

    public String getCode_type() {
        return code_type;
    }

    public String getNom_type() {
        return nom_type;
    }

    public float getTarif() {
        return tarif;
    }

}