/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie.dao;

import atos.magie.entity.Carte;
import atos.magie.entity.Joueur;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Administrateur
 */
public class CarteDAO{

//
//    @Override
//    public String toString() {
//        return "atos.magiemagie.dao.CarteDAO[ id=" + id + " ]";
//    }

    public void modifierCarte(Carte carte) {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.merge(carte);
        em.getTransaction().commit();
    }
    
     public void ajouterCarte(Carte cartem) {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.persist(cartem);
        em.getTransaction().commit();
    }
    public void supressionCarteJoueur(long idJoueur,long idCarteSupprime){
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query carte = em.createQuery("SELECT c FROM Carte c JOIN c.joueurProprio j "
                                   + "WHERE (c.id= :var) AND (j.id=c.joueurProprio)");
        carte.setParameter("var", idCarteSupprime);
        em.getTransaction().begin();
        em.remove(carte);
        em.getTransaction().commit();
        
    }
   public Carte renvoiCarte(long idCarte,long idJoueur){
     EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
     Query requ = em.createQuery("SELECT c FROM Carte c JOIN c.joueurProprio j WHERE (c.id=:var)AND (c.id=j.id)");
     requ.setParameter("var", idCarte);
    return (Carte) requ.getSingleResult();
    
   }
   
}
