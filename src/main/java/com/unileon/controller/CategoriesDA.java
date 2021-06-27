/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import java.util.ArrayList;
import java.util.List;

public class CategoriesDA{

    private static final List<String> cats = new ArrayList<String>();

            static {

                cats.add("food");
                cats.add("home");
                cats.add("machine");
                cats.add("electronic");
            }

            public static List<String> getCats() {
                return cats;
            }
        }
        