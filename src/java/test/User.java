/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author palaye
 */
public class User {
    
    private int id ;
    private String prenom ;
    private String nom ;
    private int telephone ;

    public User(int id, String prenom, String nom, int telephone) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    

  

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    
    
    
}
