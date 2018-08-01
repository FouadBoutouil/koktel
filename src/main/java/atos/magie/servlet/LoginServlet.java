/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie.servlet;

import atos.magie.entity.Joueur;
import atos.magie.service.JoueurService;
import atos.magie.spring.AutowireServlet;
import atos.magie.dao.JoueurDAO;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class LoginServlet extends AutowireServlet {
    // affiche la page de login 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("idPartie", req.getParameter("id"));
        req.getRequestDispatcher("login.jsp").forward(req, resp);   
    }
    
    // un do post pour prendre en compte le pseudo et avatar et quiu renvoie sur l'ecran de lister joueur de la partie

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // je dois recuperer les paramettre rentrer par le formulaire
        Joueur j = new Joueur();
        JoueurDAO daoJ = new JoueurDAO();
        JoueurService serviceJ = new JoueurService();
        String pseudo = (String) req.getParameter("pseudo");
        String avatar = (String) req.getParameter("avatar");
        //id de la partie en session 
        long idpartie = Long.parseLong(req.getSession().getAttribute("idPartie").toString());
        req.getSession().setAttribute("dolar", idpartie);
        req.getSession().setAttribute("PseudoSession", idpartie);
        serviceJ.rejoindrePartie(pseudo, avatar, idpartie);
//        // redirige vers la page qui affiche les joueurs dune pârtie en attente de dermarage

        resp.sendRedirect("JoueurPartieNonDem");
        
       
        
        
    }
}
