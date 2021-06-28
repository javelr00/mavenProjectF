/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.ButacasFacadeLocal;
import com.unileon.EJB.SnacksFacadeLocal;
import com.unileon.modelo.Snacks;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class VentaSnack implements Serializable{
    
    //acceso a los objetos
    //HAY QUE INICIALIZAR LOS LIST EN EL INIT O DONDE SEA!!!!!!!!
    private Snacks snack;
    private List<Snacks> selectedSnacks;
    private List<Snacks> snacksTbl= new ArrayList<>();
    private String selectedSnack;
    
    
    @EJB
    private SnacksFacadeLocal snackEJB;
    
    @PostConstruct
    void init(){
        snack = new Snacks();
    }

    public String getSelectedSnack() {
        return selectedSnack;
    }

    public void setSelectedSnack(String selectedSnack) {
        this.selectedSnack = selectedSnack;
    }
        
    public List<Snacks> getSelectedSnacks() {
        return selectedSnacks;
    }

    public void setSelectedSnacks(List<Snacks> selectedSnacks) {
        this.selectedSnacks = selectedSnacks;
    }

    public SnacksFacadeLocal getSnackEJB() {
        return snackEJB;
    }

    public void setSnackEJB(SnacksFacadeLocal snackEJB) {
        this.snackEJB = snackEJB;
    }
        
    public Snacks getSnack(){
        return this.snack;
    }
        
    public List<Snacks> listaSnacks(){
        return snackEJB.findAll();
    }
        
        /*public List<Snacks> listaSnacksActual(){
            return selectedSnacks;
        }
        
        public void anadirCesta(){
            selectedSnacks.add(snack);
        }*/
        
    /*public void displaySnack() {
        String m = selectedSnack;
        FacesMessage msg;
        msg = new FacesMessage("Selected", m);

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }*/
    
    public void anadeALista(){
        Snacks snElegido;
        snElegido = snackEJB.find(Integer.parseInt(selectedSnack));
        snacksTbl.add(snElegido);
    }
    
    public List<Snacks> listaSnacksActual(){
            return snacksTbl;
    }
}