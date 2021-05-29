/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Roles;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author javia_66o2ewb
 */
@Stateless
public class RolesFacade extends AbstractFacade<Roles> implements RolesFacadeLocal {

    @PersistenceContext(unitName = "mavenprojectFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolesFacade() {
        super(Roles.class);
    }
    
    @Override
    
    public Roles buscarRolPorTipoUsuario(String tipo){
        
        Roles rol=null;
        String consulta;
        try{
            consulta = "SELECT r FROM Rol r WHERE r.tipoUsuario = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, tipo);
            List<Roles> listaRoles =query.getResultList();
            
            if(!listaRoles.isEmpty()){
                rol = listaRoles.get(0);
            }
        }catch (Exception e){
            System.out.println("Tipo de usuario no encontrado en la bbdd");
        }
        return rol;
               
    }
}
