/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.view.swing;

import javax.persistence.EntityManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import br.edu.utfpr.moraesfausto.englishschool.model.dao.HibernateConnection;
import br.edu.utfpr.moraesfausto.englishschool.model.bo.LevelBO;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Level;
import br.edu.utfpr.moraesfausto.englishschool.model.bo.GenericBOImpl;
import br.edu.utfpr.moraesfausto.englishschool.controller.saveController;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


/**
 *
 * @author f4ustx
 */
public class Main extends javax.swing.JInternalFrame {
    static JPanel panel = new JPanel();
    static List<JTextField> listOfFields = new ArrayList<JTextField>();;
    static Field [] fields;
    private GenericBOImpl genericType;
    static Method [] methods;
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }
    
    public static void main(String[] args){
        Level level = new Level();

        GenericBOImpl<Level> Generic = new GenericBOImpl<Level>(level);
        /*
        level.setDescription("teste2");
        level.setTitle("TESTE");
        Generic.save(level);
        */
        fields = Generic.testGenericReader(level);
        methods = Generic.Obj.getClass().getDeclaredMethods();

        JFrame frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        frame.setPreferredSize(new Dimension(990, 990));
        frame.setTitle("Teste");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            GridBagConstraints frameConstraints = new GridBagConstraints();        
            JButton addButton = new JButton("test");
            addButton.addActionListener(new ButtonListener(frame, Generic));

            // Add button to frame
            frameConstraints.gridx = 0;
            frameConstraints.gridy = 0;
            frame.add(addButton, frameConstraints);

            // Construct panel
            panel.setPreferredSize(new Dimension(600, 600));
            panel.setLayout(new GridBagLayout());
            panel.setBorder(LineBorder.createBlackLineBorder());

            // Add panel to frame
            frameConstraints.gridx = 0;
            frameConstraints.gridy = 1;
            frameConstraints.weighty = 1;
            frame.add(panel, frameConstraints);

            // Pack frame
            frame.pack();

            // Make frame visible
            frame.setVisible(true);
        }
        static class ButtonListener implements ActionListener
        {
            JFrame frame;
            GenericBOImpl Generic;
            
            GridBagConstraints frameConstraints = new GridBagConstraints();        

            
            public ButtonListener(JFrame n_frame, GenericBOImpl generic){
                frame = n_frame;
                Generic = generic;   
            }
            
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {       

                panel.removeAll();
                GridBagConstraints textFieldConstraints = new GridBagConstraints();

                int rowCnt=4,i,j;

                for(i=0;i<fields.length;i++){
                        JTextField input =new JTextField();
                        input.setText(fields[i].getName());
                        
                        textFieldConstraints.gridx = i;
                        textFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
                        textFieldConstraints.weightx = 0.5;
                        textFieldConstraints.insets = new Insets(10, 10, 10, 10);
                        listOfFields.add(input);                        
                }
                
                for(JTextField input : listOfFields)
                     panel.add(input, textFieldConstraints);
                JButton addButton = new JButton("enter");
                addButton.addActionListener(new EnterButtonListener(Generic));
                frameConstraints.gridx = 0;
                frameConstraints.gridy = 100;
                frame.add(addButton, frameConstraints);
                
                

                panel.updateUI();
            }

        }
        
        static class EnterButtonListener implements ActionListener{
            GenericBOImpl Generic;
            saveController controller = new saveController();
            public EnterButtonListener(GenericBOImpl generic){
                Generic = generic;
            }
            
            @Override
            public void actionPerformed(ActionEvent arg0){
                panel.removeAll();
                Generic.Obj = controller.assignValues(methods, listOfFields, Generic.Obj);

                panel.updateUI();
            }
                
        }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
