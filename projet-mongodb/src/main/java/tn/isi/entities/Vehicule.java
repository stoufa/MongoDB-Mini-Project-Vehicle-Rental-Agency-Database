package tn.isi.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "Vehicule" )
public class Vehicule {

    @Id
    private String matricule_veh;
    private String marque_veh;
    private String puissance_veh;
    private int    nombre_places;
    private String code_type;    // clé étrangére
    private String code_local;   // clé étrangére

    public Vehicule() {
        super();
    }

    public Vehicule( String marque_veh, String puissance_veh, int nombre_places, String code_type, String code_local ) {
        super();
        this.marque_veh = marque_veh;
        this.puissance_veh = puissance_veh;
        this.nombre_places = nombre_places;
        this.code_type = code_type;
        this.code_local = code_local;
    }

    public String getCode_type() {
        return code_type;
    }

    public String getMatricule_veh() {
        return matricule_veh;
    }

    public String getMarque_veh() {
        return marque_veh;
    }

    public String getPuissance_veh() {
        return puissance_veh;
    }

    public int getNombre_places() {
        return nombre_places;
    }

    public String getCode_local() {
        return code_local;
    }

}