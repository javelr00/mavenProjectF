/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.MenuFacadeLocal;
import com.unileon.modelo.Menus;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author javia_66o2ewb
 */
@Named
@SessionScoped

public class MenuController implements Serializable{
    @Inject
    private Menus menu;
    
    @EJB
    private MenuFacadeLocal menuEJB;
    
    //Atributo del controlador que se cargará en el int
    private MenuModel modelo;
    
    public Menus getMenu() {
        return menu;
    }
    
    public MenuFacadeLocal getCategoriaEJB() {
        return menuEJB;
    }

    public void setCategoriaEJB(MenuFacadeLocal menuEJB) {
        this.menuEJB = menuEJB;
    }

    public void setCategoria(Menus menu) {
        this.menu = menu;
    }

    public MenuModel getModelo() {
        return modelo;
    }

    public void setModelo(MenuModel modelo) {
        this.modelo = modelo;
    }
    
    public MenuModel obtenerMenu(){
        DefaultSubMenu subMenu = null;
        if(menu.getTipoMenu()=='S'){
            //Es un submenu que no tiene padre, pero si hijos
            subMenu = DefaultSubMenu.builder().label(menu.getNombreMenu()).build();
        }else if(menu.getTipoMenu()=='I'){
            DefaultMenuItem item = DefaultMenuItem.builder().value(menu.getNombreMenu()).url(menu.getUrl()).build();
            item.setUrl(menu.getUrl());//TODO: Comprobar
            /*if(menu.getIdMenu_Menu()!=0){ //TODO:comprobar, debería ser null
                if(subMenu.getParent().equals(item)){//TODOno me convence nada
                    subMenu.getElements().add(item);
                }
                
            }*/
            //Es un item, que puede pertenecer a un submenu(buscar padre a traves de foreign key)
            //O bien no tiene padre y aparece directamente como elemento del menumodel
        }
        return null;
    }
    
    public void cerrarSesion(){//TODO: compleatar
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}
