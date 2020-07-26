package tn.isi.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "Reservation" )
public class Reservation {

    @Id
    private String       code_res;
    private Date         date_arrivee;
    private String       etat_res;          // accepté ou pas
    private String       destination;
    private Date         heure_arrivee;
    private String       commentaire;
    private int          nbr_voyageur;
    private List<String> list_matricule_veh; // clé étrangére

    public Reservation() {
        super();
    }

    public Reservation( Date date_arrivee, String etat_res, String destination, Date heure_arrivee, String commentaire,
            int nbr_voyageur, List<String> list_matricule_veh ) {
        super();
        this.date_arrivee = date_arrivee;
        this.etat_res = etat_res;
        this.destination = destination;
        this.heure_arrivee = heure_arrivee;
        this.commentaire = commentaire;
        this.nbr_voyageur = nbr_voyageur;
        this.list_matricule_veh = list_matricule_veh;
    }

    public String getCode_res() {
        return code_res;
    }

    public Date getDate_arrivee() {
        return date_arrivee;
    }

    public String getEtat_res() {
        return etat_res;
    }

    public String getDestination() {
        return destination;
    }

    public Date getHeure_arrivee() {
        return heure_arrivee;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public int getNbr_voyageur() {
        return nbr_voyageur;
    }

    public List<String> getList_matricule_veh() {
        return list_matricule_veh;
    }

}