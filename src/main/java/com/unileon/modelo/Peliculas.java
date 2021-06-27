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
@Table(name="peliculas")

public class Peliculas implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pelicula;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="duracion_min")
    private int duracion_min;
    
    @Column(name="director")
    private String director;

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion_min() {
        return duracion_min;
    }

    public void setDuracion_min(int duracion_min) {
        this.duracion_min = duracion_min;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id_pelicula;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + this.duracion_min;
        hash = 89 * hash + Objects.hashCode(this.director);
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
        final Peliculas other = (Peliculas) obj;
        if (this.id_pelicula != other.id_pelicula) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (this.duracion_min != other.duracion_min) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        return true;
    }
    
     
}
