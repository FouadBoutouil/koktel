/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie.dao;

import atos.magie.entity.Carte;
import atos.magie.entity.Joueur;
import atos.magie.entity.Partie;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Administrateur
 */
public interface PartieDaoCrud extends CrudRepository<Partie, Long> {

    @Query("SELECT p FROM Partie p "
            + "EXCEPT "
            + "SELECT p FROM Partie p JOIN p.joueurs j "
            + "WHERE j.etat = atos.magie.entity.Joueur.EtatJoueur.gagné OR j.etat=atos.magie.entity.Joueur.EtatJoueur.aLamain")
    public List<Partie> listePartiesNonDemaree();

    //public Partie rechercherPartieParID(long idPartie);
    //public Joueur rechercherJoueurParID(long idJoueur);
    //public void ajouter(Partie p);
//    public long nbrJoueurPartie(long id);

    // 
//    public Boolean rechercheSiPlusDunJoueurDansUnePartie(long partieID);

    @Query("SELECT j FROM Joueur j JOIN j.partieNow p WHERE "
    
            + " p.id=?1 and j.ordre =?2")
    public Joueur retourneJoueurDordreParametreDansPartie(long idPartie, long ordre);

    //public List<Joueur> siTousLesAutreJoueurOntPerduDAOOOOOOOOOOOO(long idPartie);
    
    
    

    //public List<Carte> afficheMain(long idJoueur);
    
    //public List<Joueur> joueurPartieNonDemarer(long id);

}
