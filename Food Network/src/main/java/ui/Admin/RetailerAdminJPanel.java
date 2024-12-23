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


public class RetailerAdminJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RetailerAdminJPanel
     */
    JPanel adminLayout;
    MongoDatabase database;
    Business business;
    MongoCollection<Document> RetailerCollection;
    MongoCollection<Document> userCollection;
    CRUDOperations crudOperations = new CRUDOperations();

    public RetailerAdminJPanel(JPanel adminLayout, MongoDatabase database, Business business) {
        initComponents();
        this.adminLayout = adminLayout;
        this.database = new Connection().connectToDatabase();
        this.business = business;

        RetailerCollection = this.database.getCollection("Retailer");
        userCollection = this.database.getCollection("UserLogin");
        populateRetailerTable();
    }

    private void populateRetailerTable() {
        DefaultTableModel model = (DefaultTableModel) tblRetailerAdminDetails.getModel();
        model.setRowCount(0);

        FindIterable<Document> RetailerDetails = RetailerCollection.find();
        for (Document document : RetailerDetails) {
            org.bson.Document user = crudOperations.getFirstRecordByKey("_id", new ObjectId(document.get("RetailerAdminId").toString()), userCollection);

            model.addRow(new Object[]{
                    document.get("RetailerName"),
                    document.get("RetailerAddress"),
                    document.get("RetailerContact"),
                    document.get("RetailerEmail"),
                    user.get("username")
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
        tblRetailerAdminDetails = new javax.swing.JTable();
        btnAddRetailer = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        tblRetailerAdminDetails.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblRetailerAdminDetails);

        btnAddRetailer.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnAddRetailer.setText("Add Retailer");
        btnAddRetailer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRetailerActionPerformed(evt);
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
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddRetailer)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBack)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnBack)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnAddRetailer)
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddRetailerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRetailerActionPerformed
        // TODO add your handling code here:
        AddRetailerJPanel addRetailerJPanel = new AddRetailerJPanel(adminLayout, database, business);
        adminLayout.add("AddSupplierJPanel", addRetailerJPanel);
        ((java.awt.CardLayout) adminLayout.getLayout()).next(adminLayout);
    }//GEN-LAST:event_btnAddRetailerActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
         BusinessJPanel adminWorkAreaJPanel = new BusinessJPanel(adminLayout, database, business);
        adminLayout.add("AdminWorkAreaJPanel", adminWorkAreaJPanel);
        CardLayout layout = (CardLayout) adminLayout.getLayout();
        layout.next(adminLayout);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRetailer;
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRetailerAdminDetails;
    // End of variables declaration//GEN-END:variables
}
