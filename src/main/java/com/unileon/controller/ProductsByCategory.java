/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;


import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@ManagedBean
@RequestScoped
public class ProductsByCategory {
    
    private String cat;
    
    public ProductsByCategory(){
    }
    
    public List<String> getProducts() {
        return ProductDA.searchProductsByCategory(cat);
    }
    
    public String getCat(){
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }
    
    
}
        