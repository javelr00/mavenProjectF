/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author tlemar00
 */

@Entity
@Table(name="snacks")

public class Snacks {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idsnacks;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="precio")
    private float precio;
    
    @Column(name="cantidad_disp")
    private int cantidad_disp;
    
    @Column(name="tam")
    private String tam;

    public int getCantidad_disp() {
        return cantidad_disp;
    }

    public void setCantidad_disp(int cantidad_disp) {
        this.cantidad_disp = cantidad_disp;
    }

    public int getIdsnacks() {
        return idsnacks;
    }

    public void setIdsnacks(int idsnacks) {
        this.idsnacks = idsnacks;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTam() {
        return tam;
    }

    public void setTam(String tam) {
        this.tam = tam;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.idsnacks;
        hash = 23 * hash + Objects.hashCode(this.nombre);
        hash = 23 * hash + Float.floatToIntBits(this.precio);
        hash = 23 * hash + this.cantidad_disp;
        hash = 23 * hash + Objects.hashCode(this.tam);
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
        final Snacks other = (Snacks) obj;
        if (this.idsnacks != other.idsnacks) {
            return false;
        }
        if (Float.floatToIntBits(this.precio) != Float.floatToIntBits(other.precio)) {
            return false;
        }
        if (this.cantidad_disp != other.cantidad_disp) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.tam, other.tam)) {
            return false;
        }
        return true;
    }

}
