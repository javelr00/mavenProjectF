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
@Table(name="tipos_tickets")

public class Tipos_tickets {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtickets;
    
    @Column(name="descuento")
    private int descuento;
    
    @Column(name="tipo_entrada")
    private String tipo_entrada;

    public int getIdtickets() {
        return idtickets;
    }

    public void setIdtickets(int idtickets) {
        this.idtickets = idtickets;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getTipo_entrada() {
        return tipo_entrada;
    }

    public void setTipo_entrada(String tipo_entrada) {
        this.tipo_entrada = tipo_entrada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idtickets;
        hash = 17 * hash + this.descuento;
        hash = 17 * hash + Objects.hashCode(this.tipo_entrada);
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
        final Tipos_tickets other = (Tipos_tickets) obj;
        if (this.idtickets != other.idtickets) {
            return false;
        }
        if (this.descuento != other.descuento) {
            return false;
        }
        if (!Objects.equals(this.tipo_entrada, other.tipo_entrada)) {
            return false;
        }
        return true;
    }
    
    
    
}
