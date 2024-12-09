/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Warehouse;

import ui.Restaurant.*;
import ui.Farmer.*;
import com.google.maps.GeoApiContext;
import com.google.maps.PlaceAutocompleteRequest;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.AutocompletePrediction;

import java.awt.CardLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.Connection;
import java.awt.event.ItemEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.Business.Business;
import model.Farmer.Farmer;
import model.Restaurant.Restaurant;
import model.Warehouse.Warehouse;
import org.bson.Document;
import ui.LoginJFrame;
import ui.MainLoginJPanel;


public class WarehouseAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form WarehouseAdminWorkAreaJPanel
     */
    JPanel CardSequencePanel;
    Business business;
    Warehouse warehouse;
    MongoDatabase database;
    private boolean isUpdating;
  


   public WarehouseAdminWorkAreaJPanel(JPanel cardSequencePanel,Warehouse warehouse, MongoDatabase database, Business business) {
    initComponents();
    this.CardSequencePanel = cardSequencePanel;
    this.warehouse = warehouse;
    this.database = database;
    this.business = business;
    populateFarmerDetails();
        
    isUpdating = true;
    txtFarmerName.setEnabled(false);
    txtFarmerManagerName.setEnabled(false);
//    btnSave.setEnabled(false);
    setFlag(false);
    // System.out.println(farmer.getId());
}

private void setFlag(boolean b) {
    txtFarmerAddress.setEnabled(b);
    txtFarmerContact.setEnabled(b);
    txtFarmerEmail.setEnabled(b);
}

private void populateFarmerDetails() {
    txtFarmerName.setText(warehouse.getWarehouseName());
    txtFarmerAddress.setText(warehouse.getWarehouselocation());
    txtFarmerContact.setText(warehouse.getWarehousecontact());
    txtFarmerEmail.setText(warehouse.getWarehouseemail());
    txtFarmerManagerName.setText(warehouse.getWarehouseManageName());
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane2 = new javax.swing.JSplitPane();
        FarmerCardLayout = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblPharmacyName = new javax.swing.JLabel();
        lblFarmerAddress = new javax.swing.JLabel();
        lblFarmerContact = new javax.swing.JLabel();
        lblFarmerEmail = new javax.swing.JLabel();
        lblFarmerManagerName = new javax.swing.JLabel();
        txtFarmerName = new javax.swing.JTextField();
        txtFarmerContact = new javax.swing.JTextField();
        txtFarmerEmail = new javax.swing.JTextField();
        txtFarmerManagerName = new javax.swing.JTextField();
        lblFarmerDetails = new javax.swing.JLabel();
        txtFarmerAddress = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnFarmerList = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        jSplitPane2.setDividerLocation(150);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        FarmerCardLayout.setLayout(new java.awt.CardLayout());

        jPanel4.setBackground(new java.awt.Color(255, 153, 153));

        lblPharmacyName.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblPharmacyName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPharmacyName.setText("Name :");

        lblFarmerAddress.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblFarmerAddress.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblFarmerAddress.setText("Location :");

        lblFarmerContact.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblFarmerContact.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblFarmerContact.setText("Contact :");

        lblFarmerEmail.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblFarmerEmail.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblFarmerEmail.setText("Email :");

        lblFarmerManagerName.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblFarmerManagerName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblFarmerManagerName.setText("Manager Name :");

        txtFarmerName.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        txtFarmerContact.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        txtFarmerEmail.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtFarmerEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFarmerEmailActionPerformed(evt);
            }
        });

        txtFarmerManagerName.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        lblFarmerDetails.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblFarmerDetails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFarmerDetails.setText("Warehouse DETAILS");
        lblFarmerDetails.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtFarmerAddress.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtFarmerAddress.setMinimumSize(new java.awt.Dimension(40, 23));
        txtFarmerAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFarmerAddressKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFarmerDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblFarmerContact)
                                .addComponent(lblFarmerEmail)
                                .addComponent(lblFarmerManagerName))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtFarmerContact, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                                .addComponent(txtFarmerEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                                .addComponent(txtFarmerManagerName, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblPharmacyName)
                                .addComponent(lblFarmerAddress))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtFarmerName, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                                .addComponent(txtFarmerAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))))
                .addGap(180, 180, 180))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblFarmerAddress, lblFarmerContact, lblFarmerEmail, lblFarmerManagerName, lblPharmacyName});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtFarmerAddress, txtFarmerContact, txtFarmerEmail, txtFarmerManagerName, txtFarmerName});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblFarmerDetails)
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPharmacyName)
                    .addComponent(txtFarmerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFarmerAddress)
                    .addComponent(txtFarmerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFarmerContact)
                    .addComponent(txtFarmerContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFarmerEmail)
                    .addComponent(txtFarmerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFarmerManagerName)
                    .addComponent(txtFarmerManagerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblFarmerAddress, lblFarmerContact, lblFarmerEmail, lblFarmerManagerName, lblPharmacyName});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtFarmerAddress, txtFarmerContact, txtFarmerEmail, txtFarmerManagerName, txtFarmerName});

        FarmerCardLayout.add(jPanel4, "card2");

        jSplitPane2.setRightComponent(FarmerCardLayout);

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));

        btnFarmerList.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnFarmerList.setText("Produce List");
        btnFarmerList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFarmerListActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(btnFarmerList, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(btnLogout)
                .addGap(84, 84, 84))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnFarmerList, btnHome, btnLogout});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFarmerList, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHome))
                .addGap(52, 52, 52))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnFarmerList, btnHome, btnLogout});

        jSplitPane2.setTopComponent(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtFarmerEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFarmerEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFarmerEmailActionPerformed

    private void btnFarmerListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFarmerListActionPerformed
        // TODO add your handling code here:
        WarehousePListJPanel produceListJPanel = new WarehousePListJPanel(FarmerCardLayout, business, warehouse, database);
        FarmerCardLayout.add("ProduceListJPanel", produceListJPanel);
        CardLayout layout = (CardLayout) FarmerCardLayout.getLayout();
        layout.next(FarmerCardLayout);
    }//GEN-LAST:event_btnFarmerListActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        MainLoginJPanel mainLoginJPanel = new MainLoginJPanel(CardSequencePanel, business, "Admin", new Connection().connectToDatabase());
        CardSequencePanel.add("MainLoginJPanel", mainLoginJPanel);
        CardLayout layout = (CardLayout) CardSequencePanel.getLayout();
        layout.next(CardSequencePanel);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        WarehouseAdminWorkAreaJPanel farmerAdminWorkAreaJPanel = new WarehouseAdminWorkAreaJPanel(CardSequencePanel, warehouse, database,business);
        CardSequencePanel.add("AdminWorkAreaJPanel", farmerAdminWorkAreaJPanel);
        CardLayout layout = (CardLayout) CardSequencePanel.getLayout();
        layout.next(CardSequencePanel);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void txtFarmerAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFarmerAddressKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFarmerAddressKeyReleased

    public List<String> getPlaceAutocomplete(String input) throws IOException, InterruptedException, ApiException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyB1G-S3Qc1lFEZXojKnTMphuRjyN86woh4")
                .build();
        PlaceAutocompleteRequest.SessionToken token = new PlaceAutocompleteRequest.SessionToken();

        AutocompletePrediction[] predictions = PlacesApi.placeAutocomplete(context, input, token).await();

        List<String> suggestions = new ArrayList<>();
        for (AutocompletePrediction prediction : predictions) {
            suggestions.add(prediction.description);
        }

        return suggestions;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FarmerCardLayout;
    private javax.swing.JButton btnFarmerList;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JLabel lblFarmerAddress;
    private javax.swing.JLabel lblFarmerContact;
    private javax.swing.JLabel lblFarmerDetails;
    private javax.swing.JLabel lblFarmerEmail;
    private javax.swing.JLabel lblFarmerManagerName;
    private javax.swing.JLabel lblPharmacyName;
    private javax.swing.JTextField txtFarmerAddress;
    private javax.swing.JTextField txtFarmerContact;
    private javax.swing.JTextField txtFarmerEmail;
    private javax.swing.JTextField txtFarmerManagerName;
    private javax.swing.JTextField txtFarmerName;
    // End of variables declaration//GEN-END:variables

}
