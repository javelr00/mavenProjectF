/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.PeliculasFacadeLocal;
import com.unileon.EJB.RolesFacadeLocal;
import com.unileon.EJB.SnacksFacadeLocal;
import com.unileon.EJB.UsuariosFacadeLocal;
import com.unileon.modelo.Peliculas;
import com.unileon.modelo.Personas;
import com.unileon.modelo.Roles;
import com.unileon.modelo.Snacks;
import com.unileon.modelo.Usuarios;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author tlemar00
 */
@Named
@ViewScoped
public class AdministradorController implements Serializable{
    
    	//acceso a los objetos
	private Roles rol;
	private Usuarios usuario;
	private Personas persona;
        private Snacks snack;
        @Inject
        transient private Snacks chsnack;
        private Peliculas pelicula;
        @Inject
        private Peliculas chpelicula;
        private String selectedUsuario;
        private int selectedSnack;
        private int selectedPelicula;
        
	@EJB
	private UsuariosFacadeLocal usuarioEJB;
        
        @EJB
	private SnacksFacadeLocal snackEJB;

	@EJB
	private RolesFacadeLocal rolEJB;
        
        @EJB
	private PeliculasFacadeLocal peliculaEJB;
        
        @PostConstruct
	void init(){
		rol = new Roles();
		usuario = new Usuarios();
		persona = new Personas();
                snack = new Snacks();
                pelicula = new Peliculas();
                
	}

    public Peliculas getChpelicula() {
        return chpelicula;
    }

    public void setChpelicula(Peliculas chpelicula) {
        this.chpelicula = chpelicula;
    }

    public Snacks getChsnack() {
        return chsnack;
    }

    public void setChsnack(Snacks chsnack) {
        this.chsnack = chsnack;
    }
        
    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public void setPersona(Personas persona) {
        this.persona = persona;
    }
    
    public void setSnack(Snacks snack) {
        this.snack = snack;
    }
    
    public void setPelicula(Peliculas pelicula) {
        this.pelicula = pelicula;
    }

    public Roles getRol() {
        return rol;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public Personas getPersona() {
        return persona;
    }

    public Snacks getSnack() {
        return snack;
    }

    public Peliculas getPelicula() {
        return pelicula;
    }
    
    public String getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(String selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }
    
    public int getSelectedSnack() {
        return selectedSnack;
    }

    public void setSelectedSnack(int selectedSnack) {
        this.selectedSnack = selectedSnack;
    }

    public int getSelectedPelicula() {
        return selectedPelicula;
    }

    public void setSelectedPelicula(int selectedPelicula) {
        this.selectedPelicula = selectedPelicula;
    }
    
    public UsuariosFacadeLocal getUsuarioEJB() {
        return usuarioEJB;
    }
    
    public void setUsuarioEJB(UsuariosFacadeLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }
    
    public SnacksFacadeLocal getSnackEJB() {
        return snackEJB;
    }

    public void setSnackEJB(SnacksFacadeLocal snackEJB) {
        this.snackEJB = snackEJB;
    }
    
    public RolesFacadeLocal getRolEJB() {
        return rolEJB;
    }

    public void setRolEJB(RolesFacadeLocal rolEJB) {
        this.rolEJB = rolEJB;
    }

    public PeliculasFacadeLocal getPeliculaEJB() {
        return peliculaEJB;
    }

    public void setPeliculaEJB(PeliculasFacadeLocal peliculaEJB) {
        this.peliculaEJB = peliculaEJB;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.rol);
        hash = 83 * hash + Objects.hashCode(this.usuario);
        hash = 83 * hash + Objects.hashCode(this.persona);
        hash = 83 * hash + Objects.hashCode(this.snack);
        hash = 83 * hash + Objects.hashCode(this.pelicula);
        hash = 83 * hash + Objects.hashCode(this.selectedUsuario);
        hash = 83 * hash + Objects.hashCode(this.selectedSnack);
        hash = 83 * hash + Objects.hashCode(this.selectedPelicula);
        hash = 83 * hash + Objects.hashCode(this.usuarioEJB);
        hash = 83 * hash + Objects.hashCode(this.snackEJB);
        hash = 83 * hash + Objects.hashCode(this.rolEJB);
        hash = 83 * hash + Objects.hashCode(this.peliculaEJB);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AdministradorController other = (AdministradorController) obj;
        if (!Objects.equals(this.selectedUsuario, other.selectedUsuario)) {
            return false;
        }
        if (!Objects.equals(this.selectedSnack, other.selectedSnack)) {
            return false;
        }
        if (!Objects.equals(this.selectedPelicula, other.selectedPelicula)) {
            return false;
        }
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.persona, other.persona)) {
            return false;
        }
        if (!Objects.equals(this.snack, other.snack)) {
            return false;
        }
        if (!Objects.equals(this.pelicula, other.pelicula)) {
            return false;
        }
        if (!Objects.equals(this.usuarioEJB, other.usuarioEJB)) {
            return false;
        }
        if (!Objects.equals(this.snackEJB, other.snackEJB)) {
            return false;
        }
        if (!Objects.equals(this.rolEJB, other.rolEJB)) {
            return false;
        }
        if (!Objects.equals(this.peliculaEJB, other.peliculaEJB)) {
            return false;
        }
        return true;
    }
    
    public void registrarUsuario(){

        //necesito el id del tipo de rol
        //En persona creo una Persona, pero en rol no creo un Rol
        try{
            //este buscar necesita modificar la interfaz del EJB
            rol = rolEJB.buscarRolPorTipoUsuario(rol.getTipoUsuario());
            usuario.setIdRol(rol);
            usuario.setIdPersona(persona);
            //el create nos sigue valiendo, no hay que extender esta interfaz
            usuarioEJB.create(usuario);//Crea el usuaio en la bbdd con todo correcto
	}catch(Exception e){
            System.out.println("Error al registrar el usuario" + e.getMessage());
        }
    }
        
    public List<Usuarios> listaUsuarios(){
        return usuarioEJB.findAll();
    }
        
    public List<Snacks> listaSnacks(){
        return snackEJB.findAll();
    }
    
    public List<Peliculas> listaPeliculas(){
        return peliculaEJB.findAll();
    }
        
    public String usuarioActual(){
        return selectedUsuario;
    }
    
    public int snackActual(){
        return selectedSnack;
    }
    
    public int peliculaActual(){
        return selectedPelicula;
    }
    
    public Peliculas buscaPeliculas(){
        pelicula=peliculaEJB.find(selectedPelicula);
        return peliculaEJB.find(selectedPelicula);
    }
    
    public Snacks buscaSnack(){
        snack=snackEJB.find(selectedSnack);
        return snackEJB.find(selectedSnack);
    }
    
    public void editaPelicula(){
        try{
            Peliculas aux = peliculaEJB.find(2);//No se si funcionará
            aux.setNombre(chpelicula.getNombre());
            peliculaEJB.edit(aux);
	}catch(Exception e){
            System.out.println("Error al editar la película" + e.getMessage());
	}
    }
    
    public String editachPelicula(){
        Peliculas aux = peliculaEJB.find(selectedPelicula);
        aux.setNombre(chpelicula.getNombre());
        aux.setDuracion_min(chpelicula.getDuracion_min());
        try{
            peliculaEJB.edit(aux);
        }catch(Exception e){
            
        } 
        return "/privado/administrador/datos_cambiados.xhtml?faces-redirect=true";
    }
    
    public String editachSnack(){
        Snacks aux = snackEJB.find(selectedSnack);
        aux.setNombre(chsnack.getNombre());
        aux.setPrecio(chsnack.getPrecio());
        try{
            snackEJB.edit(aux);
        }catch(Exception e){
            
        } 
        return "/privado/administrador/datos_cambiados.xhtml?faces-redirect=true";
    }
    /*public void displayUsuario() {
        FacesMessage msg;
        msg = new FacesMessage("Selected ", selectedUsuario);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }*/
    
}
    
    
        
    
