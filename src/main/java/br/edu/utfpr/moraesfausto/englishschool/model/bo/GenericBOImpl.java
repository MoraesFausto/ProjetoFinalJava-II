package br.edu.utfpr.moraesfausto.englishschool.model.bo;

import java.lang.reflect.Field;

import br.edu.utfpr.moraesfausto.englishschool.model.dao.generic.GenericDAO;
import br.edu.utfpr.moraesfausto.englishschool.model.dao.generic.GenericDAOImpl;
import java.util.List;

public class GenericBOImpl<T> implements GenericBO<T> {
    private GenericDAO<T> genericDAO;
    public T Obj;

    public GenericBOImpl(T obj) {
        this.genericDAO = new GenericDAOImpl();
        this.Obj = obj;
    }

    @Override
    public void save(T object) {
        try{
            genericDAO.save(object);
        } catch(Exception he){
            System.out.println(he);
        }
        
    }

    @Override
    public void update(T object) {
        try{
            genericDAO.update(object);
        } catch(Exception he){
            System.out.println(he);
        }
    }

    @Override
    public void delete(T object) {
        try{
            genericDAO.delete(object);
        } catch(Exception he){
            System.out.println(he);
        }
    }

    public Field [] testGenericReader(T object){
        Field [] fields = object.getClass().getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getName());
        }
        return fields;
    }
    
    public T getGenericObject(){
        return Obj;
    }

    public void setObj(T Obj) {
        this.Obj = Obj;
    }

}
