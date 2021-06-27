/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Snacks;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author javia_66o2ewb
 */
@Local
public interface SnacksFacadeLocal {

    void create(Snacks snacks);

    void edit(Snacks snacks);

    void remove(Snacks snacks);

    Snacks find(Object id);

    List<Snacks> findAll();

    List<Snacks> findRange(int[] range);

    int count();
    
}
