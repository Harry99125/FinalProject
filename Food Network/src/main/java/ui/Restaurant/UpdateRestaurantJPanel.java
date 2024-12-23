/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Restaurant;

import ui.Farmer.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.CRUDOperations;
import database.Connection;
import javax.swing.*;

import model.Business.Business;
import model.Farmer.Farmer;
import model.Farmer.Produce;

import java.awt.*;
import model.Restaurant.Restaurant;
import org.bson.Document;


public class UpdateRestaurantJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddProduceJPanel
     */
    JPanel cardSequencePanel;
    Business business;
    Restaurant restaurant;
    MongoDatabase database;
    CRUDOperations crud = new CRUDOperations();
    MongoCollection<Document> collection;
    String produceName;
    Boolean addProduce = false;

    public UpdateRestaurantJPanel(JPanel cardSequencePanel, Business business, Restaurant restaurant, String produceName, MongoDatabase database) {
        initComponents();
        this.cardSequencePanel = cardSequencePanel;
        this.business = business;
        this. restaurant = restaurant;
        this.database = new Connection().connectToDatabase();
        this.collection = this.database.getCollection("RestaurantItem");
        this.produceName = produceName;
        if (produceName != null) {
            String farmerName =  restaurant.getRestaurantName();
            Document prod = crud.getFirstRecordByKey("produceName", produceName, this.database.getCollection("Produce"));
            Document farm = crud.getFirstRecordByKey("restaurantName", farmerName, this.database.getCollection("Restaurant"));
            String prodId = prod.getObjectId("_id").toString();
            String farmId = farm.getObjectId("_id").toString();
            Document farmerProduce = crud.getRecordByTwoKeys("produceId", prodId, "restaurantId", farmId, collection);

            txtProduceName.setText(prod.getString("produceName"));
        
            txtProduceComposition.setText(prod.getString("produceCategory"));
          
            txtProduceQuantity.setText(String.valueOf(farmerProduce.getInteger("quantity")));
        

//          disable text fields
            txtProduceName.setEnabled(false);
     
            txtProduceComposition.setEnabled(false);
        
        } else {
            addProduce = true;
            txtProduceName.setText("");
         
            txtProduceComposition.setText("");
      
            txtProduceQuantity.setText("");
          
            btnupdate.setText("Add Produce");
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtProduceName = new javax.swing.JTextField();
        txtProduceComposition = new javax.swing.JTextField();
        txtProduceQuantity = new javax.swing.JTextField();
        btnupdate = new javax.swing.JButton();
        lblProduceDetails = new javax.swing.JLabel();

        setBackground(new java.awt.Color(206, 238, 251));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel2.setText("Produce Name :");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel3.setText("Category:");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel4.setText("Quantity :");

        txtProduceName.setPreferredSize(new java.awt.Dimension(130, 30));

        txtProduceComposition.setPreferredSize(new java.awt.Dimension(130, 30));
        txtProduceComposition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProduceCompositionActionPerformed(evt);
            }
        });

        txtProduceQuantity.setPreferredSize(new java.awt.Dimension(130, 30));
        txtProduceQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProduceQuantityActionPerformed(evt);
            }
        });

        btnupdate.setBackground(new java.awt.Color(0, 153, 204));
        btnupdate.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnupdate.setText("Update Produce");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        lblProduceDetails.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblProduceDetails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProduceDetails.setText("PRODUCE DETAILS");
        lblProduceDetails.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(lblProduceDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtProduceComposition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtProduceName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(btnupdate)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel4)
                                .addGap(34, 34, 34)
                                .addComponent(txtProduceQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(103, 103, 103))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtProduceComposition, txtProduceName, txtProduceQuantity});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblProduceDetails)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtProduceName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtProduceComposition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProduceQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        // Validate inputs
        if (txtProduceName.getText().isEmpty()
               
                || txtProduceComposition.getText().isEmpty()
                 
                || txtProduceQuantity.getText().isEmpty()
              ) {
            JOptionPane.showMessageDialog(null, "Please fill all the details");
            return;
        }

        // Validate and parse the quantity
        String inputQuantity = txtProduceQuantity.getText();
        int quantity;
        try {
            quantity = Integer.parseInt(inputQuantity);
            if (quantity < 0) {
                JOptionPane.showMessageDialog(null, "Quantity cannot be negative.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid integer for quantity.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate the price
      
     

        try {
            String farmerName = restaurant.getRestaurantName();
            Document farm = crud.getFirstRecordByKey("restaurantName", farmerName, database.getCollection("Restaurant"));
            String farmId = farm.getObjectId("_id").toString();

            if (addProduce) {
                // Add new produce
                Document produce = new Document("produceName", txtProduceName.getText().trim())
                        
                        .append("produceCategory", txtProduceComposition.getText().trim())
                        ;
                database.getCollection("Produce").insertOne(produce);

                // Get the produce ID
                Document insertedProduce = database.getCollection("Produce")
                        .find(new Document("produceName", txtProduceName.getText().trim())).first();
                String produceId = insertedProduce.getObjectId("_id").toString();

                // Add to FarmerProduce
                Document farmerProduce = new Document("restaurantId", farmId)
                        .append("produceId", produceId)
                       
                        .append("quantity", quantity);
                collection.insertOne(farmerProduce);

                JOptionPane.showMessageDialog(null, "Produce added successfully!");
            } else {
                // Update existing produce
                Document produce = new Document("quantity", quantity);

                Document prod = crud.getFirstRecordByKey("produceName", produceName, database.getCollection("Produce"));
                String prodId = prod.getObjectId("_id").toString();

                collection.updateOne(new Document("produceId", prodId).append("restaurantId", farmId), new Document("$set", produce));
                JOptionPane.showMessageDialog(null, "Produce updated successfully!");
            }

            backAction();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        
    }//GEN-LAST:event_btnupdateActionPerformed

    private void txtProduceCompositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProduceCompositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProduceCompositionActionPerformed

    private void txtProduceQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProduceQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProduceQuantityActionPerformed

    private void backAction() {
        cardSequencePanel.remove(this);
         Component[] componentArray = cardSequencePanel.getComponents();
        Component component = componentArray[componentArray.length - 1];
       RestaurantPListJPanel manageItemCatalogPanel = ( RestaurantPListJPanel) component;
        manageItemCatalogPanel.populateTable();
        CardLayout layout = (CardLayout) cardSequencePanel.getLayout();
        layout.previous(cardSequencePanel);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblProduceDetails;
    private javax.swing.JTextField txtProduceComposition;
    private javax.swing.JTextField txtProduceName;
    private javax.swing.JTextField txtProduceQuantity;
    // End of variables declaration//GEN-END:variables

}
