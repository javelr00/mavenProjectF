/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Tipos_tickets;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author javia_66o2ewb
 */
@Local
public interface Tipos_ticketsFacadeLocal {

    void create(Tipos_tickets tipos_tickets);

    void edit(Tipos_tickets tipos_tickets);

    void remove(Tipos_tickets tipos_tickets);

    Tipos_tickets find(Object id);

    List<Tipos_tickets> findAll();

    List<Tipos_tickets> findRange(int[] range);

    int count();
    
}
