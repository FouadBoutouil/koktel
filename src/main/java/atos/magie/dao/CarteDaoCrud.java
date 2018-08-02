/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie.dao;

import atos.magie.entity.Carte;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Administrateur
 */
public interface CarteDaoCrud extends CrudRepository<Carte, Long>{
    @Query("SELECT c FROM Carte c Join c.joueurProprio j WHERE j.id =?1")
    public List<Carte> afficheMain(long idJoueur);
}
