/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.view.swing;

import br.edu.utfpr.moraesfausto.englishschool.controller.SaveController;

import br.edu.utfpr.moraesfausto.englishschool.model.bo.TeamBO;

import br.edu.utfpr.moraesfausto.englishschool.model.dao.generic.GenericDAOImpl;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Contract;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Coordinator;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Teacher;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Team;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Worker;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author f4ustx
 */
public class SaveTeacher extends javax.swing.JInternalFrame {
    static JFrame frame;
    static JPanel panel = new JPanel();
    static SaveController saveController = new SaveController();
    static String Function;
    static Worker worker = new Worker();
    static Teacher teacher;
    static Coordinator coordinator;
    static Team team = new Team();
    static TeamBO teamBO;
    

    /**
     * Creates new form SaveScreen
     */
    public SaveTeacher(String function) {
        Function = function;
        main(function);
        initComponents();
    }
    
    public static void main(String args){
        frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        frame.setPreferredSize(new Dimension(600, 800));
        frame.setTitle("Add a New " + args);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints frameConstraints = new GridBagConstraints();
        
        
        // Add button to this 
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 0;

        // Construct panel
        panel.setPreferredSize(new Dimension(300, 800));
        panel.setLayout(new GridBagLayout());
        panel.setBorder(LineBorder.createBlackLineBorder());
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(00, 100, 500, 500);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500, 600));
        contentPane.add(scrollPane);
        // Add panel to this
        frame.add(contentPane, frameConstraints);

        // Pack this
        frame.pack();
        
        saveController.genericFields = saveController.testGenericReader(worker);
        saveController.swingFields = saveController.generateGenericFields(saveController.genericFields.fields);
        
        for(JTextField textField : saveController.swingFields.listOfFields){
            JLabel label = new JLabel();
            JLabel lsLabel = new JLabel();
            lsLabel.setText("");
            label.setText(textField.getText());
            label.setHorizontalAlignment(JLabel.CENTER);
            if(textField.getText().equals("description")){
                lsLabel.setText("Contract");
            }else if(textField.getText().equals("name")){
                lsLabel.setText("Personal Info");
            }
                
            textField.setText("");
            panel.add(lsLabel, saveController.swingFields.textFieldConstraints);
            panel.add(label, saveController.swingFields.textFieldConstraints);
            panel.add(textField, saveController.swingFields.textFieldConstraints);
            

        }
        if(args.equals("Teacher")){
            JLabel teamLabel = new JLabel();
            teamLabel.setText("Team");
            JTextField teamId = new JTextField();
            teamId.setText("");
            panel.add(teamLabel, saveController.swingFields.textFieldConstraints);
            panel.add(teamId, saveController.swingFields.textFieldConstraints);
            saveController.swingFields.listOfFields.add(teamId);
        }
        for(JCheckBox boxInput : saveController.swingFields.listOfCheckBoxes)
            panel.add(boxInput, saveController.swingFields.textFieldConstraints);
        
        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(new EnterButtonListener(Function));
        enterButton.setHorizontalAlignment(JButton.CENTER);
        
        panel.add(enterButton, saveController.swingFields.textFieldConstraints);
        

        
        // Make this visible
        frame.setVisible(true);

    }
    
    static class EnterButtonListener implements ActionListener{
        String Function;
        public EnterButtonListener(String function){
            Function = function;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            
            worker.setActive(saveController.swingFields.listOfCheckBoxes.get(0).isSelected());
            worker.setName(saveController.swingFields.listOfFields.get(0).getText());
            worker.setPassword(saveController.swingFields.listOfFields.get(1).getText());
            worker.setPhone(saveController.swingFields.listOfFields.get(2).getText());
            worker.setLicenseNumber(saveController.swingFields.listOfFields.get(3).getText());
            Contract contract = new Contract();
            contract.setDescription(saveController.swingFields.listOfFields.get(4).getText());
            contract.setYearsLeft(Integer.parseInt(saveController.swingFields.listOfFields.get(5).getText()));
            contract.setValue(Float.parseFloat((saveController.swingFields.listOfFields.get(6).getText())));
            worker.setContract(contract);
            
            
            
            if(Function.equals("Teacher")){
                teamBO = new TeamBO();
                teamBO.save(team);
                teacher = new Teacher(worker);
                teacher.setTeam(teamBO.listById(Long.parseLong(saveController.swingFields.listOfFields.get(7).getText())));
                GenericDAOImpl genericDAO = new GenericDAOImpl();
                genericDAO.save(teacher);
            }
                
            /*
            
            TeacherBO teacherBO = new TeacherBO();
            teacherBO.save(teacher);*/
            showMessageDialog(null, "Saved!");
            panel.removeAll();
            panel.updateUI();
            frame.dispose();
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
