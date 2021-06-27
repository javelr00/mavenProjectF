/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Peliculas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author javia_66o2ewb
 */
@Stateless
public class PeliculasFacade extends AbstractFacade<Peliculas> implements PeliculasFacadeLocal {

    @PersistenceContext(unitName = "mavenprojectFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeliculasFacade() {
        super(Peliculas.class);
    }
    
}
