/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie.controlleur;

import atos.magie.service.PartieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Administrateur
 */
@Controller
public class PartieControlleur {
    
    @Autowired
    private PartieService service;
    
    @RequestMapping(value = "/listerParties", method = RequestMethod.GET)
    public String lister( Model model) {
        // on charge nos partie avec l'autoweirer
        model.addAttribute("listePartie", service.listePartiesNonDemaree());
        return "lister-parties.jsp";
    }
}
