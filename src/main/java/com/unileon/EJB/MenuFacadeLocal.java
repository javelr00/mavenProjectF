/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Menus;
import com.unileon.modelo.Usuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author javia_66o2ewb
 */
@Local
public interface MenuFacadeLocal {

    void create(Menus menus);

    void edit(Menus menus);

    void remove(Menus menus);

    Menus find(Object id);

    List<Menus> findAll();

    List<Menus> findRange(int[] range);
    
    public List<Menus> obtenerMenusUsuario(Usuarios us);

    int count();
    
}
