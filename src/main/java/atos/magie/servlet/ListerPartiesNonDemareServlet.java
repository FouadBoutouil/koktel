/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie.servlet;

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
@WebServlet(name = "ListerPartiesNonDemaré", urlPatterns = {"/listerParties"})
public class ListerPartiesNonDemareServlet extends HttpServlet {

    PartieService serviceP = new PartieService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("listePartie", serviceP.listePartiesNonDemaree());
        req.getRequestDispatcher("lister-parties.jsp").forward(req, resp);
    }

}
