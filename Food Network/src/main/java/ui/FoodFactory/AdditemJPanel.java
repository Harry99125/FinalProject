/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.FoodFactory;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.CRUDOperations;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Business.Business;
import model.FoodProcessItem.FoodFactory;

import org.bson.Document;

public class AdditemJPanel extends javax.swing.JPanel {

    /**
     * Creates new form addMedicalEquipmentJPanel
     */
    JPanel cardSequencePanel;
    MongoDatabase database;
    Business business;
    CRUDOperations crud = new CRUDOperations();
    FoodFactory foodFactory;

    public AdditemJPanel(JPanel cardSequencePanel, MongoDatabase database, Business business, FoodFactory foodFactory) {
        initComponents();
        this.database = database;
        this.business = business;
        this.cardSequencePanel = cardSequencePanel;
        this.database = database;
        this.foodFactory = foodFactory;
        this.business = business;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMedicalEquipmentList = new javax.swing.JPanel();
        lblAddInventoryTitle = new javax.swing.JLabel();
        txtProductQuantity = new javax.swing.JTextField();
        lblProduct = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        lblItemDes = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        txtProductDescription = new javax.swing.JTextField();
        txtProductName = new javax.swing.JTextField();
        btnAddProduct = new javax.swing.JButton();
        txtProductPrice = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        addMedicalEquipmentList.setBackground(new java.awt.Color(255, 223, 164));

        lblAddInventoryTitle.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblAddInventoryTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddInventoryTitle.setText("ADD PRODUCT DETAILS");
        lblAddInventoryTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtProductQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtProductQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductQuantityActionPerformed(evt);
            }
        });

        lblProduct.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProduct.setText("Product");

        lblQuantity.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblQuantity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuantity.setText("Quantity");

        lblItemDes.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblItemDes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblItemDes.setText("Item Description");

        lblPrice.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrice.setText("     Price :");

        txtProductDescription.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtProductDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductDescriptionActionPerformed(evt);
            }
        });

        txtProductName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductNameActionPerformed(evt);
            }
        });

        btnAddProduct.setBackground(new java.awt.Color(255, 102, 0));
        btnAddProduct.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnAddProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnAddProduct.setText("Add Product");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        txtProductPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtProductPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductPriceActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addMedicalEquipmentListLayout = new javax.swing.GroupLayout(addMedicalEquipmentList);
        addMedicalEquipmentList.setLayout(addMedicalEquipmentListLayout);
        addMedicalEquipmentListLayout.setHorizontalGroup(
            addMedicalEquipmentListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addMedicalEquipmentListLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(addMedicalEquipmentListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, addMedicalEquipmentListLayout.createSequentialGroup()
                        .addComponent(lblAddInventoryTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(addMedicalEquipmentListLayout.createSequentialGroup()
                        .addGroup(addMedicalEquipmentListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblItemDes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addMedicalEquipmentListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtProductQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(txtProductName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtProductDescription)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addMedicalEquipmentListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnAddProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtProductPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                        .addGap(147, 147, 147))))
            .addGroup(addMedicalEquipmentListLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addMedicalEquipmentListLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtProductDescription, txtProductName, txtProductPrice, txtProductQuantity});

        addMedicalEquipmentListLayout.setVerticalGroup(
            addMedicalEquipmentListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addMedicalEquipmentListLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(lblAddInventoryTitle)
                .addGap(50, 50, 50)
                .addGroup(addMedicalEquipmentListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addMedicalEquipmentListLayout.createSequentialGroup()
                        .addGroup(addMedicalEquipmentListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(addMedicalEquipmentListLayout.createSequentialGroup()
                                .addComponent(lblProduct)
                                .addGap(82, 82, 82))
                            .addGroup(addMedicalEquipmentListLayout.createSequentialGroup()
                                .addComponent(lblQuantity)
                                .addGap(18, 18, 18)
                                .addComponent(lblItemDes)))
                        .addGap(18, 18, 18)
                        .addComponent(lblPrice))
                    .addGroup(addMedicalEquipmentListLayout.createSequentialGroup()
                        .addGroup(addMedicalEquipmentListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(addMedicalEquipmentListLayout.createSequentialGroup()
                                .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(txtProductDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addMedicalEquipmentListLayout.createSequentialGroup()
                                .addComponent(txtProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)))
                        .addGap(18, 18, 18)
                        .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(73, 73, 73))
        );

        addMedicalEquipmentListLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblItemDes, lblPrice, lblProduct, lblQuantity});

        add(addMedicalEquipmentList, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void txtProductQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductQuantityActionPerformed

    private void txtProductDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductDescriptionActionPerformed

    private void txtProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductNameActionPerformed

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        // TODO add your handling code here:
        // Get input from text fields

        String factoryId = foodFactory.getFactoryId().toString();

        String productName = txtProductName.getText();
        String productPrice = txtProductPrice.getText();
        String productDescription = txtProductDescription.getText();
        String productQuantity = txtProductQuantity.getText();

        // Validate inputs
        if (productName.isEmpty() || productPrice.isEmpty() || productDescription.isEmpty() || productQuantity.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all the details", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate numeric inputs
        double price;
        int quantity;
        try {
            price = Double.parseDouble(productPrice);
            quantity = Integer.parseInt(productQuantity);
            if (price <= 0 || quantity <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Price and Quantity must be valid positive numbers", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if the product already exists in the Product collection
        Document existingProduct = crud.getFirstRecordByKey("productName", productName, this.database.getCollection("Product"));
        if (existingProduct != null) {
            String productId = existingProduct.getObjectId("_id").toString();

            // Check if this product is already linked with the current factory in the FactoryProduct table
            Document existingFactoryProduct = crud.getRecordByTwoKeys("productId", productId, "factoryId", factoryId, this.database.getCollection("FactoryProduct"));
            if (existingFactoryProduct != null) {
                JOptionPane.showMessageDialog(null, "Product already exists in the factory inventory", "Duplication Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Link existing product with the current factory
                Document newFactoryProduct = new Document()
                        .append("factoryId", factoryId)
                        .append("productId", productId)
                        .append("quantity", quantity)
                        .append("price", price);
                this.database.getCollection("FactoryProduct").insertOne(newFactoryProduct);
                JOptionPane.showMessageDialog(null, "Product linked to the factory successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            // Product does not exist, add new product
            Document newProduct = new Document()
                    .append("productName", productName)
                    .append("productDescription", productDescription);
            this.database.getCollection("Product").insertOne(newProduct);
            String newProductId = newProduct.getObjectId("_id").toString();

            // Also link this new product with the factory
            Document newFactoryProduct = new Document()
                    .append("factoryId", factoryId)
                    .append("productId", newProductId)
                    .append("quantity", quantity)
                    .append("price", price);
            this.database.getCollection("FactoryProduct").insertOne(newFactoryProduct);
            JOptionPane.showMessageDialog(null, "New product added and linked with the factory successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_btnAddProductActionPerformed

    private void txtProductPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductPriceActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        cardSequencePanel.remove(this);
        ((java.awt.CardLayout) cardSequencePanel.getLayout()).next(cardSequencePanel);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addMedicalEquipmentList;
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel lblAddInventoryTitle;
    private javax.swing.JLabel lblItemDes;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblProduct;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JTextField txtProductDescription;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    private javax.swing.JTextField txtProductQuantity;
    // End of variables declaration//GEN-END:variables
}
