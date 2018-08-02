/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie.servlet;

import atos.magie.service.PartieService;
import atos.magie.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Administrateur
 * joueur table affiche une liste de tous les joueurs dazns table 
 */
@WebServlet(name = "partieNonDemarer", urlPatterns = {"/JoueurPartieNonDem"})
public class ListerJoueurPartieNonDemarerServlet extends AutowireServlet {
    
    @Autowired     
    PartieService serviceP;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // je dois recuperer l'id de la partiee
        // je le recupere ici car je l'es passer en param dans lurl donc je le recupere en methode GET
        
        
        Long id = Long.parseLong((String) req.getSession().getAttribute("idPartie"));
        req.setAttribute("joueursTable", serviceP.afficherPartieNonDemarer(id));
        req.getRequestDispatcher("EcranInscriptionJoueurSurPartieChoisi.jsp").forward(req, resp);    }
}
