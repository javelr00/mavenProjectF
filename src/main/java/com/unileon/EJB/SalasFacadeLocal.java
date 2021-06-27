/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Salas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author javia_66o2ewb
 */
@Local
public interface SalasFacadeLocal {

    void create(Salas salas);

    void edit(Salas salas);

    void remove(Salas salas);

    Salas find(Object id);

    List<Salas> findAll();

    List<Salas> findRange(int[] range);

    int count();
    
}
