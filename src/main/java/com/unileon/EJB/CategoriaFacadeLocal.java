/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Categoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author javia_66o2ewb
 */
@Local
public interface CategoriaFacadeLocal {

    void create(Categoria categoria);

    void edit(Categoria categoria);

    void remove(Categoria categoria);

    Categoria find(Object id);

    List<Categoria> findAll();

    List<Categoria> findRange(int[] range);

    int count();
    
}
