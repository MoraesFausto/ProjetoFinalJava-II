/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.view.swing;

import br.edu.utfpr.moraesfausto.englishschool.model.bo.generic.GenericBOImpl;
import br.edu.utfpr.moraesfausto.englishschool.model.dao.generic.GenericDAOImpl;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Coordinator;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Person;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Student;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Teacher;
import br.edu.utfpr.moraesfausto.englishschool.view.swing.dashboards.CoordinatorDashboard;
import br.edu.utfpr.moraesfausto.englishschool.view.swing.dashboards.StudentDashboard;
import br.edu.utfpr.moraesfausto.englishschool.view.swing.dashboards.TeacherDashboard;
import java.awt.Component;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.naming.AuthenticationException;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author f4ustx
 */
public class viewFactory {
    Object obj = null;
    Person person = new Person();
    Student student = new Student();
    Teacher teacher = new Teacher();
    GenericBOImpl generic;
    GenericDAOImpl genericDAO = new GenericDAOImpl();
    Coordinator coordinator = new Coordinator();
    Object [] listObj = {student, teacher, coordinator};
    JDesktopPane jDesktopPane1;

    
    private void clearDesktopPane(){
        Component [] components = jDesktopPane1.getComponents();
        for(Component c : components)
            c.setVisible(!c.isVisible());
    }
    
    
    public void findPersonByEmail(String email) throws AuthenticationException{
        try{
            this.person = (Person) genericDAO.findOneByEmail(person.getClass(), email);
            
        } catch(Exception e){
            showMessageDialog(null, "Wrong Password or Email");
            throw new AuthenticationException("Wrong Password or Email");
        }
    }
    
    public void verifyPassword(String password) throws AuthenticationException{
       for(Object o : listObj){
            try{
                this.obj = genericDAO.listOne(o.getClass(), Math.toIntExact(this.person.getId()));
                if(this.obj != null){
                    Method getPassword = this.obj.getClass().getMethod("getPassword");
                    if(!password.equals((String) getPassword.invoke(this.obj))){
                        throw new AuthenticationException("Wrong Password or Email");
                        
                    }else{
                        break;
                    }
                }
            }catch (Exception e){
                if(e.getClass().equals(AuthenticationException.class)){
                    showMessageDialog(null, e.getMessage());
                    throw new AuthenticationException("Wrong Password or Email");
                }
            }
        }
    }
    
    public void generateDashboard() throws IllegalAccessException, InvocationTargetException{
        try {
            if(obj.getClass().equals(Student.class)){
                StudentDashboard studentDashboard;
                studentDashboard = new StudentDashboard(jDesktopPane1, (Student) obj, generic);
                clearDesktopPane();
                jDesktopPane1.updateUI();
                jDesktopPane1.add(studentDashboard);
                studentDashboard.setVisible(true);
            }else if(obj.getClass().equals(Teacher.class)){
                TeacherDashboard teacherDashboard = new TeacherDashboard((Teacher) obj, jDesktopPane1, generic);
                clearDesktopPane();
                jDesktopPane1.updateUI();
                jDesktopPane1.add(teacherDashboard);
                teacherDashboard.setVisible(true);
            }else if(obj.getClass().equals(Coordinator.class)){
                CoordinatorDashboard coordinatorDashboard = new CoordinatorDashboard((Coordinator) obj, jDesktopPane1, generic);
                clearDesktopPane();
                jDesktopPane1.updateUI();
                jDesktopPane1.add(coordinatorDashboard);
                coordinatorDashboard.setVisible(true);
            }
        } catch (IllegalArgumentException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void newScreen(String email, String password,JDesktopPane jDesktopPane1, GenericBOImpl generic) throws InvocationTargetException, IllegalAccessException, AuthenticationException{
        this.generic = generic;
        this.jDesktopPane1 = jDesktopPane1;
        
        findPersonByEmail(email);
        verifyPassword(password);
        generateDashboard();
    }
}
