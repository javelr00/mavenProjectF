/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.RolesFacadeLocal;
import com.unileon.modelo.Roles;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

/**
 *
 * @author javia_66o2ewb
 */
@Named
@ViewScoped

public class RolesController implements Serializable{
    
    private List<Roles> listaDeRoles;
    private char accion;
    
    @EJB
    private RolesFacadeLocal rolEJB;
    
    @PostConstruct
    public void init() {
        listaDeRoles = rolEJB.findAll();
    }
    
    public List<Roles> getListaDeRoles() {
        return listaDeRoles;
    }

    public char getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = 'R';
        int a=0;
        a++;
        System.out.println(accion+a);
    }
    
    public void insertarRol(){
        if("R".equals(this.accion)){
            System.out.println("es r");
        }else if("M".equals(this.accion)){
            //Modifica rol
        }else if("E".equals(this.accion)){
            //Elimina rol
        }
    }
}
