/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.FoodFactory;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.CRUDOperations;
import database.Connection;

import java.awt.CardLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Business.Business;
import model.FoodProcessItem.FoodFactory;

import org.bson.Document;

public class RequestedItemsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form requestedItemsJPanel
     */
    JPanel cardSequencePanel;
    MongoDatabase database;
    FoodFactory fpFactory;
    Business business;
    CRUDOperations crudOperations = new CRUDOperations();

    public RequestedItemsJPanel(JPanel cardSequencePanel, FoodFactory fpFactory, MongoDatabase databases, Business business) {
        initComponents();
        this.cardSequencePanel = cardSequencePanel;
        this.fpFactory = fpFactory;
        this.database = new Connection().connectToDatabase();
        this.business = business;

        populateRequestedItems();
    }

    private void populateRequestedItems() {
        DefaultTableModel model = (DefaultTableModel) tblRequestedItems.getModel();
        model.setRowCount(0); // Clear existing table data

        try {
            // Retrieve all produce requests for this Food Factory
            MongoCollection<Document> requestProduceCollection = database.getCollection("RequestProduce");
            FindIterable<Document> requestProduce = crudOperations.getRecordsByKey("factoryId", fpFactory.getFactoryId().toString(), requestProduceCollection);

            for (Document request : requestProduce) {
                // Retrieve details from the request document
                String produceName = request.getString("produceName");
                double requestedPrice = request.getDouble("requestedPrice");
                int quantity = request.getInteger("quantity", 0); // Default to 0 if not present
                String status = request.getString("status");

                // Add a row for each produce request
                Object[] row = {produceName, requestedPrice, quantity, status};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while fetching requested items. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
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
        tblRequestedItems = new javax.swing.JTable();
        btnUpdateStatus = new javax.swing.JButton();
        lblMedicalEquipment1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 223, 164));

        tblRequestedItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Produce Name", "Requested Price", "Quantity", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblRequestedItems);

        btnUpdateStatus.setBackground(new java.awt.Color(255, 102, 0));
        btnUpdateStatus.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnUpdateStatus.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateStatus.setText("Add Request");
        btnUpdateStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStatusActionPerformed(evt);
            }
        });

        lblMedicalEquipment1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblMedicalEquipment1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMedicalEquipment1.setText("REQUESTED PRODUCE");
        lblMedicalEquipment1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMedicalEquipment1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnUpdateStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(lblMedicalEquipment1)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStatusActionPerformed
        // TODO add your handling code here:
        AddProduceRequestJPanel addRequestPanel = new AddProduceRequestJPanel(cardSequencePanel, fpFactory, database);
        cardSequencePanel.add("AddRequestJPanel", addRequestPanel);
        CardLayout layout = (CardLayout) cardSequencePanel.getLayout();
        layout.next(cardSequencePanel);
    }//GEN-LAST:event_btnUpdateStatusActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdateStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMedicalEquipment1;
    private javax.swing.JTable tblRequestedItems;
    // End of variables declaration//GEN-END:variables
}
