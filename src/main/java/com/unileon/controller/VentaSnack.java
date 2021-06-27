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
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class VentaSnack implements Serializable{

	//acceso a los objetos
	private Snacks snack;

	//la interfaz, para acceder realmente al la BD y crear el usuario
	@EJB
	private SnacksFacadeLocal snackEJB;


	@PostConstruct
	void init(){
		snack = new Snacks();
	}

        public Snacks getSnack(){
            return this.snack;
        }
        
        public List<Snacks> listaSnacks(){
            return snackEJB.findAll();
        }
}