/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Admin;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.CRUDOperations;
import database.Connection;
import java.awt.CardLayout;
import model.Business.Business;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FarmAdminJPanel extends javax.swing.JPanel {

    /**
     * Creates new form FarmAdminJPanel
     */
    JPanel adminLayout;
    MongoDatabase database;
    Business business;
    MongoCollection<Document> trainingCenterCollection;
    MongoCollection<Document> userCollection;
    CRUDOperations crudOperations = new CRUDOperations();

    public FarmAdminJPanel(JPanel adminLayout, MongoDatabase database, Business business) {
        initComponents();
        this.adminLayout = adminLayout;
        this.database = new Connection().connectToDatabase();
        this.business = business;

        trainingCenterCollection = this.database.getCollection("Farm");
        userCollection = this.database.getCollection("UserLogin");
        populateTrainingCenterTable();
    }

    private void populateTrainingCenterTable() {
        DefaultTableModel model = (DefaultTableModel) tblTrainingCenterAdminDetails.getModel();
        model.setRowCount(0); // Clear the table

        // Fetch all farm documents from the "Farm" collection
        FindIterable<Document> farmDetails = trainingCenterCollection.find();
        for (Document farm : farmDetails) {
            // Retrieve the corresponding farmer user document using FarmerAdminId
            Document farmerUser = crudOperations.getFirstRecordByKey("_id", new ObjectId(farm.get("farmAdminId").toString()), userCollection);

            // Add row data to the table model
            model.addRow(new Object[]{
                farm.get("farmName"),
                farm.get("farmlocation"),
                farm.get("farmcontact"),
                farm.get("farmemail"),
                farmerUser != null ? farmerUser.get("username") : "N/A" // Safeguard for missing user data
            });

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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTrainingCenterAdminDetails = new javax.swing.JTable();
        btnAddFarmer = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        tblTrainingCenterAdminDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Location", "Contact", "Email", "Manager Name"
            }
        ));
        jScrollPane1.setViewportView(tblTrainingCenterAdminDetails);

        btnAddFarmer.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnAddFarmer.setText("Add Farmer");
        btnAddFarmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFarmerActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(498, 498, 498)
                            .addComponent(btnAddFarmer, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddFarmer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddFarmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFarmerActionPerformed
        // TODO add your handling code here:
        AddFarmerJPanel addFarmerJPanel = new AddFarmerJPanel(adminLayout, database, business);
        adminLayout.add("AddFarmerJPanel", addFarmerJPanel);
        ((java.awt.CardLayout) adminLayout.getLayout()).next(adminLayout);
    }//GEN-LAST:event_btnAddFarmerActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        BusinessJPanel adminWorkAreaJPanel = new BusinessJPanel(adminLayout, database, business);
        adminLayout.add("AdminWorkAreaJPanel", adminWorkAreaJPanel);
        CardLayout layout = (CardLayout) adminLayout.getLayout();
        layout.next(adminLayout);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFarmer;
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTrainingCenterAdminDetails;
    // End of variables declaration//GEN-END:variables
}
