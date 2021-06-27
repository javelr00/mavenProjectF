/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.CategoriaFacadeLocal;
import com.unileon.EJB.PeliculasFacadeLocal;
import com.unileon.modelo.Categoria;
import com.unileon.modelo.Peliculas;
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

public class PeliculaController implements Serializable {
    
    @Inject
    private Peliculas pelicula;
    
    @EJB
    private PeliculasFacadeLocal peliculaEJB;
    
    public void insertarPelicula(){
        peliculaEJB.create(pelicula);
    }
    
    public String registra(){
        try{
            peliculaEJB.create(pelicula);
        }catch(Exception e){
            
        } 
        return "/privado/administrador/datos_cambiados.xhtml?faces-redirect=true";
    }
    
    public void edita(){
        Peliculas aux = peliculaEJB.find(26);
        aux.setNombre(pelicula.getNombre());
        try{
            peliculaEJB.edit(aux);
        }catch(Exception e){
            
        } 
    }

    public Peliculas getPelicula() {
        return pelicula;
    }

    public void setPelicula(Peliculas pelicula) {
        this.pelicula = pelicula;
    }
    
    public PeliculasFacadeLocal getPeliculaEJB() {
        return peliculaEJB;
    }

    public void setPeliculaEJB(PeliculasFacadeLocal peliculaEJB) {
        this.peliculaEJB = peliculaEJB;
    }
    
    
}
