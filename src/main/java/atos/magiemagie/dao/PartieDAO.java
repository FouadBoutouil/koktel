/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie.dao;

import atos.magie.entity.Carte;
import atos.magie.entity.Joueur;
import atos.magie.entity.Partie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Administrateur
 */
public class PartieDAO {

    public List<Partie> listePartiesNonDemaree() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();

//    Query query = (Query) em.createQuery(""
//                + "SELECT p "
//                + "FROM Partie p "
//                + "EXCEPT "
//                + "SELECT p "
//                + "FROM Partie p "
//                + "     JOIN p.joueurs j "
//                + "WHERE j.EtatJoueur IN (:etat_gagne,:etat_alamain)");
//        query.setParameter("etat_gagne", Joueur.EtatJoueur.gagné);
//        query.setParameter("etat_alamain", Joueur.EtatJoueur.napaLaMain);
//        Query query = em.createQuery("SELECT P FROM Partie P JOIN P.joueurs j1"
//                + " EXCEPT "
//                + " SELECT P FROM Partie P JOIN P.joueurs j1 WHERE j1.etat=:etat1"
//                + "EXCEPT"
//                + " SELECT P FROM Partie P JOIN P.joueurs j2 WHERE j2.etat=:etat2" ); 
//        query.setParameter("etat1", Joueur.EtatJoueur.gagné);
//        query.setParameter("etat2", Joueur.EtatJoueur.aLamain);
        // mezme requete gagné
        Query query = em.createQuery("SELECT p FROM Partie p "
                + "                   EXCEPT "
                + "                   SELECT p1 FROM Partie p1 JOIN p1.joueurs j"
                + "                   WHERE j.etat=:etat_gagne OR j.etat=:etat_alamain");  //IN (:etat_gagne,:etat_alamain)");
        query.setParameter("etat_gagne", Joueur.EtatJoueur.gagné);
        query.setParameter("etat_alamain", Joueur.EtatJoueur.aLamain);

        return query.getResultList();

    }

    public Partie rechercherPartieParID(long idPartie) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.find(Partie.class, idPartie); // c'est comme une requete mais en plus simple 
    }

    /**
     *
     * @param idJoueur
     * @return
     */
    public Joueur rechercherJoueurParID(long idJoueur) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.find(Joueur.class, idJoueur); // c'est comme une requete mais en plus simple 
    }

    // cette fonction ne sert que pour persister ou merger les données tous le travail se fais dans le service (la suppression et la mise a jour
    // Son nom es trompeur
    public void ajouter(Partie p) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    public long nbrJoueurPartie(long id) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query query = em.createQuery("SELECT Count(j) "
                + "FROM Joueur j Join j.partiNow p "
                + "where p.partiNow=:idPartie");
        query.setParameter("idPartie", id);
        Object res = query.getSingleResult();
        return (long) res;
    }

    // on recupere tous les joueur de la partie puis on selectiuonne le max ( entity manager )
    public Boolean rechercheSiPlusDunJoueurDansUnePartie(long partieID) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query requet = em.createQuery(" select j1 from Joueur j1 join j1.partie p where p.id=:idPartie "
                + "                    except"
                + "                    select j2 from Joueur j2 join j2.partie p "
                + "                    where p.id=:idPartie and j2.etatjoueur=:etatPerdu");
        requet.setParameter("idPartie", partieID);
        requet.setParameter("etatPerdu", Joueur.EtatJoueur.perdu);

        return (Boolean) requet.getSingleResult();
    }

    //  renvoi le joueur de laq partie id qui a lordre ordre 
    public Joueur retourneJoueurDordreParametreDansPartie(long idPartie, long ordre) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query q = em.createQuery("SELECT j FROM Joueur j JOIN j.partieNow p WHERE p.id=:partieID and j.ordre =:param3 ");
        q.setParameter("partieID", idPartie);
        q.setParameter("param3", ordre);
        return (Joueur) q.getSingleResult();
    }

    public List<Joueur> siTousLesAutreJoueurOntPerduDAOOOOOOOOOOOO(long idPartie) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query requete = em.createQuery("SELECT j FROM Joueur j Join j.partieNow p WHER j.etat= :etat and p.id= :idPartie ");
        requete.setParameter("etat", Joueur.EtatJoueur.perdu);
        requete.setParameter("idPartie", idPartie);
        List<Joueur> list = requete.getResultList();
        return list;
    }

    public long joueurOrdreMaxDansLaPartie(long idPartie) {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query requete = em.createQuery("SELECT Max(j.ordre) FROM Joueur j join j.partie p"
                + "WHERE p.id=:id");
        requete.setParameter("id", idPartie);
        return (long) requete.getSingleResult();
    }

    public List<Carte> afficheMain(long idJoueur) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query requete1 = em.createQuery("SELECT c FROM Carte c Join c.joueurProprio j WHERE j.id = :variable");
        requete1.setParameter("variable", idJoueur);
        //Query requete2 = em.createQuery("SELECT COUNT(c) FROM Carte c Join c.joueurProprio j WHERE j.id = :variable1");
        // requete1.setParameter("variable1", idJoueur);
        List<Carte> carteJoueur = requete1.getResultList();
        //long nbrCarteJoueur = (long) requete2.getSingleResult();
        // c pas la peine de l'ecrire puis on peut l'obtenir en comptant le nombre d'element de la liste
        return carteJoueur;
    }
    // cette fonction affiche tous les jouerurs dans une partie ** amélioration ** inclure le joueur qui affiche
    //et l'afficher ( son pseudfo en bas par exemple 

    public List<Joueur> joueurPartieNonDemarer(long id) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query requet = em.createQuery("SELECT j FROM Joueur j JOIN j.partieNow p WHERE p.id=:var");
        requet.setParameter("var", id);
        List<Joueur> joueursTable = requet.getResultList();
        return joueursTable;
    }
}
