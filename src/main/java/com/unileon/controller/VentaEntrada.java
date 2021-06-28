/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import static com.sun.javafx.logging.PulseLogger.addMessage;
import com.unileon.EJB.ButacasFacadeLocal;
import com.unileon.modelo.Butacas;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class VentaEntrada implements Serializable{

	//acceso a los objetos
	private Butacas butaca;
        private List<Butacas> selectedButacas;
        private String fila;

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public List<Butacas> getSelectedButacas() {
        return selectedButacas;
    }

    public void setSelectedButacas(List<Butacas> selectedButacas) {
        this.selectedButacas = selectedButacas;
    }

    public ButacasFacadeLocal getButacaEJB() {
        return butacaEJB;
    }

    public void setButacaEJB(ButacasFacadeLocal butacaEJB) {
        this.butacaEJB = butacaEJB;
    }

	//la interfaz, para acceder realmente al la BD y crear el usuario
	@EJB
	private ButacasFacadeLocal butacaEJB;


	@PostConstruct
	void init(){
		butaca = new Butacas();
	}

        public Butacas getButaca(){
            return this.butaca;
        }
        
	public void registrarVenta(){
		//necesito el id del tipo de rol
		//En persona creo una Persona, pero en rol no creo un Rol
		try{
			//este buscar necesita modificar la interfaz del EJB
			butaca.setAsiento(butaca.getAsiento());
                        butaca.setFila(butaca.getFila());
                        
			butacaEJB.create(butaca);
		}catch(Exception e){
			System.out.println("Error al registrar la butaca" + e.getMessage());
		}
	}
        
        public List<Butacas> listaButacas(){
            return butacaEJB.findAll();
        }
        public List<Butacas> listaButacasActual(){
            return selectedButacas;
        }
        
        public void handleKeyEvent() {
            fila="1";
        }
        
        public void verElegidos() {
            addMessage("HOLA");
            System.out.println("1123");
        }
        
        public void addMessage(String summary) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
    }
        
        public void info() throws Exception{
            String salida = "Has seleccionado las butacas: ";
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Has pulsado info "+selectedButacas));
    }
        
        
}