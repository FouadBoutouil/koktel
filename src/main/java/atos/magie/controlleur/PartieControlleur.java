/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie.controlleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Administrateur
 */
@Controller
public class PartieControlleur {
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        
        return "lister-parties.jsp";
    }
}
