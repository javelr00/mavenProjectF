/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.CategoriaFacadeLocal;
import com.unileon.modelo.Categoria;
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

public class CategoriaController implements Serializable {
    
    @Inject
    private Categoria categoria;
    
    @EJB
    private CategoriaFacadeLocal categoriaEJB;
    
    /*@PostConstruct Teniendo el inject, no es necesario tener esto parece ser
    void init(){
        categoria = new Categoria(); 
    }*/
    
    public void insertarCategoria(){
        categoriaEJB.create(categoria);
    }
    
    public Categoria getCategoria() {
        return categoria;
    }
    
    public void registra(){
        try{
            categoriaEJB.create(categoria);
        }catch(Exception e){
            
        } 
    }
    
    public void edita(){
        Categoria aux = categoriaEJB.find(26);
        aux.setNombre(categoria.getNombre());
        try{
            categoriaEJB.edit(aux);
        }catch(Exception e){
            
        } 
    }
    
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Categoría registrada"));
    }

    public CategoriaFacadeLocal getCategoriaEJB() {
        return categoriaEJB;
    }

    public void setCategoriaEJB(CategoriaFacadeLocal categoriaEJB) {
        this.categoriaEJB = categoriaEJB;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
}
