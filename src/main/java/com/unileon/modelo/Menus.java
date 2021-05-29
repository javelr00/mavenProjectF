/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.modelo;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author tlemar00
 */

@Entity
@Table(name="menus")

public class Menus {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMenu;
    
    @Column(name="Nombre")
    private String nombreMenu;
    
    @Column(name="Tipo")
    private char tipoMenu;
    
    @Column(name="Estado")
    private boolean estadoMenu;
    
    @JoinColumn(name="IdRol")
    @ManyToOne
    private Roles idRol;
    
    @JoinColumn(name="IdMenu_Menu")
    @ManyToOne
    private int idMenu_Menu;
    
    @Column(name="url")
    private String url;

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    public char getTipoMenu() {
        return tipoMenu;
    }

    public void setTipoMenu(char tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

    public boolean isEstadoMenu() {
        return estadoMenu;
    }

    public void setEstadoMenu(boolean estadoMenu) {
        this.estadoMenu = estadoMenu;
    }

    public Roles getIdRol() {
        return idRol;
    }

    public void setIdRol(Roles idRol) {
        this.idRol = idRol;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idMenu;
        hash = 97 * hash + Objects.hashCode(this.nombreMenu);
        hash = 97 * hash + this.tipoMenu;
        hash = 97 * hash + (this.estadoMenu ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.idRol);
        hash = 97 * hash + Objects.hashCode(this.url);
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
        final Menus other = (Menus) obj;
        if (this.idMenu != other.idMenu) {
            return false;
        }
        if (this.tipoMenu != other.tipoMenu) {
            return false;
        }
        if (this.estadoMenu != other.estadoMenu) {
            return false;
        }
        if (!Objects.equals(this.nombreMenu, other.nombreMenu)) {
            return false;
        }
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        if (!Objects.equals(this.idRol, other.idRol)) {
            return false;
        }
        return true;
    }

   
}