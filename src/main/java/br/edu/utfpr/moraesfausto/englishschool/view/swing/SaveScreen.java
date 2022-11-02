/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.view.swing;

import br.edu.utfpr.moraesfausto.englishschool.controller.saveController;
import br.edu.utfpr.moraesfausto.englishschool.model.bo.GenericBOImpl;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author f4ustx
 */
public class SaveScreen extends javax.swing.JInternalFrame {
    static JPanel panel = new JPanel();
    static List<JTextField> listOfFields = new ArrayList<JTextField>();
    static List<JCheckBox> listOfCheckBoxes = new ArrayList<JCheckBox>();
    static Field [] fields;
    static GenericBOImpl Generic;
    static Method [] methods;
    /**
     * Creates new form SaveScreen
     */
    public SaveScreen(Object obj) {
        Generic = new GenericBOImpl(obj);
        initComponents();
        String[] args = null;
        main(args);
    }
    
    public static void main(String[] args){

        fields = Generic.testGenericReader(Generic.Obj);
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

        static class ButtonListener implements ActionListener {
            JFrame frame;
            GenericBOImpl Generic;
            
            GridBagConstraints frameConstraints = new GridBagConstraints();        

            
            public ButtonListener(JFrame n_frame, GenericBOImpl generic){
                frame = n_frame;
                Generic = generic;   
            }
            
            @Override
            public void actionPerformed(ActionEvent arg0) {       

                panel.removeAll();
                GridBagConstraints textFieldConstraints = new GridBagConstraints();
                saveController controller = new saveController();
                
                controller.generateGenericFields(fields);
                listOfFields = controller.swingFields.listOfFields;
                textFieldConstraints = controller.swingFields.textFieldConstraints;
                listOfCheckBoxes = controller.swingFields.listOfCheckBoxes;
                
                for(JTextField input : listOfFields){
                     input.addFocusListener(new TextFieldFocusListener(input));
                     panel.add(input, textFieldConstraints);
                }
                
                for(JCheckBox box : listOfCheckBoxes)
                    panel.add(box, textFieldConstraints);
                
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
        
        static class TextFieldFocusListener implements FocusListener{
            JTextField Input;
            String backup;
            public TextFieldFocusListener(JTextField input){
                Input = input;
                backup = input.getText();
            }
            @Override
            public void focusGained(FocusEvent e) {
                Input.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(Input.getText().equals(""))
                    Input.setText(backup);
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
