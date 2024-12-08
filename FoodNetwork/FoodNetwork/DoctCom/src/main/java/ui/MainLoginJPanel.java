/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.CRUDOperations;
import model.Business.Business;

import javax.swing.*;
import java.awt.*;

import model.Hospital.Hospital;

import model.MedicalEquipment.FoodProcessItemDirectory;
import model.Personnel.Doctor;
import model.Pharmacy.Pharmacy;
import model.TrainingCenter.TrainingCenter;

import static org.bouncycastle.asn1.x509.X509ObjectIdentifiers.organization;

import org.bson.Document;
import ui.Admin.BusinessJPanel;
import ui.Doctor.DoctorMainJPanel;
import ui.Hospital.HospitalAdminWorkAreaJPanel;
import ui.Pharmacy.PharmacyAdminWorkAreaJPanel;
import ui.TrainingCenter.TrainingCenterAdminWorkAreaJPanel;
import ui.medicalEquipment.MedicalEquipmentAdminWorkAreaJPanel;

import ui.Hospital.HospitalAdminWorkAreaJPanel;

import ui.Doctor.DoctorMainJPanel;
import ui.FoodProcessorUI.FoodProcessorAdminWorkAreaJPanel;
//import org.bson.types.ObjectId;
import ui.Pharmacy.PharmacyAdminWorkAreaJPanel;

import ui.TrainingCenter.TrainingCenterAdminWorkAreaJPanel;


public class MainLoginJPanel extends javax.swing.JPanel {

    /**
     * Creates new form MainLoginJPanel
     */
    JPanel CardSequencePanel;
    Business business;
    String role;
    //    MongoDb
    MongoDatabase database;
    MongoCollection<Document> collection;
    MongoCollection<Document> organizationCollection;
    CRUDOperations crud = new CRUDOperations();

    public MainLoginJPanel(JPanel cardSequencePanel, Business business, String role, MongoDatabase database) {
        initComponents();
        this.CardSequencePanel = cardSequencePanel;
        this.business = business;
        this.role = role;
        if (role == "Admin") {
            lblOrganization.setVisible(false);
            cmbOrgnization.setVisible(false);
        } else {
            this.collection = database.getCollection("UserLogin");
            this.organizationCollection = database.getCollection(role);
            populateOrganizationComboBox();
        }
        lblTitle.setText("Welcome " + role);
        
    }

    private void populateOrganizationComboBox() {
        cmbOrgnization.removeAllItems();
        String organizationName = role.toLowerCase() + "Name";
        System.out.println("dfcgh " + organizationName);
        FindIterable<Document> organization = crud.getRecordsByKey("organizationType", role, organizationCollection);
        for (Document doc : organization) {
            cmbOrgnization.addItem(doc.getString(organizationName));
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

        lblTitle = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        userNameTxtField = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        passwordTxtField = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        lblOrganization = new javax.swing.JLabel();
        cmbOrgnization = new javax.swing.JComboBox<>();

        lblTitle.setText("LOGIN PAGE");

        lblUserName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblUserName.setText("Enter Username:");
        lblUserName.setToolTipText("");

        userNameTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTxtFieldActionPerformed(evt);
            }
        });

        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPassword.setText("Enter Password:");

        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblOrganization.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblOrganization.setText("Choose Organization:");

        cmbOrgnization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrgnizationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cmbOrgnization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(userNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passwordTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnLogin)))
                                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(173, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{btnLogin, cmbOrgnization, lblOrganization, lblPassword, lblUserName, passwordTxtField, userNameTxtField});

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblOrganization)
                                        .addComponent(cmbOrgnization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(userNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(passwordTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblUserName)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblPassword)))
                                .addGap(18, 18, 18)
                                .addComponent(btnLogin)
                                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{cmbOrgnization, lblOrganization, lblPassword, lblUserName, passwordTxtField, userNameTxtField});

    }// </editor-fold>//GEN-END:initComponents

    private void userNameTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameTxtFieldActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_userNameTxtFieldActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:

        if (role.equals("Admin")) {
            if (userNameTxtField.getText().equals("Admin") && passwordTxtField.getText().equals("Admin")) {
                JOptionPane.showMessageDialog(null, "Login Successful");
                BusinessJPanel adminWorkAreaJPanel = new BusinessJPanel(CardSequencePanel, database, business);
                CardSequencePanel.add("AdminWorkAreaJPanel", adminWorkAreaJPanel);
                CardLayout layout = (CardLayout) CardSequencePanel.getLayout();
                layout.next(CardSequencePanel);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                return;
            }
        } else {
            System.out.println("userNameTxtField.getText() = " + userNameTxtField.getText());
            System.out.println(collection);
            Document user = crud.getFirstRecordByKey("username", userNameTxtField.getText(), collection);
            System.out.println(user);
            if (user == null) {
                JOptionPane.showMessageDialog(null, "Invalid Username");
                return;
            }
//        if (!user.getString("password").equals(passwordTxtField.getText())) {
//            JOptionPane.showMessageDialog(null, "Invalid Password");
//            return;
//        }
//        check if user is part of the organization
            String organizationName = role.toLowerCase() + "Name";
            String adminId = role.toLowerCase() + "AdminId";
            if (role == "Doctor") {
                adminId = "userId";
            }
            Document userLogin = crud.getFirstRecordByKey("username", userNameTxtField.getText(), collection);
            if (userLogin == null) {
                JOptionPane.showMessageDialog(null, "User not part of the organization");
                return;
            }
            Document organization = crud.getRecordByTwoKeys(organizationName, cmbOrgnization.getSelectedItem().toString(), adminId, String.valueOf(user.getObjectId("_id")), organizationCollection);
            if (organization == null) {
                JOptionPane.showMessageDialog(null, "User not part of the organization");
                return;
            }
            JOptionPane.showMessageDialog(null, "Login Successful");
            if (role.equals("Pharmacy")) {
                Pharmacy pharmacy = new Pharmacy(organization, userLogin);
                PharmacyAdminWorkAreaJPanel pharmacyAdminWorkAreaJPanel = new PharmacyAdminWorkAreaJPanel(CardSequencePanel, pharmacy, database);
                CardSequencePanel.add("PharmacyAdminWorkAreaJPanel", pharmacyAdminWorkAreaJPanel);
                CardLayout layout = (CardLayout) CardSequencePanel.getLayout();
                layout.next(CardSequencePanel);
            }
            if (role.equals("FoodProcessor")) {
                FoodProcessItemDirectory fd = new FoodProcessItemDirectory(organization, userLogin);
                FoodProcessorAdminWorkAreaJPanel fpwa = new  FoodProcessorAdminWorkAreaJPanel(CardSequencePanel, fd, database, business);
                CardSequencePanel.add("fd", fpwa);
                CardLayout layout = (CardLayout) CardSequencePanel.getLayout();
                layout.next(CardSequencePanel);
            }
            if (role.equals("TrainingCenter")) {
                TrainingCenter trainingCenterWorkAreaJPanel = new TrainingCenter(organization, userLogin);
                TrainingCenterAdminWorkAreaJPanel trainingCenterMainJPanel = new TrainingCenterAdminWorkAreaJPanel(CardSequencePanel, trainingCenterWorkAreaJPanel, database, business);
                CardSequencePanel.add("TrainingCenterAdminWorkAreaJPanel", trainingCenterMainJPanel);
                CardLayout layout = (CardLayout) CardSequencePanel.getLayout();
                layout.next(CardSequencePanel);
            }

            if (role.equals("Hospital")) {
                Hospital hospital = new Hospital(organization, userLogin);
                HospitalAdminWorkAreaJPanel hospitalAdminWorkAreaJPanel = new HospitalAdminWorkAreaJPanel(CardSequencePanel, hospital, database, business);
                CardSequencePanel.add("HospitalAdminWorkAreaJPanel", hospitalAdminWorkAreaJPanel);
                CardLayout layout = (CardLayout) CardSequencePanel.getLayout();
                layout.next(CardSequencePanel);
            }
            if (role.equals("Doctor")) {
                Doctor doctor = new Doctor(organization, userLogin);
                DoctorMainJPanel doctorMainJPanel = new DoctorMainJPanel(CardSequencePanel, doctor, database, business);
                CardSequencePanel.add("DoctorMainJPanel", doctorMainJPanel);
                CardLayout layout = (CardLayout) CardSequencePanel.getLayout();
                layout.next(CardSequencePanel);

            }
        }

    }//GEN-LAST:event_btnLoginActionPerformed

    private void cmbOrgnizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrgnizationActionPerformed
        // TODO add your handling code here:
        resetFields();
    }//GEN-LAST:event_cmbOrgnizationActionPerformed

    private void resetFields() {
        userNameTxtField.setText("");
        passwordTxtField.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<Object> cmbOrgnization;
    private javax.swing.JLabel lblOrganization;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTextField passwordTxtField;
    private javax.swing.JTextField userNameTxtField;
    // End of variables declaration//GEN-END:variables
}
