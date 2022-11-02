/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.controller;

import br.edu.utfpr.moraesfausto.englishschool.view.swing.Main;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

/**
 *
 * @author f4ustx
 */
public class saveController<T> {
   
    public static class SwingFields{
       public List<JTextField> listOfFields=new ArrayList<>();
       public List<JCheckBox> listOfCheckBoxes= new ArrayList<>();
       public GridBagConstraints textFieldConstraints;
   }
    
    public SwingFields swingFields;
   
   public boolean isAssignable(Class<T> type, String parameter) throws InstantiationException, IllegalAccessException{
        T t = type.cast(parameter);
        return true;        
    }
   
   public SwingFields generateGenericFields(Field [] fields){
           List<JTextField> listOfFields = new ArrayList<JTextField>();
           List<JCheckBox> listOfCheckBoxes = new ArrayList<JCheckBox>();
           GridBagConstraints textFieldConstraints  = new GridBagConstraints();
                
        int rowCnt=4,i,j;
        for(i=0;i<fields.length;i++){
                if(!fields[i].getType().equals(List.class)){
                    if(!fields[i].getType().equals(boolean.class)){
                        JTextField input=new JTextField();
                        input.setText(fields[i].getName());
                        listOfFields.add(input);    
                    }else{
                        JCheckBox box_input = new JCheckBox();
                        box_input.setText(fields[i].getName());
                        listOfCheckBoxes.add(box_input);
                    }

                    textFieldConstraints.gridx = i;
                    textFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
                    textFieldConstraints.weightx = 0.5;
                    textFieldConstraints.insets = new Insets(10, 10, 10, 10);
                }                    
        }
        
        swingFields = new SwingFields();
        swingFields.listOfFields = listOfFields;
        swingFields.listOfCheckBoxes = listOfCheckBoxes;
        swingFields.textFieldConstraints = textFieldConstraints;
        return swingFields;
   }
   
   public T  assignValues(Method [] methods, List<JTextField> listOfFields, T Obj){
       int i = 0;
       for(Method m : methods){
         Class <?> [] types = m.getParameterTypes();
         if(m.getReturnType().equals(void.class) && !types[0].equals(Long.class) && !types[0].equals(List.class)){
             try{
                 saveController controller = new saveController();
                 if(controller.isAssignable(types[0], listOfFields.get(i).getText())){
                    m.invoke(Obj, listOfFields.get(i).getText());
                    String getMethod = m.getName().replaceFirst("(?:s)+", "g");
                    m  = Obj.getClass().getMethod(getMethod);
                    String title = (String) m.invoke(Obj);
                    System.out.println(title);
                 }
             } catch (InstantiationException | IllegalAccessException err){
                 System.out.println(err);
             } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                 Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
             }
             i++;
         }
     }
     return Obj;
   }
}
