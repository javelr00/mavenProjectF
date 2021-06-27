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
 * @author javia
 */
@Named
@RequestScoped
public class ListenerView {

    private String text;

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public void handleKeyEvent() {
        text = text.toUpperCase();
    }
}