/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.RolesFacadeLocal;
import com.unileon.EJB.UsuariosFacadeLocal;
import com.unileon.modelo.Personas;
import com.unileon.modelo.Roles;
import com.unileon.modelo.Usuarios;
import java.io.Serializable;
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

	//la interfaz, para acceder realmente al la BD y crear el usuario
	@EJB
	private UsuariosFacadeLocal usuarioEJB;

	//para acceder a la BD y crear el usuario
	@EJB
	private RolesFacadeLocal rolEJB;

	@PostConstruct
	void init(){
		rol = new Roles();
		usuario = new Usuarios();
		persona = new Personas();
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
}