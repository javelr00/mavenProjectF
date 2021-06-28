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
@Table(name="butacas")

public class Butacas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idbutacas;
    
    @Column(name="fila")
    private int fila;
    
    @Column(name="asiento")
    private int asiento;
    
    @JoinColumn(name="id_sala")
    @OneToOne(cascade=CascadeType.PERSIST)
    private Salas id_sala;
    
    @Column(name="ocupado")
    private boolean ocupado;

    public Salas getId_sala() {
        return id_sala;
    }

    public void setId_sala(Salas id_sala) {
        this.id_sala = id_sala;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    public int getIdbutacas() {
        return idbutacas;
    }

    public void setIdbutacas(int idbutacas) {
        this.idbutacas = idbutacas;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idbutacas;
        hash = 41 * hash + this.fila;
        hash = 41 * hash + this.asiento;
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
        final Butacas other = (Butacas) obj;
        if (this.idbutacas != other.idbutacas) {
            return false;
        }
        if (this.fila != other.fila) {
            return false;
        }
        if (this.asiento != other.asiento) {
            return false;
        }
        return true;
    }
    
    
    
}
