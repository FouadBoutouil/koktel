/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie.servlet;

import atos.magie.entity.Joueur;
import atos.magie.entity.Partie;
import atos.magie.service.JoueurService;
import atos.magie.service.PartieService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrateur
 */
@WebServlet(name = "EcranFinal", urlPatterns = {"/EcranFinal"})
public class EcranPartieServlet extends HttpServlet {

    private JoueurService serviceJou = new JoueurService();
    private PartieService servicePar = new PartieService();

    // ici on doit avoir : 
    // la distribution de carte ------- affichage des joueurs et nbr de carte -----------affichage de la main du joueur ( session )
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long idPartieSess = (long) req.getSession().getAttribute("dolar");

        // une boucle pour distribuer les carte et les afficher
        // je recupere la partie actuelle avec son id
        Partie PartieAct = servicePar.rechercherPartieParID(idPartieSess);
        
// je recupere la liste des joueurs de cette partie 
        List<Joueur> joueurParAcct = PartieAct.getJoueurs();
        // je leur applique distribuer carte ( boucle )
        // distribustion de carte
        servicePar.demarrerPartie(idPartieSess);
        Joueur joueurAlaMain = serviceJou.rechercheJoueurQuiAlaMain(idPartieSess);
        // liste de tous les joueurs s&ans celui qui a la main
        PartieAct.getJoueurs().remove(joueurAlaMain.getId());
        // je dois avoir le nombre de carte
        req.getSession().setAttribute("MesJoueursDeLaPartie", joueurParAcct);
        req.getSession().setAttribute("LaPartieActuelSansJoueurAlaMain", PartieAct);
        req.getSession().setAttribute("JoueurAlaMain", joueurAlaMain);
        // jai besoin de la liste des carte des joueurs
        req.getRequestDispatcher("EcranPartie.jsp").forward(req, resp);
        //    au cas ou j'en aurrais besoin plus tard

    }

}
