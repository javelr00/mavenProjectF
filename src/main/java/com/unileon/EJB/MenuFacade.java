/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;
import com.unileon.modelo.Menus;
import com.unileon.modelo.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author javia_66o2ewb
 */
@Stateless
public class MenuFacade extends AbstractFacade<Menus> implements MenuFacadeLocal {

    @PersistenceContext(unitName = "mavenprojectFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuFacade() {
        super(Menus.class);
    }
    
    @Override
    public List<Menus> obtenerMenusUsuario(Usuarios us){//No estoy seguro de que esté bien
        List<Menus> listaComplet=this.findAll();
        List<Menus> listaDev=null;
        for(int i=0; i<this.findAll().size(); i++){
            if(listaComplet.get(i).getIdRol()==us.getIdRol()){
                listaDev.add(listaComplet.get(i));
            }
        }
        return listaDev;
    }
    
}