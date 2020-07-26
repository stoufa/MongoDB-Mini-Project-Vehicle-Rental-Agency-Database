package tn.isi.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "Administrateur" )
public class Administrateur {

    @Id
    private String code_admin;
    private String nom_admin;
    private String adresse_admin;
    private String mail_admin;
    private String type_admin;
    private String code_compte;  // clé étrangére

    public Administrateur() {
        super();
    }

    public Administrateur( String nom_admin, String adresse_admin, String mail_admin, String type_admin,
            String code_compte ) {
        super();
        this.nom_admin = nom_admin;
        this.adresse_admin = adresse_admin;
        this.mail_admin = mail_admin;
        this.type_admin = type_admin;
        this.code_compte = code_compte;
    }

    public String getCode_admin() {
        return code_admin;
    }

    public String getNom_admin() {
        return nom_admin;
    }

    public String getAdresse_admin() {
        return adresse_admin;
    }

    public String getMail_admin() {
        return mail_admin;
    }

    public String getType_admin() {
        return type_admin;
    }

    public String getCode_compte() {
        return code_compte;
    }

}