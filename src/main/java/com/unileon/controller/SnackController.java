/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.CategoriaFacadeLocal;
import com.unileon.EJB.PeliculasFacadeLocal;
import com.unileon.EJB.SnacksFacadeLocal;
import com.unileon.modelo.Categoria;
import com.unileon.modelo.Peliculas;
import com.unileon.modelo.Snacks;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.*;
import javax.faces.view.*;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author javia_66o2ewb
 */
@Named
@ViewScoped

public class SnackController implements Serializable {
    
    @Inject
    transient private Snacks snack;
    
    @EJB
    private SnacksFacadeLocal snackEJB;
    
    public void insertarSnack(){
        snackEJB.create(snack);
    }
    
    public String registra(){
        try{
            snackEJB.create(snack);
        }catch(Exception e){
            
        } 
        return "/privado/administrador/datos_cambiados.xhtml?faces-redirect=true";
    }
    
    /*public void edita(){
        Snacks aux = snackEJB.find(26);
        aux.setNombre(snack.getNombre());
        try{
            snackEJB.edit(aux);
        }catch(Exception e){
            
        } 
    }*/

    public Snacks getSnack() {
        return snack;
    }

    public void setSnack(Snacks snack) {
        this.snack = snack;
    }
    
    public SnacksFacadeLocal getSnackEJB() {//BORRAR?
        return snackEJB;
    }

    public void setSnackEJB(SnacksFacadeLocal snackEJB) {
        this.snackEJB = snackEJB;
    }

    
}
