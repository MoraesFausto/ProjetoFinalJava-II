/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.controller;

import br.edu.utfpr.moraesfausto.englishschool.view.swing.Main;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author f4ustx
 */
public class saveController<T> {
   public boolean isAssignable(Class<T> type, String parameter) throws InstantiationException, IllegalAccessException{
        T t = type.cast(parameter);
        return true;        
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
