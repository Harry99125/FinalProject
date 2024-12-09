/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Farmer;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.CRUDOperations;
import database.Connection;
import javax.swing.*;

import model.Business.Business;
import model.Farmer.Farmer;
import model.Farmer.Produce;

import java.awt.*;
import model.Retailer.Retailer;
import org.bson.Document;


public class UpdateProduceJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddProduceJPanel
     */
    JPanel cardSequencePanel;
    Business business;
    Farmer farmer;
    MongoDatabase database;
    CRUDOperations crud = new CRUDOperations();
    MongoCollection<Document> collection;
    String produceName;
    Boolean addProduce = false;

    public UpdateProduceJPanel(JPanel cardSequencePanel, Business business, Farmer farmer, String produceName, MongoDatabase database) {
        initComponents();
        this.cardSequencePanel = cardSequencePanel;
        this.business = business;
        this.farmer = farmer;
        this.database = new Connection().connectToDatabase();
        this.collection = this.database.getCollection("FarmerProduce");
        this.produceName = produceName;
        if (produceName != null) {
            String farmerName = farmer.getFarmerName();
            Document prod = crud.getFirstRecordByKey("produceName", produceName, this.database.getCollection("Produce"));
            Document farm = crud.getFirstRecordByKey("farmName", farmerName, this.database.getCollection("Farm"));
            String prodId = prod.getObjectId("_id").toString();
            String farmId = farm.getObjectId("_id").toString();
            Document farmerProduce = crud.getRecordByTwoKeys("produceId", prodId, "farmerId", farmId, collection);

            txtProduceName.setText(prod.getString("produceName"));
            txtProduceUsage.setText(prod.getString("produceUsage"));
            txtProduceComposition.setText(prod.getString("produceCategory"));
            txtProducePrice.setText(farmerProduce.getString("farmerPrice"));
            txtProduceQuantity.setText(String.valueOf(farmerProduce.getInteger("stockQuantity")));
            txtProduceDescription.setText(prod.getString("produceDescription"));

//          disable text fields
            txtProduceName.setEnabled(false);
            txtProduceUsage.setEnabled(false);
            txtProduceComposition.setEnabled(false);
            txtProduceDescription.setEnabled(false);
        } else {
            addProduce = true;
            txtProduceName.setText("");
            txtProduceUsage.setText("");
            txtProduceComposition.setText("");
            txtProducePrice.setText("");
            txtProduceQuantity.setText("");
            txtProduceDescription.setText("");
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
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtProduceName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtProduceDescription = new javax.swing.JTextArea();
        txtProduceUsage = new javax.swing.JTextField();
        txtProduceComposition = new javax.swing.JTextField();
        txtProducePrice = new javax.swing.JTextField();
        txtProduceQuantity = new javax.swing.JTextField();
        btnupdate = new javax.swing.JButton();
        lblProduceDetails = new javax.swing.JLabel();
        btnDeleteBlog = new javax.swing.JButton();

        setBackground(new java.awt.Color(206, 238, 251));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel2.setText("Produce Name :");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel3.setText("Category:");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel4.setText("Quantity :");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel7.setText("Crop Price :");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel9.setText("Usage :");

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel10.setText("Description :");

        txtProduceName.setPreferredSize(new java.awt.Dimension(130, 30));

        txtProduceDescription.setColumns(20);
        txtProduceDescription.setRows(5);
        txtProduceDescription.setPreferredSize(new java.awt.Dimension(130, 30));
        jScrollPane1.setViewportView(txtProduceDescription);

        txtProduceUsage.setPreferredSize(new java.awt.Dimension(130, 30));

        txtProduceComposition.setPreferredSize(new java.awt.Dimension(130, 30));
        txtProduceComposition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProduceCompositionActionPerformed(evt);
            }
        });

        txtProducePrice.setPreferredSize(new java.awt.Dimension(130, 30));

        txtProduceQuantity.setPreferredSize(new java.awt.Dimension(130, 30));

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

        btnDeleteBlog.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btnDeleteBlog.setText("Back");
        btnDeleteBlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBlogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtProduceComposition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtProduceUsage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtProduceName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnupdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtProducePrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtProduceQuantity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDeleteBlog, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblProduceDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(111, 111, 111))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane1, txtProduceComposition, txtProduceName, txtProducePrice, txtProduceQuantity, txtProduceUsage});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblProduceDetails)
                    .addComponent(btnDeleteBlog))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtProduceName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtProduceUsage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtProduceComposition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProducePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProduceQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtProduceName, txtProduceUsage});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDeleteBlog, lblProduceDetails});

    }// </editor-fold>//GEN-END:initComponents

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        // Validate inputs
        if (txtProduceName.getText().isEmpty()
                || txtProduceUsage.getText().isEmpty()
                || txtProduceComposition.getText().isEmpty()
                || txtProducePrice.getText().isEmpty()
                || txtProduceQuantity.getText().isEmpty()
                || txtProduceDescription.getText().isEmpty()) {
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
        String price = txtProducePrice.getText();
        if (!price.matches("\\$\\d+\\.\\d{2}")) {
            JOptionPane.showMessageDialog(null, "Please enter the price in the format such as $10.99 or $0.99.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String farmerName = farmer.getFarmerName();
            Document farm = crud.getFirstRecordByKey("farmName", farmerName, database.getCollection("Farm"));
            String farmId = farm.getObjectId("_id").toString();

            if (addProduce) {
                // Add new produce
                Document produce = new Document("produceName", txtProduceName.getText().trim())
                        .append("produceUsage", txtProduceUsage.getText().trim())
                        .append("produceCategory", txtProduceComposition.getText().trim())
                        .append("produceDescription", txtProduceDescription.getText().trim());
                database.getCollection("Produce").insertOne(produce);

                // Get the produce ID
                Document insertedProduce = database.getCollection("Produce")
                        .find(new Document("produceName", txtProduceName.getText().trim())).first();
                String produceId = insertedProduce.getObjectId("_id").toString();

                // Add to FarmerProduce
                Document farmerProduce = new Document("farmerId", farmId)
                        .append("produceId", produceId)
                        .append("farmerPrice", price)
                        .append("stockQuantity", quantity);
                collection.insertOne(farmerProduce);

                JOptionPane.showMessageDialog(null, "Produce added successfully!");
            } else {
                // Update existing produce
                Document produce = new Document("farmerPrice", price)
                        .append("stockQuantity", quantity);

                Document prod = crud.getFirstRecordByKey("produceName", produceName, database.getCollection("Produce"));
                String prodId = prod.getObjectId("_id").toString();

                collection.updateOne(new Document("produceId", prodId).append("farmerId", farmId), new Document("$set", produce));
                JOptionPane.showMessageDialog(null, "Produce updated successfully!");
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnupdateActionPerformed

    private void txtProduceCompositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProduceCompositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProduceCompositionActionPerformed

    private void btnDeleteBlogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBlogActionPerformed
        // TODO add your handling code here:
        ProduceListJPanel produceListJPanel = new ProduceListJPanel(cardSequencePanel, business, farmer, database);
        cardSequencePanel.add("ProduceListJPanel", produceListJPanel);
        CardLayout layout = (CardLayout) cardSequencePanel.getLayout();
        layout.next(cardSequencePanel);
    }//GEN-LAST:event_btnDeleteBlogActionPerformed

    private void backAction() {
        cardSequencePanel.remove(this);
        CardLayout layout = (CardLayout) cardSequencePanel.getLayout();
        layout.previous(cardSequencePanel);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteBlog;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblProduceDetails;
    private javax.swing.JTextField txtProduceComposition;
    private javax.swing.JTextArea txtProduceDescription;
    private javax.swing.JTextField txtProduceName;
    private javax.swing.JTextField txtProducePrice;
    private javax.swing.JTextField txtProduceQuantity;
    private javax.swing.JTextField txtProduceUsage;
    // End of variables declaration//GEN-END:variables

}
