/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Butacas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author javia_66o2ewb
 */
@Local
public interface ButacasFacadeLocal {

    void create(Butacas butacas);

    void edit(Butacas butacas);

    void remove(Butacas butacas);

    Butacas find(Object id);

    List<Butacas> findAll();

    List<Butacas> findRange(int[] range);

    int count();
    
}
