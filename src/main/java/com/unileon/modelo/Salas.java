/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author tlemar00
 */

@Entity
@Table(name="salas")

public class Salas implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sala;
    
    @JoinColumn(name="id_pelicula")
    @OneToOne(cascade=CascadeType.PERSIST)
    private Peliculas id_pelicula;

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public Peliculas getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(Peliculas id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id_sala;
        hash = 67 * hash + Objects.hashCode(this.id_pelicula);
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
        final Salas other = (Salas) obj;
        if (this.id_sala != other.id_sala) {
            return false;
        }
        if (!Objects.equals(this.id_pelicula, other.id_pelicula)) {
            return false;
        }
        return true;
    }
    
}
