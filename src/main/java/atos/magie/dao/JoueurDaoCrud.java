/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie.dao;

import atos.magie.entity.Joueur;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Administrateur
 */
public interface JoueurDaoCrud extends CrudRepository<Joueur, Long> {

    @Query("SELECT Max(j.ordre) FROM Joueur j join j.partieNow p "
            + "WHERE p.id=?1 ")
    public long joueurOrdreMaxDansLaPartie(long idPartie);
    
    @Query("SELECT j FROM Joueur j JOIN j.partieNow p WHERE p.id=?2 and j.ordre=?1")
    public Joueur retourneJoueurDordreParametreDansPartie( long ordre, long idPartie);// @Param('nom_param')
    
    @Query("SELECT j FROM Joueur j JOIN j.partieNow p WHERE p.id=?1")
    public List<Joueur> joueurPartieNonDemarer(long id);
    
    @Query("SELECT j FROM Joueur j Join j.partieNow p WHERE j.etat=atos.magie.entity.Joueur.EtatJoueur.perdu and p.id=?1")
    public List<Joueur> siTousLesAutreJoueurOntPerduDAOOOOOOOOOOOO(long idPartie);

}
