/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Admin;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import database.CRUDOperations;
import database.Connection;
import java.awt.CardLayout;
import model.Business.Business;
import org.bson.Document;
import org.bson.types.ObjectId;


public class FoodProcessorAdminJPanel1 extends javax.swing.JPanel {

    /**
     * Creates new form MedicalEquipmentAdminJPanel
     */
    JPanel AdminLayout;
    Business business;
    MongoDatabase database;
    MongoCollection<Document> supplierCollection;
    MongoCollection<Document> userCollection;
    CRUDOperations crudOperations = new CRUDOperations();

    public FoodProcessorAdminJPanel1(JPanel cardSequencePanel, MongoDatabase databases, Business business) {
        initComponents();
        this.AdminLayout = cardSequencePanel;
        this.database = new Connection().connectToDatabase();
        this.business = business;
        supplierCollection = database.getCollection("FoodProcessor");
        userCollection = database.getCollection("UserLogin");

        populateTable();
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblFoodProcessorAdminDetails.getModel();
        model.setRowCount(0);

        FindIterable<Document> findIterable = supplierCollection.find();
        for (Document document : findIterable) {
            Document user = crudOperations.getFirstRecordByKey("_id", new ObjectId(document.get("FoodFactoryAdminId").toString()), userCollection);

            model.addRow(new Object[]{
                    document.get("factoryName"),
                    document.get("factoryAddress"),
                    document.get("factoryContact"),
                    document.get("factoryEmail"),
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
        tblFoodProcessorAdminDetails = new javax.swing.JTable();
        btnAddFactory = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        tblFoodProcessorAdminDetails.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblFoodProcessorAdminDetails);

        btnAddFactory.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnAddFactory.setText("Add Food Factory");
        btnAddFactory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFactoryActionPerformed(evt);
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
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAddFactory, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(218, 218, 218))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnAddFactory)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddFactoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFactoryActionPerformed
        // TODO add your handling code here:
        AddFoodFactoryJPanel addFoodFactoryJPanel = new AddFoodFactoryJPanel(AdminLayout, database, business);
        AdminLayout.add("AddSupplierJPanel", addFoodFactoryJPanel);
        ((java.awt.CardLayout) AdminLayout.getLayout()).next(AdminLayout);
    }//GEN-LAST:event_btnAddFactoryActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        BusinessJPanel adminWorkAreaJPanel = new BusinessJPanel(AdminLayout, database, business);
        AdminLayout.add("AdminWorkAreaJPanel", adminWorkAreaJPanel);
        CardLayout layout = (CardLayout) AdminLayout.getLayout();
        layout.next(AdminLayout);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFactory;
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFoodProcessorAdminDetails;
    // End of variables declaration//GEN-END:variables
}
