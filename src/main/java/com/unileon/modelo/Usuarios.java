/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tlemar00
 */

@Entity
@Table(name="usuarios")

public class Usuarios implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    
    @Column(name="User")
    private String user;
    
    @Column(name="Password")
    private String password;
    
    @Column(name="UltimaConexion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaConexion;
    
    @Column(name="Estado")
    private boolean activada;
    
    @JoinColumn(name="IdPersona")
    @OneToOne(cascade=CascadeType.PERSIST)
    private Personas idPersona;
     
    @JoinColumn(name="IdRol")
    @ManyToOne
    private Roles idRol;
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getUltimaConexion() {
        return ultimaConexion;
    }

    public void setUltimaConexion(Date ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }

    public boolean isActivada() {
        return activada;
    }

    public void setActivada(boolean activada) {
        this.activada = activada;
    }

    public Personas getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Personas idPersona) {
        this.idPersona = idPersona;
    }

    public Roles getIdRol() {
        return idRol;
    }

    public void setIdRol(Roles idRol) {
        this.idRol = idRol;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.idUsuario;
        hash = 73 * hash + Objects.hashCode(this.user);
        hash = 73 * hash + Objects.hashCode(this.password);
        hash = 73 * hash + Objects.hashCode(this.ultimaConexion);
        hash = 73 * hash + (this.activada ? 1 : 0);
        hash = 73 * hash + Objects.hashCode(this.idPersona);
        hash = 73 * hash + Objects.hashCode(this.idRol);
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
        final Usuarios other = (Usuarios) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.activada != other.activada) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.ultimaConexion, other.ultimaConexion)) {
            return false;
        }
        if (!Objects.equals(this.idPersona, other.idPersona)) {
            return false;
        }
        if (!Objects.equals(this.idRol, other.idRol)) {
            return false;
        }
        return true;
    }
    
     
}
