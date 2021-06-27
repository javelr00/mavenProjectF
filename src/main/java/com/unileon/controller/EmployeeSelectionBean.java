/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author javia_66o2ewb
 */
@Named
@ManagedBean
@ViewScoped
public class EmployeeSelectionBean implements Serializable{
  private List<String> selectedEmployees;
  private List<String> employees;

  @PostConstruct
  public void init() {
      employees = Arrays.asList("Jim", "Sara", "Tom",
              "Diana", "Tina", "Joe", "Lara", "Charlie");
  }

  public void setSelectedEmployees(List<String> selectedEmployees) {
      this.selectedEmployees = selectedEmployees;
  }

  public List<String> getSelectedEmployees() {
      return selectedEmployees;
  }

  public List<String> getEmployees() {
      return employees;
  }
}