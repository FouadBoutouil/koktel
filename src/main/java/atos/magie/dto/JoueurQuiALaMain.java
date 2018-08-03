/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie.dto;

/**
 *
 * @author Administrateur
 */
public class JoueurQuiALaMain {
    private long idJoueur;
    private String monJoueur;

    public void setIdJoueur(long idJoueur) {
        this.idJoueur = idJoueur;
    }

    public void setMonJoueur(String monJoueur) {
        this.monJoueur = monJoueur;
    }

    public long getIdJoueur() {
        return idJoueur;
    }

    public String getMonJoueur() {
        return monJoueur;
    }
    
}
