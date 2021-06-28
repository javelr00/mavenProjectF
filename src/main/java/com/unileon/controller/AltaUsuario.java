/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.PersonasFacadeLocal;
import com.unileon.EJB.RolesFacadeLocal;
import com.unileon.EJB.UsuariosFacadeLocal;
import com.unileon.modelo.Personas;
import com.unileon.modelo.Roles;
import com.unileon.modelo.Usuarios;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AltaUsuario implements Serializable{

	//acceso a los objetos
	private Roles rol;
	private Usuarios usuario;
	private Personas persona;
        private int roln;

	//la interfaz, para acceder realmente al la BD y crear el usuario
	@EJB
	private UsuariosFacadeLocal usuarioEJB;
        
        @EJB
	private PersonasFacadeLocal personaEJB;

	//para acceder a la BD y crear el usuario
	@EJB
	private RolesFacadeLocal rolEJB;

	@PostConstruct
	void init(){
		rol = new Roles();
		usuario = new Usuarios();
		persona = new Personas();
	}

        public UsuariosFacadeLocal getUsuarioEJB() {
            return usuarioEJB;
        }

        public void setUsuarioEJB(UsuariosFacadeLocal usuarioEJB) {
            this.usuarioEJB = usuarioEJB;
        }

        public PersonasFacadeLocal getPersonaEJB() {
            return personaEJB;
        }

        public void setPersonaEJB(PersonasFacadeLocal personaEJB) {
            this.personaEJB = personaEJB;
        }

        public RolesFacadeLocal getRolEJB() {
            return rolEJB;
        }

        public void setRolEJB(RolesFacadeLocal rolEJB) {
            this.rolEJB = rolEJB;
        }

        public int getRoln() {
            return roln;
        }

        public void setRoln(int roln) {
            this.roln = roln;
        }
        
        public Personas getPersona(){
            return this.persona;
        }
        
        public Roles getRol (){
            return this.rol;
        }
        
        public Usuarios getUsuario(){
            return this.usuario;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.rol);
        hash = 17 * hash + Objects.hashCode(this.usuario);
        hash = 17 * hash + Objects.hashCode(this.persona);
        hash = 17 * hash + Objects.hashCode(this.usuarioEJB);
        hash = 17 * hash + Objects.hashCode(this.personaEJB);
        hash = 17 * hash + Objects.hashCode(this.rolEJB);
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
        final AltaUsuario other = (AltaUsuario) obj;
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.persona, other.persona)) {
            return false;
        }
        if (!Objects.equals(this.usuarioEJB, other.usuarioEJB)) {
            return false;
        }
        if (!Objects.equals(this.personaEJB, other.personaEJB)) {
            return false;
        }
        if (!Objects.equals(this.rolEJB, other.rolEJB)) {
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
        
        public void insertarUsuario(){
            personaEJB.create(persona);
            usuario.setIdPersona(persona);
            rol = rolEJB.buscarRolPorTipoUsuario(rol.getTipoUsuario());//dudo
            Roles role = rolEJB.find(roln);
            usuario.setIdRol(role);
            usuarioEJB.create(usuario);
        }
}