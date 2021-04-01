/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author javia_66o2ewb
 */

@Entity
@Table (name="categorias")

//Serializable convierte datos en bits para poder comunicarse con la bbdd
public class Categoria implements Serializable{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private int idCategoria;
    
    @Column (name="Nombre")
    private String Nombre;
    
    @Column (name="Estado")
    private boolean Estado;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idCategoria;
        hash = 97 * hash + Objects.hashCode(this.Nombre);
        hash = 97 * hash + (this.Estado ? 1 : 0);
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
        final Categoria other = (Categoria) obj;
        if (this.idCategoria != other.idCategoria) {
            return false;
        }
        if (this.Estado != other.Estado) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        return true;
    }
    
    
}
