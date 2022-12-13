/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.controller;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Contract;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Person;
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
        Class clazz = obj.getClass();
        while(!clazz.equals(Person.class))
            clazz = clazz.getSuperclass();
            
        Method [] methods = clazz.getDeclaredMethods();
        saveController.genericFields.setFilteredMethods(methods, "get");
        String [] info = new String [saveController.genericFields.filteredMethods.length];
        int i = 0;
        for(Method m : saveController.genericFields.filteredMethods){
            if(!m.getReturnType().equals(Contract.class) && !m.getReturnType().equals(Long.class)){
                try {
                    info[i] = (String) m.invoke(obj);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            i++;
        }
        return info;
    }
    
    public boolean booleanInfo(Object obj, SaveController saveController){
        try {
            Method active = obj.getClass().getDeclaredMethod("getActive");
            try {
                boolean res = Boolean.parseBoolean((String) active.invoke(obj));
                return res;
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
