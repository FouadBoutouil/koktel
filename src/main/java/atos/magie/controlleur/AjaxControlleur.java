/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie.controlleur;

import atos.magie.dto.JoueurQuiALaMain;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Administrateur
 */
@Controller
public class AjaxControlleur {
    @RequestMapping(value = "/ajax-quialamain", method = RequestMethod.GET)
    @ResponseBody
    public JoueurQuiALaMain determinerLesJoueursAlaMain(HttpSession session){
        // on va renvoyer l'id du joueur qui la main en ajax
        
        JoueurQuiALaMain dto = new JoueurQuiALaMain();
        dto.setIdJoueur(1L);
        dto.setMonJoueur("jecpascquoi");
        return dto;
    }
    
}
