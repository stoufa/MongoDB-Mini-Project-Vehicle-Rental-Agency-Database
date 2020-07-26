package tn.isi.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "Client" )
public class Client {

    @Id
    private String       code_client;
    private String       nom_client;
    private String       adresse_client;
    private String       tel_client;
    private String       mail_client;
    private List<String> list_code_res; // clé étrangére

    public Client() {
        super();
    }

    public Client( String nom_client, String adresse_client, String tel_client, String mail_client,
            List<String> list_code_res ) {
        super();
        this.nom_client = nom_client;
        this.adresse_client = adresse_client;
        this.tel_client = tel_client;
        this.mail_client = mail_client;
        this.list_code_res = list_code_res;
    }

    public String getCode_client() {
        return code_client;
    }

    public String getNom_client() {
        return nom_client;
    }

    public String getAdresse_client() {
        return adresse_client;
    }

    public String getTel_client() {
        return tel_client;
    }

    public String getMail_client() {
        return mail_client;
    }

    public List<String> getList_code_res() {
        return list_code_res;
    }

}