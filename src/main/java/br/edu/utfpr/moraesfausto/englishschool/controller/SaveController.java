/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.controller;

import br.edu.utfpr.moraesfausto.englishschool.controller.FieldsController.GenericFields;
import br.edu.utfpr.moraesfausto.englishschool.controller.FieldsController.SwingFields;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Contract;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author f4ustx
 */
public class SaveController<T> {



   public SwingFields swingFields = new SwingFields();
   public GenericFields genericFields = new GenericFields();

    public GenericFields testGenericReader(T object){
        Field [] fields = object.getClass().getDeclaredFields();
        Method [] methods = object.getClass().getDeclaredMethods();
        GenericFields gen = new GenericFields();
        for(Class superClass = object.getClass().getSuperclass(); !superClass.equals(Object.class);
                superClass = superClass.getSuperclass()){

             Method [] superMethods = superClass.getDeclaredMethods();
             Field [] superFields = superClass.getDeclaredFields();

             gen.setFields(superFields);
             gen.setMethods(superMethods);
             gen.addGenericFieldsToList();
             gen.addGenericMethodsToList();

        }
        int listSize = gen.listOfFields.size();
        if(listSize > 0){
            Field [] finalFields = new Field [listSize + fields.length];
            Method [] finalMethods = new Method [gen.listOfMethods.size() + fields.length];
            gen.setFields(fields);
            gen.setMethods(methods);
            gen.addGenericFieldsToList();
            gen.addGenericMethodsToList();
            finalFields = gen.addGenericFieldsToArray();
            finalMethods = gen.addGenericMethodsToArray();
            gen.setFields(finalFields);
            gen.setMethods(finalMethods);             
        }else{
            gen.setFields(fields);
            gen.setMethods(methods);
        }

        return gen;
    }

   public SwingFields generateGenericFields(Field [] fields){
           List<JTextField> listOfFields = new ArrayList<JTextField>();
           List<JCheckBox> listOfCheckBoxes = new ArrayList<JCheckBox>();
           JPasswordField passwordField = new JPasswordField();
           GridBagConstraints textFieldConstraints  = new GridBagConstraints();

        int rowCnt=4,i,j;
        for(i=0;i<fields.length;i++){
                if(!fields[i].getType().equals(List.class) && !fields[i].getType().equals(Long.class)){
                    if(!fields[i].getType().equals(boolean.class)){
                        if(fields[i].getType().equals(Contract.class)){
                            SwingFields embeddableFields = new SwingFields();
                            embeddableFields = generateGenericFields(fields[i].getType().getDeclaredFields());
                            listOfFields.addAll(embeddableFields.listOfFields);
                        }else{
                            JTextField input=new JTextField();
                            input.setText(fields[i].getName());
                            input.setHorizontalAlignment(JTextField.CENTER);
                            listOfFields.add(input);
                        }
                    }else{
                        JCheckBox box_input = new JCheckBox();
                        box_input.setText(fields[i].getName());
                        box_input.setHorizontalAlignment(JCheckBox.CENTER);
                        listOfCheckBoxes.add(box_input);
                    }

                    textFieldConstraints.gridx = i;
                    textFieldConstraints.fill = GridBagConstraints.BOTH;
                    textFieldConstraints.weightx = 0.5;
                    textFieldConstraints.insets = new Insets(7, 7, 7, 7);
                }
        }
        
        swingFields = new SwingFields();
        swingFields.listOfFields = listOfFields;
        swingFields.listOfCheckBoxes = listOfCheckBoxes;
        swingFields.passwordField = passwordField;
        swingFields.textFieldConstraints = textFieldConstraints;
        return swingFields;
   }


   public boolean isAssignable(Class<?> type, String parameter) throws InstantiationException, IllegalAccessException{
        try{
            Object t = type.cast(parameter);
            return true;
        } catch(Exception e){
            return false;
        }
    }

   public Object assignValues(Method [] methods, List<JTextField> listOfFields, List<JCheckBox> box_input, Object Obj) {

     return Obj;
   }
}

