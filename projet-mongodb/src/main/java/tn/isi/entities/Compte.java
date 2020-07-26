package tn.isi.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "Compte" )
public class Compte {

    @Id
    private String code_compte;
    private String login;
    private String mot_de_passe_compte;

    public Compte() {
        super();
    }

    public Compte( String login, String mot_de_passe_compte ) {
        super();
        this.login = login;
        this.mot_de_passe_compte = mot_de_passe_compte;
    }

    public String getCode_compte() {
        return code_compte;
    }

    public String getLogin() {
        return login;
    }

    public String getMot_de_passe_compte() {
        return mot_de_passe_compte;
    }

}