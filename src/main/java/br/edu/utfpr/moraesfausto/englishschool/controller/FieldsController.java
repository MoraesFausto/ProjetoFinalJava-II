/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.controller;

import java.awt.GridBagConstraints;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author f4ustx
 */
public class FieldsController {

    public static class SwingFields{
       public List<JTextField> listOfFields=new ArrayList<>();
       public List<JCheckBox> listOfCheckBoxes= new ArrayList<>();
       public JPasswordField passwordField = new JPasswordField();
       public GridBagConstraints textFieldConstraints;
    }


    public static class GenericFields{
        public Field [] fields;
        public Method [] methods;
        public Method [] filteredMethods;
        List<Field> listOfFields = new ArrayList<>();
        List<Method> listOfMethods = new ArrayList<>();

        public void setFields(Field [] f){
            this.fields = f;
        }

        public void setMethods(Method [] m){
            this.methods = removeMethods(m, true);
        }
        
        public void setFilteredMethods(Method [] m, String mode){
            this.filteredMethods = removeMethods(m, mode.equals("set"));
        }

        public Field [] getFields(){
            return this.fields;
        }

        public Method [] getMethods(){
            return this.methods;
        }

        public List<Field> addGenericFieldsToList(){

             for(int i = 0; i < fields.length; i ++)
                 listOfFields.add(fields[i]);
             return listOfFields;
        }

        public List<Method> addGenericMethodsToList(){

            for(int i = 0; i < methods.length; i ++)
                     listOfMethods.add(methods[i]);
            return listOfMethods;
        }

        public Field [] addGenericFieldsToArray(){
            Field [] fields = new Field [listOfFields.size()];
            for(int i = 0; i < listOfFields.size(); i++){
                fields[i] = listOfFields.get(i);
            }
            return fields;
        }

        public Method [] addGenericMethodsToArray(){
            Method [] methods = new Method [listOfMethods.size()];
            for(int i = 0; i < listOfMethods.size(); i++){
                methods[i] = listOfMethods.get(i);
            }
            return methods;
        }
        
        
        public Method [] removeMethods(Method [] methods, boolean ctl){
            
            List<Method> setMethods = new ArrayList<>();
            for(int i = 0; i < methods.length; i++){
                    if(methods[i].getReturnType().equals(void.class) == ctl && !methods[i].getName().equals("setId"))
                        setMethods.add(methods[i]);
            }
            
            Method [] finalMethods = new Method[setMethods.size()];
            for(int i = 0; i < finalMethods.length; i++)
                finalMethods[i] = setMethods.get(i);
            return finalMethods;
        }
        
    }
}

