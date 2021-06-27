/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;


import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CategoriesManager {
    private final List<String> cats = CategoriesDA.getCats();
    
    public List<String> getCats(){
        return cats;
    }
    
    public CategoriesManager(){
        
    }
}