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

public class ProductDA{

    private static final Map<String, List<String>> products = new HashMap<String, List<String>>();
    
    static {
        List<String> productByCategory = new ArrayList<>();
        productByCategory.add("Milk");
        productByCategory.add("Vinamilk");
        productByCategory.add("Rice");
        productByCategory.add("Tomato");
        products.put("food", productByCategory);
        
        productByCategory = new ArrayList<>();
        productByCategory.add("Laptop");
        productByCategory.add("IPad");
        products.put("electronic", productByCategory);
        
        productByCategory = new ArrayList<>();
        productByCategory.add("Brick");
        productByCategory.add("Mortar");
        products.put("home", productByCategory);
    }
    
    public static List<String> searchProductsByCategory (String category){
    
        return products.get(category);
    }
}
        