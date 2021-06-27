/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author javelr00
 */
@Named
@RequestScoped
public class ModificaUsuarioView {

    private String usuarioId;

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    
}