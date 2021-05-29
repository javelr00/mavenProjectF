/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.UsuariosFacadeLocal;
import com.unileon.modelo.Usuarios;
import java.io.Serializable;
import java.util.List;
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

public class LoginController implements Serializable {
    
    @Inject
    private Usuarios usuario;
    
    @EJB
    private UsuariosFacadeLocal usuarioEJB;
    
    /*@PostConstruct Teniendo el inject, no es necesario tener esto parece ser
    void init(){
        categoria = new Categoria(); 
    }*/
  
    
    public Usuarios getUsuario() {
        return usuario;
    }
    
    public String login(){
        List<Usuarios> todos = usuarioEJB.findAll();
        System.out.println(usuario.getUser());
        for(int i=0; i<usuarioEJB.count(); i++){
            if(usuario.getUser().equals(todos.get(i).getUser())){
                System.out.println("Usuario encontrado");//TODO: mensaje error el usuario no esta en la bbdd
                String contrCorrect = todos.get(i).getPassword();
                if(usuario.getPassword().equals(contrCorrect)){
                    //Entra en el sistema
                    switch(todos.get(i).getIdRol().getIdRol()){
                        case 1:
                            return "/privado/profesor/principal.xhtml?faces-redirect=true";
                        case 2:
                            return "/privado/alumno/principal.xhtml?faces-redirect=true";
                        case 3:
                            return "/privado/administrador/principal.xhtml?faces-redirect=true";
                        
                    }
                }else{
                    //TODO:mensaje error
                    return null;
                }
            }else{
                System.out.println("Usuario no encontrado");//TODO: meter mensaje de error
            }
        }
        return null;
    }

    public UsuariosFacadeLocal getCategoriaEJB() {
        return usuarioEJB;
    }

    public void setCategoriaEJB(UsuariosFacadeLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }

    public void setCategoria(Usuarios usuario) {
        this.usuario = usuario;
    }
    
}
