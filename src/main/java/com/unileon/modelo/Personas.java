/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.modelo;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tlemar00
 */

@Entity
@Table(name="personas")

public class Personas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersona;
    
    @Column(name="Nombre")
    private String nombrePersona;
    
    @Column(name="Apellido1")
    private String apellido1;
    
    @Column(name="Apellido2")
    private String apellido2;
    
    @Column(name="Sexo")
    private char sexo;
    
    @Column(name="FechaNacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombrePersona;
    }

    public void setNombre(String nombre) {
        this.nombrePersona = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idPersona;
        hash = 17 * hash + Objects.hashCode(this.nombrePersona);
        hash = 17 * hash + Objects.hashCode(this.apellido1);
        hash = 17 * hash + Objects.hashCode(this.apellido2);
        hash = 17 * hash + this.sexo;
        hash = 17 * hash + Objects.hashCode(this.fechaNacimiento);
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
        final Personas other = (Personas) obj;
        if (this.idPersona != other.idPersona) {
            return false;
        }
        if (this.sexo != other.sexo) {
            return false;
        }
        if (!Objects.equals(this.nombrePersona, other.nombrePersona)) {
            return false;
        }
        if (!Objects.equals(this.apellido1, other.apellido1)) {
            return false;
        }
        if (!Objects.equals(this.apellido2, other.apellido2)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        return true;
    }
    
    
}
