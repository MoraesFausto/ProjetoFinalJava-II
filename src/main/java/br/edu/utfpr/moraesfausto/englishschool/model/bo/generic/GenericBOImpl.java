/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.bo.generic;

import br.edu.utfpr.moraesfausto.englishschool.model.dao.generic.GenericDAOImpl;
import static java.lang.System.exit;
import java.util.List;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author f4ustx
 */
public class GenericBOImpl<T> implements GenericBO<T>{
    GenericDAOImpl generic;
    public GenericBOImpl(){
        generic = new GenericDAOImpl();
    }
    
    @Override
    public void save(T object) {
        try{
            generic.save(object);
        } catch (Exception e){
            showMessageDialog(null, "Bad Data!");
        }
    }

    @Override
    public void update(T object) {
        try{
            generic.update(object);
        } catch (Exception e){
            showMessageDialog(null, "Bad Data!");
        }
    }

    @Override
    public void delete(T object) {
        try{
            generic.delete(object);
        } catch (Exception e){
            showMessageDialog(null, "Bad Data!");
        }
    }

    @Override
    public T listOne(Class clazz, int pkValue) {
        try{
            return (T) generic.listOne(clazz, pkValue);
        } catch (Exception e){
            showMessageDialog(null, "Bad Data!");
            return null;
        }
    }

    @Override
    public List<T> listAll(Class clazz) {
        try{
            return generic.listAll(clazz);
        } catch (Exception e){
            showMessageDialog(null, "Bad Data!");
            return null;
        }
    }

    @Override
    public T findOne(Class clazz, String pkName, int pkValue) {
        try{
            return (T) generic.findOne(clazz, pkName, pkValue);
        } catch (Exception e){
            showMessageDialog(null, "Bad Data!");
            return null;
        }
    }

    @Override
    public List<Object> findAllBy(Class clazz, String fkName, int fkValue) {
        try{
            return generic.findAllBy(clazz, fkName, fkValue);
        } catch (Exception e){
            showMessageDialog(null, "Bad Data!");
            return null;
        }
    }

    @Override
    public T findOneByEmail(Class clazz, String fieldValue) {
        try{
            return (T) generic.findOneByEmail(clazz, fieldValue);
        } catch (Exception e){
            showMessageDialog(null, "Bad Data!");
            return null;
        }
    }
    
    public void closeDAO(){
        try{
            generic.closeDAO();
        } catch (Exception e){
            showMessageDialog(null, "Error On Hibernate");
            exit(1);
        }
    }
}
