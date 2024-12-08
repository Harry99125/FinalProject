/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.FoodProcessorUI;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.CRUDOperations;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Business.Business;
import model.FoodProcessItem.FoodProcessItemDirectory;
import org.bson.Document;

public class AdditemJPanel extends javax.swing.JPanel {

    /**
     * Creates new form addMedicalEquipmentJPanel
     */
    JPanel cardSequencePanel;
    MongoDatabase database;
    FoodProcessItemDirectory medicalEquipmentSupplier;
    Business business;
    MongoCollection<FoodProcessItemDirectory> EquipmentSupplierCollection;
    CRUDOperations crud = new CRUDOperations();

    public AdditemJPanel(JPanel CardSequencePanel, MongoDatabase database, Business business) {
        initComponents();
        this.medicalEquipmentSupplier = medicalEquipmentSupplier;
        this.database = database;
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
        lblAddMedicalEquipmentTitle = new javax.swing.JLabel();
        txtEquipmentType = new javax.swing.JTextField();
        lblEquipmentNameNew = new javax.swing.JLabel();
        lblEquipmentType = new javax.swing.JLabel();
        lblEquipmentDescription = new javax.swing.JLabel();
        lblEquipmentPurpose = new javax.swing.JLabel();
        txtEquipmentDescription = new javax.swing.JTextField();
        txtEquipmentName = new javax.swing.JTextField();
        btnAddNewEquipment = new javax.swing.JButton();
        txtEquipmentPurpose = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        addMedicalEquipmentList.setBackground(new java.awt.Color(255, 223, 164));

        lblAddMedicalEquipmentTitle.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblAddMedicalEquipmentTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddMedicalEquipmentTitle.setText("ADD ITEM DETAILS");
        lblAddMedicalEquipmentTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtEquipmentType.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEquipmentType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEquipmentTypeActionPerformed(evt);
            }
        });

        lblEquipmentNameNew.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblEquipmentNameNew.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEquipmentNameNew.setText("        Item Name :");

        lblEquipmentType.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblEquipmentType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEquipmentType.setText("          Number :");

        lblEquipmentDescription.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblEquipmentDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEquipmentDescription.setText("Equipment Description :");

        lblEquipmentPurpose.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblEquipmentPurpose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEquipmentPurpose.setText("     Equipment Purpose :");

        txtEquipmentDescription.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEquipmentDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEquipmentDescriptionActionPerformed(evt);
            }
        });

        txtEquipmentName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEquipmentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEquipmentNameActionPerformed(evt);
            }
        });

        btnAddNewEquipment.setBackground(new java.awt.Color(255, 102, 0));
        btnAddNewEquipment.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnAddNewEquipment.setForeground(new java.awt.Color(255, 255, 255));
        btnAddNewEquipment.setText("Add Equipment");
        btnAddNewEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewEquipmentActionPerformed(evt);
            }
        });

        txtEquipmentPurpose.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEquipmentPurpose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEquipmentPurposeActionPerformed(evt);
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
                        .addComponent(lblAddMedicalEquipmentTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(addMedicalEquipmentListLayout.createSequentialGroup()
                        .addGroup(addMedicalEquipmentListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEquipmentType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEquipmentNameNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEquipmentDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEquipmentPurpose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addMedicalEquipmentListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtEquipmentType, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(txtEquipmentName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtEquipmentDescription)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addMedicalEquipmentListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnAddNewEquipment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEquipmentPurpose, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                        .addGap(147, 147, 147))))
            .addGroup(addMedicalEquipmentListLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addMedicalEquipmentListLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtEquipmentDescription, txtEquipmentName, txtEquipmentPurpose, txtEquipmentType});

        addMedicalEquipmentListLayout.setVerticalGroup(
            addMedicalEquipmentListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addMedicalEquipmentListLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(lblAddMedicalEquipmentTitle)
                .addGap(50, 50, 50)
                .addGroup(addMedicalEquipmentListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addMedicalEquipmentListLayout.createSequentialGroup()
                        .addGroup(addMedicalEquipmentListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(addMedicalEquipmentListLayout.createSequentialGroup()
                                .addComponent(lblEquipmentNameNew)
                                .addGap(82, 82, 82))
                            .addGroup(addMedicalEquipmentListLayout.createSequentialGroup()
                                .addComponent(lblEquipmentType)
                                .addGap(18, 18, 18)
                                .addComponent(lblEquipmentDescription)))
                        .addGap(18, 18, 18)
                        .addComponent(lblEquipmentPurpose))
                    .addGroup(addMedicalEquipmentListLayout.createSequentialGroup()
                        .addGroup(addMedicalEquipmentListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(addMedicalEquipmentListLayout.createSequentialGroup()
                                .addComponent(txtEquipmentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(txtEquipmentDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addMedicalEquipmentListLayout.createSequentialGroup()
                                .addComponent(txtEquipmentType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)))
                        .addGap(18, 18, 18)
                        .addComponent(txtEquipmentPurpose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddNewEquipment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(73, 73, 73))
        );

        addMedicalEquipmentListLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblEquipmentDescription, lblEquipmentNameNew, lblEquipmentPurpose, lblEquipmentType});

        add(addMedicalEquipmentList, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void txtEquipmentTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEquipmentTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEquipmentTypeActionPerformed

    private void txtEquipmentDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEquipmentDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEquipmentDescriptionActionPerformed

    private void txtEquipmentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEquipmentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEquipmentNameActionPerformed

    private void btnAddNewEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewEquipmentActionPerformed
        // TODO add your handling code here:
        // Get input from text fields
        String supplierId = medicalEquipmentSupplier.getId().toString();

        String equipmentName = txtEquipmentName.getText();
        String equipmentType = txtEquipmentType.getText();
        String equipmentPurpose = txtEquipmentPurpose.getText();
        String equipmentDescription = txtEquipmentDescription.getText();

        // Validate inputs
        if (equipmentName.isEmpty() || equipmentType.isEmpty() || equipmentPurpose.isEmpty() || equipmentDescription.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all the details", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Database connection should be established here (not shown)
        // Check if the equipment already exists in the MedicalEquipment collection
        Document existingEquipment = crud.getFirstRecordByKey("equipmentName", equipmentName, this.database.getCollection("MedicalEquipment"));
        if (existingEquipment != null) {
            String equipmentId = existingEquipment.getObjectId("_id").toString();

            // Check if this equipment is already linked with the current supplier in the SupplierEquipment table
            Document existingSupplierEquipment = crud.getRecordByTwoKeys("equipmentId", equipmentId, "supplierId", supplierId, this.database.getCollection("SupplierEquipment"));
            if (existingSupplierEquipment != null) {
                JOptionPane.showMessageDialog(null, "Equipment already present with supplier", "Duplication Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Link existing equipment with the current supplier
                Document newSupplierEquipment = new Document()
                        .append("supplierId", supplierId)
                        .append("equipmentId", equipmentId);
                this.database.getCollection("SupplierEquipment").insertOne(newSupplierEquipment);
                JOptionPane.showMessageDialog(null, "Equipment added to supplier", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            // Equipment does not exist, add new equipment
            Document newEquipment = new Document()
                    .append("equipmentName", equipmentName)
                    .append("equipmentType", equipmentType)
                    .append("equipmentDescription", equipmentDescription)
                    .append("equipmentPurpose", equipmentPurpose);
            this.database.getCollection("MedicalEquipment").insertOne(newEquipment);
            String newEquipmentId = newEquipment.getObjectId("_id").toString();

            // Also link this new equipment with the supplier
            Document newSupplierEquipment = new Document()
                    .append("supplierId", supplierId)
                    .append("equipmentId", newEquipmentId);
            this.database.getCollection("SupplierEquipment").insertOne(newSupplierEquipment);
            JOptionPane.showMessageDialog(null, "New equipment added and linked with the supplier", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        txtEquipmentName.setText("");
        txtEquipmentType.setText("");
        txtEquipmentPurpose.setText("");
        txtEquipmentDescription.setText("");
    }//GEN-LAST:event_btnAddNewEquipmentActionPerformed

    private void txtEquipmentPurposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEquipmentPurposeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEquipmentPurposeActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        cardSequencePanel.remove(this);
        ((java.awt.CardLayout) cardSequencePanel.getLayout()).next(cardSequencePanel);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addMedicalEquipmentList;
    private javax.swing.JButton btnAddNewEquipment;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel lblAddMedicalEquipmentTitle;
    private javax.swing.JLabel lblEquipmentDescription;
    private javax.swing.JLabel lblEquipmentNameNew;
    private javax.swing.JLabel lblEquipmentPurpose;
    private javax.swing.JLabel lblEquipmentType;
    private javax.swing.JTextField txtEquipmentDescription;
    private javax.swing.JTextField txtEquipmentName;
    private javax.swing.JTextField txtEquipmentPurpose;
    private javax.swing.JTextField txtEquipmentType;
    // End of variables declaration//GEN-END:variables
}
