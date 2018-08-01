/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie.servlet;

import atos.magie.entity.Partie;
import atos.magie.service.PartieService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrateur
 */
@WebServlet(name = "CrerNouvellePartie", urlPatterns = {"/CrerNouvellePartie"})
public class CrerNouvellePartie extends HttpServlet {
    
    PartieService servicep = new PartieService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // affiche vers le formulaire dajout
        req.getRequestDispatcher("CreerNouvelleParti.jsp").forward(req, resp);
        
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // recuperer le nom de la partie a ajouter par le formulaire
        Partie  p = new Partie();
        String nomP = req.getParameter("nomPartie");
       // String nomP = (String) req.getAttribute("nomPartie");
        p.setNom(nomP);
        servicep.creerNouvellePartie(nomP);
        resp.sendRedirect("listerParties");
        
        
       // resp.sendRedirect("");
        // faire une redirect vers la (page) servlet qu'on veut afficher apres quil click sur creer la partie 
        // cette servelet c'est l'ecran qui affiche les joueur d'une partie non démarer
    }
}
