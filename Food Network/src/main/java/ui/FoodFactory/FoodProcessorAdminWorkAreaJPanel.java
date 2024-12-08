/*
  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
  * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.FoodFactory;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.Connection;
import model.Business.Business;

import javax.swing.*;
import java.awt.*;
import model.FoodProcessItem.FoodProcessItemDirectory;
import ui.MainLoginJPanel;


public class FoodProcessorAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form MedicalEquipmentMainJPanel
     */
    JPanel cardSequencePanel;
    MongoDatabase database;
  
    Business business;
    FoodProcessItemDirectory fpid;
    MongoCollection<FoodProcessItemDirectory> EquipmentSupplierCollection;

    public FoodProcessorAdminWorkAreaJPanel(JPanel cardSequencePanel, FoodProcessItemDirectory fpid, MongoDatabase database, Business business) {
        initComponents();
        this.cardSequencePanel = cardSequencePanel;
        this.fpid=fpid;
        this.database = database;

        populateSupplierDetails();
        txtEquipmentName1.setEnabled(false);
        txtEquipmentManagerName1.setEnabled(false);
        btnSaveEquipment1.setEnabled(false);
        setFlag(false);
    }

    private void populateSupplierDetails() {
           //  fpid.readincomingdata(fpid, database);
        txtEquipmentName1.setText(fpid.getSupplierName());
        txtEquipmentLocation1.setText(fpid.getSupplierAddress());
        txtEquipmentContact1.setText(fpid.getSupplierContact());
        txtEquipmentManagerName2.setText(fpid.getSupplierEmail());
        txtEquipmentManagerName1.setText(fpid.getFoodProcessManagerId());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        FoodControlPanel = new javax.swing.JPanel();
        addRequstedEquipments = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnEquipments = new javax.swing.JButton();
        FoodWorkArea = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblEquipmentLocation1 = new javax.swing.JLabel();
        lblEquipmentContact1 = new javax.swing.JLabel();
        lblManagerName1 = new javax.swing.JLabel();
        txtEquipmentContact1 = new javax.swing.JTextField();
        txtEquipmentName1 = new javax.swing.JTextField();
        txtEquipmentManagerName1 = new javax.swing.JTextField();
        txtEquipmentLocation1 = new javax.swing.JTextField();
        btnSaveEquipment1 = new javax.swing.JButton();
        lblMedicalEquipmentSupplierDetails = new javax.swing.JLabel();
        btnUpdateEquipment1 = new javax.swing.JButton();
        lblEquipmentName1 = new javax.swing.JLabel();
        lblManagerName2 = new javax.swing.JLabel();
        txtEquipmentManagerName2 = new javax.swing.JTextField();

        jSplitPane1.setDividerLocation(150);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        FoodControlPanel.setBackground(new java.awt.Color(255, 102, 0));

        addRequstedEquipments.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        addRequstedEquipments.setText("Requested Items");
        addRequstedEquipments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRequstedEquipmentsActionPerformed(evt);
            }
        });

        btnHome.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnEquipments.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnEquipments.setText("Inventory");
        btnEquipments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipmentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FoodControlPanelLayout = new javax.swing.GroupLayout(FoodControlPanel);
        FoodControlPanel.setLayout(FoodControlPanelLayout);
        FoodControlPanelLayout.setHorizontalGroup(
            FoodControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FoodControlPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(FoodControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEquipments, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addRequstedEquipments, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(174, 174, 174)
                .addGroup(FoodControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout)
                    .addComponent(btnHome))
                .addGap(57, 57, 57))
        );

        FoodControlPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addRequstedEquipments, btnEquipments, btnHome, btnLogout});

        FoodControlPanelLayout.setVerticalGroup(
            FoodControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FoodControlPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(FoodControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome)
                    .addComponent(btnEquipments, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(FoodControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addRequstedEquipments, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout))
                .addGap(20, 20, 20))
        );

        FoodControlPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addRequstedEquipments, btnEquipments, btnHome, btnLogout});

        jSplitPane1.setTopComponent(FoodControlPanel);

        FoodWorkArea.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        lblEquipmentLocation1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblEquipmentLocation1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblEquipmentLocation1.setText("Location :");

        lblEquipmentContact1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblEquipmentContact1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblEquipmentContact1.setText("Contact :");

        lblManagerName1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblManagerName1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblManagerName1.setText("Manager Name :");

        txtEquipmentContact1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEquipmentContact1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEquipmentContact1ActionPerformed(evt);
            }
        });

        txtEquipmentName1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEquipmentName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEquipmentName1ActionPerformed(evt);
            }
        });

        txtEquipmentManagerName1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEquipmentManagerName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEquipmentManagerName1ActionPerformed(evt);
            }
        });

        txtEquipmentLocation1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEquipmentLocation1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEquipmentLocation1ActionPerformed(evt);
            }
        });

        btnSaveEquipment1.setBackground(new java.awt.Color(255, 102, 0));
        btnSaveEquipment1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnSaveEquipment1.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveEquipment1.setText("Save");
        btnSaveEquipment1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveEquipment1ActionPerformed(evt);
            }
        });

        lblMedicalEquipmentSupplierDetails.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblMedicalEquipmentSupplierDetails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMedicalEquipmentSupplierDetails.setText("Food Processor Details");
        lblMedicalEquipmentSupplierDetails.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnUpdateEquipment1.setBackground(new java.awt.Color(0, 0, 0));
        btnUpdateEquipment1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnUpdateEquipment1.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateEquipment1.setText("Update Details");
        btnUpdateEquipment1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateEquipment1ActionPerformed(evt);
            }
        });

        lblEquipmentName1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblEquipmentName1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblEquipmentName1.setText("Company Name :");

        lblManagerName2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblManagerName2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblManagerName2.setText("Email:");

        txtEquipmentManagerName2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEquipmentManagerName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEquipmentManagerName2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblMedicalEquipmentSupplierDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblManagerName1)
                            .addComponent(lblManagerName2)
                            .addComponent(lblEquipmentContact1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEquipmentLocation1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEquipmentName1))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEquipmentName1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEquipmentLocation1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEquipmentContact1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnUpdateEquipment1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSaveEquipment1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEquipmentManagerName2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEquipmentManagerName1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(108, 108, 108))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblEquipmentContact1, lblEquipmentLocation1, lblEquipmentName1, lblManagerName1, lblManagerName2});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtEquipmentContact1, txtEquipmentLocation1, txtEquipmentManagerName1, txtEquipmentManagerName2, txtEquipmentName1});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblMedicalEquipmentSupplierDetails)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEquipmentName1)
                    .addComponent(txtEquipmentName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEquipmentLocation1)
                        .addComponent(txtEquipmentLocation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEquipmentContact1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEquipmentContact1))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblManagerName1)
                    .addComponent(txtEquipmentManagerName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEquipmentManagerName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblManagerName2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveEquipment1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateEquipment1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtEquipmentContact1, txtEquipmentLocation1, txtEquipmentManagerName1, txtEquipmentManagerName2, txtEquipmentName1});

        FoodWorkArea.add(jPanel1, "card2");

        jSplitPane1.setRightComponent(FoodWorkArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

     private void addRequstedEquipmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRequstedEquipmentsActionPerformed
         // TODO add your handling code here:
         RequestedItemsJPanel requestedItemsJPanel = new RequestedItemsJPanel(FoodWorkArea, fpid, database, business);
         FoodWorkArea.add("AddJPanel", requestedItemsJPanel);
         CardLayout layout = (CardLayout) FoodWorkArea.getLayout();
         layout.next(FoodWorkArea);
     }//GEN-LAST:event_addRequstedEquipmentsActionPerformed

     private void txtEquipmentContact1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEquipmentContact1ActionPerformed
         // TODO add your handling code here:
     }//GEN-LAST:event_txtEquipmentContact1ActionPerformed

     private void txtEquipmentName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEquipmentName1ActionPerformed
         // TODO add your handling code here:
     }//GEN-LAST:event_txtEquipmentName1ActionPerformed

     private void txtEquipmentManagerName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEquipmentManagerName1ActionPerformed
         // TODO add your handling code here:
     }//GEN-LAST:event_txtEquipmentManagerName1ActionPerformed

     private void txtEquipmentLocation1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEquipmentLocation1ActionPerformed
         // TODO add your handling code here:
     }//GEN-LAST:event_txtEquipmentLocation1ActionPerformed

     private void btnSaveEquipment1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveEquipment1ActionPerformed
         // TODO add your handling code here:
         fpid.setSupplierAddress(txtEquipmentLocation1.getText());
        fpid.setSupplierContact(txtEquipmentContact1.getText());
         fpid.setSupplierEmail(txtEquipmentManagerName2.getText());
        
        fpid.updateSupplierDetails(fpid, database);
         JOptionPane.showMessageDialog(null, "Supplier Details Updated Successfully");
         setFlag(false);
     }//GEN-LAST:event_btnSaveEquipment1ActionPerformed

     private void btnUpdateEquipment1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateEquipment1ActionPerformed
         // TODO add your handling code here:
         setFlag(true);
         btnSaveEquipment1.setEnabled(true);

     }//GEN-LAST:event_btnUpdateEquipment1ActionPerformed

     private void txtEquipmentManagerName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEquipmentManagerName2ActionPerformed
         // TODO add your handling code here:
     }//GEN-LAST:event_txtEquipmentManagerName2ActionPerformed

    private void btnEquipmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipmentsActionPerformed
        // TODO add your handling code here:
        FoodItemsJPanel equipmentsJPanel = new FoodItemsJPanel(FoodWorkArea,fpid, database, business);
        FoodWorkArea.add("EquipmentsJPanel", equipmentsJPanel);
        CardLayout layout = (CardLayout) FoodWorkArea.getLayout();
        layout.next(FoodWorkArea);
    }//GEN-LAST:event_btnEquipmentsActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here 
        FoodProcessorAdminWorkAreaJPanel medicalEquipmentAdminWorkAreaJPanel = new FoodProcessorAdminWorkAreaJPanel(cardSequencePanel, fpid, database, business);
        cardSequencePanel.add("MedicalEquipmentAdminWorkAreaJPanel", medicalEquipmentAdminWorkAreaJPanel);
        CardLayout layout = (CardLayout) cardSequencePanel.getLayout();
        layout.next(cardSequencePanel);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        MainLoginJPanel mainLoginJPanel = new MainLoginJPanel(cardSequencePanel, business, "Supplier", new Connection().connectToDatabase());
        cardSequencePanel.add("MainLoginJPanel", mainLoginJPanel);
        CardLayout layout = (CardLayout) cardSequencePanel.getLayout();
        layout.next(cardSequencePanel);
    }//GEN-LAST:event_btnLogoutActionPerformed

     private void setFlag(boolean b) {
         // TODO add your handling code here:
         txtEquipmentLocation1.setEnabled(b);
         txtEquipmentContact1.setEnabled(b);
         txtEquipmentManagerName2.setEnabled(b);
     }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FoodControlPanel;
    private javax.swing.JPanel FoodWorkArea;
    private javax.swing.JButton addRequstedEquipments;
    private javax.swing.JButton btnEquipments;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSaveEquipment1;
    private javax.swing.JButton btnUpdateEquipment1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblEquipmentContact1;
    private javax.swing.JLabel lblEquipmentLocation1;
    private javax.swing.JLabel lblEquipmentName1;
    private javax.swing.JLabel lblManagerName1;
    private javax.swing.JLabel lblManagerName2;
    private javax.swing.JLabel lblMedicalEquipmentSupplierDetails;
    private javax.swing.JTextField txtEquipmentContact1;
    private javax.swing.JTextField txtEquipmentLocation1;
    private javax.swing.JTextField txtEquipmentManagerName1;
    private javax.swing.JTextField txtEquipmentManagerName2;
    private javax.swing.JTextField txtEquipmentName1;
    // End of variables declaration//GEN-END:variables
}
