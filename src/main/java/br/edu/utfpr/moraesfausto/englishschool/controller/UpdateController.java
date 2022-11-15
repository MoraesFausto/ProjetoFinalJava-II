/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author f4ustx
 */
public class UpdateController {
    public String [] personalInfo(Object obj, SaveController saveController){
        Method [] methods = obj.getClass().getSuperclass().getDeclaredMethods();
        saveController.genericFields.setFilteredMethods(methods, "get");
        String [] info = new String [saveController.genericFields.filteredMethods.length];
        int i = 0;
        for(Method m : saveController.genericFields.filteredMethods){
            try {
                info[i] = (String) m.invoke(obj);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
        return info;
    }
}
