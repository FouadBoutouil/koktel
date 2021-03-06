/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie.service;

import atos.magie.entity.Carte;
import atos.magie.entity.Joueur;
import atos.magie.entity.Partie;
import atos.magie.dao.CarteDAO;
import atos.magie.dao.JoueurDAO;
import atos.magie.dao.PartieDAO;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrateur
 */
@Transactional
@Service
public class JoueurService {
    
    private JoueurDAO dao = new JoueurDAO();
    private PartieDAO daoPartie = new PartieDAO();
    Joueur joueurpass = new Joueur();

    public void distribuerCarte(long idJoueur, long nbrCarte) {

        Joueur joueurActuel = dao.rechercheJoueurParID(idJoueur); /// §§§§§§§§§§§§§§§§§

        CarteDAO daoCarte = new CarteDAO();

        //on rajoute la carte generée a chaque fois
        for (int i = 0; i < nbrCarte; i++) {
            // boucle pour ordre joueur +
            Random r = new Random();
            int numeroCarte = r.nextInt(5);
            Carte carteActuelle = new Carte();

            switch (numeroCarte) {
                case 0:
                    carteActuelle.setIngredient(Carte.Ingredient.CRAPAUD);
                    break;

                case 1:
                    carteActuelle.setIngredient(Carte.Ingredient.CHAUVESOURIS);
                    break;

                case 2:
                    carteActuelle.setIngredient(Carte.Ingredient.LICORNE);
                    break;

                case 3:
                    carteActuelle.setIngredient(Carte.Ingredient.LAPISLAZULI);
                    break;

                case 4:
                    carteActuelle.setIngredient(Carte.Ingredient.MANDRAGORE);
                    break;
                default:
                    throw new RuntimeException("Invalid grade");
            }
            // on ajoute la carte genereé aléatoirement dans une liste qu'on affectera a la fin a joueur, cette list
            // represente sa main
            carteActuelle.setJoueurProprio(joueurActuel);
            List<Carte> cartes = joueurActuel.getCartes();
            cartes.add(carteActuelle);
            daoCarte.ajouterCarte(carteActuelle);
            //joueurActuel.setCarte(cartes);
        }

        dao.modifier(joueurActuel);

        //daoCarte.modifierCarte(carteActuelle);
    }

    // on affecte la liste finale generé aux joueurs
    /**
     *
     * @param pseudo
     * @param avatar
     * @param idPartie
     * @return vette fonction creer un nouvel utilisateur et l'affecte a une
     * partie exsistante
     */
    public Joueur rejoindrePartie(String pseudo, String avatar, long idPartie) {
        // recherche si le joueur exsiste deja 
        Joueur joueur = dao.rechercherParPseudo(pseudo);
        if (joueur == null) {
            // le joueur n'exsiste pas encore
            joueur = new Joueur();
            joueur.setPseudo(pseudo);
            joueur.setNbrPartieGagne(0l);
            joueur.setNbrPartieJouee(0l);
        }
        joueur.setAvatar(avatar);
        joueur.setEtat(Joueur.EtatJoueur.napaLaMain);
        long ordre = dao.ordrerechercheOrdreNouveauJoueur(idPartie);
        joueur.setOrdre(ordre);

        Partie partie = daoPartie.rechercherPartieParID(idPartie);
        joueur.setPartieNow(partie);  // renvoi la partie actuelle
        List<Joueur> listeJoueurs = partie.getJoueurs();
        listeJoueurs.add(joueur);

        if (joueur.getId() == null) {
            dao.ajouter(joueur);
        } else {
            dao.modifier(joueur);
        }
        return joueur;
    }

    public void ajouterJoueur(String pseudo, String avatar) {
        Joueur joueur = new Joueur();
        joueur.setPseudo(pseudo);
        joueur.setAvatar(avatar);
        dao.ajouter(joueur);
    }

    /**
     * renvoie juste le nombre de carte, pour le joueur qui a la main je vais
     * utiliser du polymorphisme !!!
     *
     * @param idJoueur
     * @return
     */
    public long afficheCarte(long idJoueur) {
        Joueur joueurBeta = dao.rechercheJoueurParID(idJoueur);
        return (long) joueurBeta.getCartes().size();
    }

    public Joueur rechercheJoueurParID(long idJoueur) {
        return dao.rechercheJoueurParID(idJoueur);
    }

    public Joueur rechercheJoueurQuiAlaMain(long idPartie) {
        return dao.rechercheJoueurQuiAlaMain(idPartie);
    }

}
